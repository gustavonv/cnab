/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.cnab;

import static br.com.objectos.cnab.Bradesco.headerRemessa;
import static br.com.objectos.cnab.Bradesco.loteRemessa;
import static br.com.objectos.cnab.Bradesco.trailerRemessa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Estado;
import br.com.objectos.cnab.bradesco.TipoDeIncricaoDoSacado;
import br.com.objectos.cnab.remessa.Cedente;
import br.com.objectos.cnab.remessa.Cobranca;
import br.com.objectos.cnab.remessa.CobrancaOpcoes;
import br.com.objectos.cnab.remessa.Endereco;
import br.com.objectos.cnab.remessa.Instrucao;
import br.com.objectos.cnab.remessa.Sacado;
import br.com.objectos.cnab.remessa.Titulo;
import br.com.objectos.core.lang.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class BradescoRemessaBuilder extends AbstractRemessaBuilder {

  private int sequencia = 2;

  public BradescoRemessaBuilder(Banco banco) {
    super(banco);
  }

  @Override
  protected List<String> build() {
    List<String> lines = new ArrayList<>();

    lines.add(doHeader());

    doLotes().forEach(line -> lines.add(line));

    lines.add(doTrailer());

    return lines;
  }

  private String doHeader() {
    return HeaderRemessa.paraBanco(banco)

        .put(headerRemessa().codigoEmpresa(), empresa.getCodigo())
        .put(headerRemessa().nomeEmpresa(), empresa.getRazaoSocial())
        .put(headerRemessa().dataArquivo(), dataArquivo)
        .put(headerRemessa().seqRemessa(), sequenciaArquivo)

        .toString();
  }

  private Stream<String> doLotes() {
    return cobrancas.stream().map(this::doLotes0);
  }

  private String doLotes0(Cobranca cobranca) {
    String idDaEmpresa = new BradescoCarteira(cobranca).toString();

    CobrancaOpcoes opcoes = cobranca.getOpcoes();
    Instrucao instrucao1 = opcoes.getInstrucao1();
    int instrucao1Value = instrucao1.getCodigo();

    Instrucao instrucao2 = opcoes.getInstrucao2();
    int instrucao2Value = instrucao2.getCodigo();

    switch (instrucao1.getCodigo()) {
    case 5: // protesto falimentar
    case 6: // protesto
    case 18: // decurso prazo
      instrucao2Value = instrucao1.intValue();
      break;
    }

    Titulo titulo = cobranca.getTitulo();

    Cedente cedente = titulo.getCedente();
    BradescoSacadorAvalista sacadorAvalista;
    sacadorAvalista = BradescoSacadorAvalista.of(cedente.getCadastroRFB(), cedente.getNome());

    Sacado sacado = titulo.getSacado();
    CadastroRFB cadastroSacado = sacado.getCadastroRFB();
    TipoDeIncricaoDoSacado tipoDeIncricaoDoSacado;
    tipoDeIncricaoDoSacado = TipoDeIncricaoDoSacado.valueOf(cadastroSacado);
    Endereco endereco = sacado.getEndereco();

    return LoteRemessa.paraBanco(banco)

        // cobranca
        .put(loteRemessa().comando(), cobranca.getComando())
        .put(loteRemessa().idDoCedenteNoBanco(), idDaEmpresa)

        // opções
        .put(loteRemessa().aceite(), opcoes.isAceite())
        .put(loteRemessa().codigoDoBanco(), opcoes.isDebitoAutomatico() ? 237 : 0)
        .put(loteRemessa().condicaoParaEmissaoDeCobranca(), opcoes.isCobrancaSimples() ? 2 : 1)
        .put(loteRemessa().primeiraInstrucao(), instrucao1Value)
        .put(loteRemessa().segundaInstrucao(), instrucao2Value)
        .put(loteRemessa().valorCobradoPorAtraso(), opcoes.getMoraDia())

        // titulo
        .put(loteRemessa().numeroDeControleDoParticipante(), titulo.getUsoDaEmpresa())
        .put(loteRemessa().especieDeTitulo(), titulo.getEspecie())
        .put(loteRemessa().idDoTituloNoBanco(), titulo.getNossoNumero())
        .put(loteRemessa().numeroDoDocumento(), titulo.getNumero())
        .put(loteRemessa().emissaoDoTitulo(), titulo.getEmissao().orElse(null))
        .put(loteRemessa().vencimentoDoTitulo(), titulo.getVencimento())
        .put(loteRemessa().valorDoTitulo(), titulo.getValor())
        .put(loteRemessa().valorIOF(), titulo.getValorIof())
        .put(loteRemessa().valorDesconto(), titulo.getValorDesconto())
        .put(loteRemessa().valorAbatimento(), titulo.getValorAbatimento())

        // cedente
        .put(loteRemessa().sacadoAvalista(), sacadorAvalista.toString())

        // sacado
        .put(loteRemessa().tipoDeInscricaoDoSacado(), tipoDeIncricaoDoSacado)
        .put(loteRemessa().numeroDeInscricaoDoSacado(), cadastroSacado)
        .put(loteRemessa().nomeDoSacado(), sacado.getNome())
        .put(loteRemessa().enderecoDoSacado(), endereco(endereco))
        .put(loteRemessa().cep(), endereco.getCep())

        .put(loteRemessa().numeroSequencialDoRegistro(), sequencia++)

        .toString();
  }

  private String doTrailer() {
    return TrailerRemessa.paraBanco(banco)

        .put(trailerRemessa().seqRegistro(), sequencia++)

        .toString();
  }

  private String endereco(Endereco e) {
    String _l = Strings.emptyToNull(e.getLogradouro());
    String _c = Strings.emptyToNull(e.getCidade());
    Estado estado = e.getEstado().orElse(null);
    return Stream.of(_l, _c, estado)
        .filter(o -> o != null)
        .map(Object::toString)
        .collect(Collectors.joining(", "));
  }

}