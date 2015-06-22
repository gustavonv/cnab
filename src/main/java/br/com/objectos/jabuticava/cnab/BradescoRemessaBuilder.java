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
package br.com.objectos.jabuticava.cnab;

import static br.com.objectos.jabuticava.cnab.Bradesco.headerRemessa;
import static br.com.objectos.jabuticava.cnab.Bradesco.loteRemessa;
import static br.com.objectos.jabuticava.cnab.Bradesco.trailerRemessa;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

import java.util.List;

import br.com.objectos.jabuticava.cnab.bradesco.TipoDeIncricaoDoSacado;
import br.com.objectos.jabuticava.cnab.remessa.Cedente;
import br.com.objectos.jabuticava.cnab.remessa.Cobranca;
import br.com.objectos.jabuticava.cnab.remessa.CobrancaOpcoes;
import br.com.objectos.jabuticava.cnab.remessa.Endereco;
import br.com.objectos.jabuticava.cnab.remessa.Instrucao;
import br.com.objectos.jabuticava.cnab.remessa.Sacado;
import br.com.objectos.jabuticava.cnab.remessa.Titulo;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Estado;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;

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
    List<String> lines = newArrayList();

    lines.add(doHeader());

    lines.addAll(doLotes());

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

  private List<String> doLotes() {
    return transform(cobrancas, new CobrancaToString());
  }

  private String doTrailer() {
    return TrailerRemessa.paraBanco(banco)

        .put(trailerRemessa().seqRegistro(), sequencia++)

        .toString();
  }

  private class CobrancaToString implements Function<Cobranca, String> {

    @Override
    public String apply(Cobranca cobranca) {
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
          .put(loteRemessa().emissaoDoTitulo(), titulo.getEmissao())
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

    private String endereco(Endereco e) {
      String _l = Strings.emptyToNull(e.getLogradouro());
      String _c = Strings.emptyToNull(e.getCidade());
      Estado estado = e.getEstado();
      return Joiner.on(", ").skipNulls().join(_l, _c, estado);
    }

  }

}