/*
 * Copyright 2016 Objectos, Fábrica de Software LTDA.
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

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.objectos.core.lang.Strings;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Estado;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Bradesco extends Banco {

  private static final Bradesco INSTANCE = new Bradesco();

  private Bradesco() {
  }

  public static Bradesco instance() {
    return INSTANCE;
  }

  @Override
  public RetornoBradesco read(String txt) {
    return RetornoBradesco.read(txt);
  }

  @Override
  void writeRemessaTo(Remessa remessa, FlatWriter writer) {
    RemessaBradesco container = RemessaBradesco.builder()
        .header(header(remessa))
        .trxList(trxList(remessa))
        .trailer(trailer(remessa))
        .build();
    container.writeTo(writer);
  }

  private RemessaBradescoHeader header(Remessa remessa) {
    Empresa empresa = remessa.empresa();
    return RemessaBradescoHeader.builder()
        .codigoEmpresa(empresa.codigo())
        .razaoSocial(empresa.razaoSocial())
        .dataArquivo(remessa.data())
        .seqRemessa(remessa.sequencia())
        .build();
  }

  private List<RemessaBradescoTrx> trxList(Remessa remessa) {
    AtomicInteger autoInc = new AtomicInteger(2);
    return remessa.cobrancaList()
        .stream()
        .map(c -> toTransacao(autoInc.getAndIncrement(), c))
        .collect(Collectors.toList());
  }

  private RemessaBradescoTrailer trailer(Remessa remessa) {
    return RemessaBradescoTrailer.builder()
        .seq(remessa.cobrancaList().size() + 2)
        .build();
  }

  private RemessaBradescoTrx toTransacao(int seq, Cobranca cobranca) {
    Agencia agencia = cobranca.agencia();
    Conta conta = cobranca.conta();
    Titulo titulo = cobranca.titulo();

    Sacado sacado = titulo.sacado();
    CadastroRFB cadastroSacado = sacado.cadastroRfb();
    TipoSacadoBradesco tipoDeIncricaoDoSacado;
    tipoDeIncricaoDoSacado = TipoSacadoBradesco.valueOf(cadastroSacado);
    Endereco endereco = sacado.endereco();

    Cedente cedente = titulo.cedente();

    Instrucao instrucao1 = cobranca.instrucao1();
    int instrucao1Value = instrucao1.codigo();

    Instrucao instrucao2 = cobranca.instrucao2();
    int instrucao2Value = instrucao2.codigo();

    switch (instrucao1.codigo()) {
    case 5: // protesto falimentar
    case 6: // protesto
    case 18: // decurso prazo
      instrucao2Value = instrucao1.valor();
      break;
    }

    return RemessaBradescoTrx.builder()
        .agenciaCredito(0)
        .agenciaCreditoDigito(0)
        .razaoContaCorrente(0)
        .contaCorrenteCredito(0)
        .contaCorrenteCreditoDigito(0)
        .carteira(CarteiraBradesco.of(cobranca.carteira()))
        .agencia(agencia.numero())
        .contaCorrente(conta.numero())
        .contaCorrenteDigito(conta.digito())
        .usoDaEmpresa(titulo.usoEmpresa())
        .multa(false)
        .percentualMulta(0)
        .nossoNumero(titulo.nossoNumero())
        .descontoBonificacaoPorDia(0)
        .condicaoParaEmissaoDeCobranca(1)
        .debitoAutomatico(true)
        .rateiroCredito(false)
        .enderecamentoParaAvisoDeDebito(EnderecamentoDebitoAutomatico.CADASTRO_CONSTANTE)
        .ocorrencia(cobranca.comando())
        .numero(titulo.numero())
        .vencimento(titulo.vencimento())
        .valor(titulo.valor())
        .especie(titulo.especie())
        .aceite(cobranca.aceite())
        .emissao(titulo.emissao())
        .primeiraInstrucao(instrucao1Value)
        .segundaInstrucao(instrucao2Value)
        .moraDia(cobranca.moraDia())
        .limiteParaConcessaoDeDesconto()
        .valorDesconto(titulo.valorDesconto())
        .valorIof(titulo.valorIof())
        .valorAbatimento(titulo.valorAbatimento())
        .tipoDeInscricaoDoSacado(tipoDeIncricaoDoSacado)
        .numeroDeInscricaoDoSacado(cadastroSacado)
        .nomeDoSacado(sacado.nome())
        .enderecoDoSacado(endereco(endereco))
        .primeiraMensagem("")
        .cep(endereco.cep())
        .sacadorAvalista(SacadorAvalistaBradesco.of(cedente.cadastroRfb(), cedente.nome()))
        .numeroSequencialDoRegistro(seq)
        .build();
  }

  private String endereco(Endereco e) {
    String _l = Strings.emptyToNull(e.logradouro());
    String _c = Strings.emptyToNull(e.cidade());
    Estado estado = e.estado();
    return Stream.of(_l, _c, estado)
        .filter(o -> o != null)
        .map(Object::toString)
        .filter(s -> !s.trim().isEmpty())
        .collect(Collectors.joining(", "));
  }

}