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

import static br.com.objectos.jabuticava.cnab.remessa.Caixa.ALTA;
import static br.com.objectos.jabuticava.cnab.remessa.EnderecamentoDebitoAutomatico.CADASTRO_CONSTANTE;

import br.com.objectos.jabuticava.cnab.bradesco.TipoDeIncricaoDoSacado;
import br.com.objectos.jabuticava.cnab.remessa.Comando;
import br.com.objectos.jabuticava.cnab.remessa.EnderecamentoDebitoAutomatico;
import br.com.objectos.jabuticava.cnab.remessa.EspecieDeTitulo;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cep;

import org.joda.time.LocalDate;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class BradescoLoteRemessaSpec
    extends AbstractRemessaSpec<BradescoLoteRemessa> implements BradescoLoteRemessa {

  private final CnabKey<BradescoLoteRemessa, String> idDoRegistro;
  private final CnabKey<BradescoLoteRemessa, Integer> agenciaDeDebito;
  private final CnabKey<BradescoLoteRemessa, String> digitoDaAgenciaDeDebito;
  private final CnabKey<BradescoLoteRemessa, Integer> razaoDaContaCorrente;
  private final CnabKey<BradescoLoteRemessa, Integer> contaCorrente;
  private final CnabKey<BradescoLoteRemessa, String> digitoDaContaCorrente;
  private final CnabKey<BradescoLoteRemessa, String> idDoCedenteNoBanco;
  private final CnabKey<BradescoLoteRemessa, String> numeroDeControleDoParticipante;
  private final CnabKey<BradescoLoteRemessa, Integer> codigoDoBanco;
  private final CnabKey<BradescoLoteRemessa, String> zeros;
  private final CnabKey<BradescoLoteRemessa, Long> idDoTituloNoBanco;
  // private final CnabKey<BradescoLoteRemessa, String> digitoDeAutoConferencia;
  private final CnabKey<BradescoLoteRemessa, Double> descontoBonificacaoPorDia;
  private final CnabKey<BradescoLoteRemessa, Integer> condicaoParaEmissaoDeCobranca;
  private final CnabKey<BradescoLoteRemessa, String> idParaEmissaoDeDebito;
  private final CnabKey<BradescoLoteRemessa, String> idDaOperacaoNoBanco;
  private final CnabKey<BradescoLoteRemessa, Boolean> indicadorRateioCredito;
  private final CnabKey<BradescoLoteRemessa, EnderecamentoDebitoAutomatico> enderecamentoParaAvisoDeDebito;
  private final CnabKey<BradescoLoteRemessa, String> brancos;
  private final CnabKey<BradescoLoteRemessa, br.com.objectos.jabuticava.cnab.remessa.Comando> idDaOcorrencia;
  private final CnabKey<BradescoLoteRemessa, String> numeroDoDocumento;
  private final CnabKey<BradescoLoteRemessa, LocalDate> vencimentoDoTitulo;
  private final CnabKey<BradescoLoteRemessa, Double> valorDoTitulo;
  private final CnabKey<BradescoLoteRemessa, String> bancoEncarregadoDaCobranca;
  private final CnabKey<BradescoLoteRemessa, String> agenciaDepositaria;
  private final CnabKey<BradescoLoteRemessa, EspecieDeTitulo> especieDeTitulo;
  private final CnabKey<BradescoLoteRemessa, Boolean> aceite;
  private final CnabKey<BradescoLoteRemessa, LocalDate> emissaoDoTitulo;
  private final CnabKey<BradescoLoteRemessa, Integer> primeiraInstrucao;
  private final CnabKey<BradescoLoteRemessa, Integer> segundaInstrucao;
  private final CnabKey<BradescoLoteRemessa, Double> valorCobradoPorAtraso;
  private final CnabKey<BradescoLoteRemessa, LocalDate> limiteParaConcessaoDeDesconto;
  private final CnabKey<BradescoLoteRemessa, Double> valorDesconto;
  private final CnabKey<BradescoLoteRemessa, Double> valorIOF;
  private final CnabKey<BradescoLoteRemessa, Double> valorAbatimento;
  private final CnabKey<BradescoLoteRemessa, TipoDeIncricaoDoSacado> tipoDeInscricaoDoSacado;
  private final CnabKey<BradescoLoteRemessa, CadastroRFB> numeroDeInscricaoDoSacado;
  private final CnabKey<BradescoLoteRemessa, String> nomeDoSacado;
  private final CnabKey<BradescoLoteRemessa, String> enderecoDoSacado;
  private final CnabKey<BradescoLoteRemessa, String> primeiraMensagem;
  private final CnabKey<BradescoLoteRemessa, Cep> cep;
  private final CnabKey<BradescoLoteRemessa, String> sacadoAvalista;
  private final CnabKey<BradescoLoteRemessa, Integer> numeroSequencialDoRegistro;

  BradescoLoteRemessaSpec() {
    idDoRegistro = id("Identificação do registro")

        .at(1, 1).colunaFixa("1").toKey();

    agenciaDeDebito = id("Agência de Débito")

        .at(2, 6).colunaInteger().opcional().toKey();

    digitoDaAgenciaDeDebito = id("Dígito da Agência de Débito")

        .at(7, 7).colunaAlfanumerica().opcional().toKey();

    razaoDaContaCorrente = id("Razão da Conta Corrente")

        .at(8, 12).colunaInteger().opcional().toKey();

    contaCorrente = id("Conta Corrente")

        .at(13, 19).colunaInteger().opcional().toKey();

    digitoDaContaCorrente = id("Dígito da Conta Corrente")

        .at(20, 20).colunaAlfanumerica().opcional().toKey();

    idDoCedenteNoBanco = id("Identificação da Empresa Cedente no Banco")

        .at(21, 37).colunaAlfanumerica().toKey();

    numeroDeControleDoParticipante = id("Nº Controle do Participante")

        .at(38, 62).colunaAlfanumerica().toKey();

    codigoDoBanco = id("Código do Banco a ser debitado na Câmara de Compensação")

        .at(63, 65).colunaInteger().toKey();

    zeros = id("Zeros")

        .at(66, 70).colunaFixa("00000").toKey();

    idDoTituloNoBanco = id("Identificação do Título no Banco")

        .at(71, 82).colunaLong().toKey();

    // digitoDeAutoConferencia =
    // id("Digito de Auto Conferencia do Nosso Número")
    //
    // .at(82, 82).colunaAlfanumerica().toKey();

    descontoBonificacaoPorDia = id("Desconto Bonificação por dia")

        .at(83, 92).colunaValorFinanceiro().opcional().toKey();

    condicaoParaEmissaoDeCobranca = id("Condição para Emissão da Papeleta de Cobrança")

        .at(93, 93).colunaInteger().toKey();

    idParaEmissaoDeDebito = id("Ident. se emite papeleta para Débito Automático")

        .at(94, 94).colunaAlfanumerica().opcional().toKey();

    idDaOperacaoNoBanco = id("Identificação da Operação do Banco")

        .at(95, 104).colunaFixa("          ").toKey();

    indicadorRateioCredito = id("Indicador Rateio Crédito")

        .at(105, 105).colunaBoolean("R", " ").toKey();

    enderecamentoParaAvisoDeDebito = id("Endereçamento para Aviso do Débito Automático em CC")

        .at(106, 106)
        .colunaEnum(EnderecamentoDebitoAutomatico.class, CADASTRO_CONSTANTE).toKey();

    brancos = id("Brancos")

        .at(107, 108).colunaFixa("  ").toKey();

    idDaOcorrencia = id("Identificação ocorrência")

        .at(109, 110).colunaEnum(Comando.class).toKey();

    numeroDoDocumento = id("No do Documento")

        .at(111, 120).colunaAlfanumerica().toKey();

    vencimentoDoTitulo = id("Data do Vencimento do Título")

        .at(121, 126).colunaLocalDate().toKey();

    valorDoTitulo = id("Valor do Título")

        .at(127, 139).colunaValorFinanceiro().toKey();

    bancoEncarregadoDaCobranca = id("Banco Encarregado da Cobrança")

        .at(140, 142).colunaFixa("000").toKey();

    agenciaDepositaria = id("Agência Depositária")

        .at(143, 147).colunaFixa("00000").toKey();

    especieDeTitulo = id("Espécie de Título")

        .at(148, 149).colunaEnum(EspecieDeTitulo.class).toKey();

    aceite = id("Aceite")

        .at(150, 150).colunaBoolean("A", "N").toKey();

    emissaoDoTitulo = id("Data da emissão do Título")

        .at(151, 156).colunaLocalDate().toKey();

    primeiraInstrucao = id("1ª instrução")

        .at(157, 158).colunaInteger().toKey();

    segundaInstrucao = id("2ª instrução")

        .at(159, 160).colunaInteger().toKey();

    valorCobradoPorAtraso = id("Valor a ser cobrado por Dia de Atraso")

        .at(161, 173).colunaValorFinanceiro().toKey();

    limiteParaConcessaoDeDesconto = id("Data Limite P/Concessão de Desconto")

        .at(174, 179).colunaLocalDate().toKey();

    valorDesconto = id("Valor do Desconto")

        .at(180, 192).colunaValorFinanceiro().toKey();

    valorIOF = id("Valor do IOF")

        .at(193, 205).colunaValorFinanceiro().toKey();

    valorAbatimento = id("Valor do Abatimento a ser concedido ou cancelado")

        .at(206, 218).colunaValorFinanceiro().toKey();

    tipoDeInscricaoDoSacado = id("Identificação do Tipo de Inscrição do Sacado")

        .at(219, 220).colunaEnum(TipoDeIncricaoDoSacado.class).toKey();

    numeroDeInscricaoDoSacado = id("No Inscrição do Sacado")

        .at(221, 234).colunaCadastroDaEmpresa().toKey();

    nomeDoSacado = id("Nome do Sacado")

        .at(235, 274).colunaAlfanumerica(ALTA).toKey();

    enderecoDoSacado = id("Endereço Completo")

        .at(275, 314).colunaAlfanumerica().toKey();

    primeiraMensagem = id("1ª Mensagem")

        .at(315, 326).colunaAlfanumerica().opcional().toKey();

    cep = id("CEP")

        .at(327, 334).colunaCep().toKey();

    sacadoAvalista = id("Sacador/Avalista ou 2ª Mensagem")

        .at(335, 394).colunaAlfanumerica().toKey();

    numeroSequencialDoRegistro = id("No Seqüencial do Registro")

        .at(395, 400).colunaInteger().toKey();
  }

  @Override
  Class<BradescoLoteRemessa> getBancoKeyClass() {
    return BradescoLoteRemessa.class;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> idDoRegistro() {
    return idDoRegistro;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Integer> agenciaDeDebito() {
    return agenciaDeDebito;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> digitoDaAgenciaDeDebito() {
    return digitoDaAgenciaDeDebito;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Integer> razaoDaContaCorrente() {
    return razaoDaContaCorrente;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Integer> contaCorrente() {
    return contaCorrente;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> digitoDaContaCorrente() {
    return digitoDaContaCorrente;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> idDoCedenteNoBanco() {
    return idDoCedenteNoBanco;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> numeroDeControleDoParticipante() {
    return numeroDeControleDoParticipante;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Integer> codigoDoBanco() {
    return codigoDoBanco;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> zeros() {
    return zeros;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Long> idDoTituloNoBanco() {
    return idDoTituloNoBanco;
  }

  // @Override
  // public CnabKey<BradescoLoteRemessa, String> digitoDeAutoConferencia() {
  // return digitoDeAutoConferencia;
  // }

  @Override
  public CnabKey<BradescoLoteRemessa, Double> descontoBonificacaoPorDia() {
    return descontoBonificacaoPorDia;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Integer> condicaoParaEmissaoDeCobranca() {
    return condicaoParaEmissaoDeCobranca;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> idParaEmissaoDeDebito() {
    return idParaEmissaoDeDebito;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> idDaOperacaoNoBanco() {
    return idDaOperacaoNoBanco;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Boolean> indicadorRateioCredito() {
    return indicadorRateioCredito;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, EnderecamentoDebitoAutomatico> enderecamentoParaAvisoDeDebito() {
    return enderecamentoParaAvisoDeDebito;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> brancos() {
    return brancos;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, br.com.objectos.jabuticava.cnab.remessa.Comando> comando() {
    return idDaOcorrencia;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> numeroDoDocumento() {
    return numeroDoDocumento;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, LocalDate> vencimentoDoTitulo() {
    return vencimentoDoTitulo;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Double> valorDoTitulo() {
    return valorDoTitulo;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> bancoEncarregadoDaCobranca() {
    return bancoEncarregadoDaCobranca;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> agenciaDepositaria() {
    return agenciaDepositaria;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, EspecieDeTitulo> especieDeTitulo() {
    return especieDeTitulo;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Boolean> aceite() {
    return aceite;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, LocalDate> emissaoDoTitulo() {
    return emissaoDoTitulo;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Integer> primeiraInstrucao() {
    return primeiraInstrucao;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Integer> segundaInstrucao() {
    return segundaInstrucao;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Double> valorCobradoPorAtraso() {
    return valorCobradoPorAtraso;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, LocalDate> limiteParaConcessaoDeDesconto() {
    return limiteParaConcessaoDeDesconto;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Double> valorDesconto() {
    return valorDesconto;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Double> valorIOF() {
    return valorIOF;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Double> valorAbatimento() {
    return valorAbatimento;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, TipoDeIncricaoDoSacado> tipoDeInscricaoDoSacado() {
    return tipoDeInscricaoDoSacado;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, CadastroRFB> numeroDeInscricaoDoSacado() {
    return numeroDeInscricaoDoSacado;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> nomeDoSacado() {
    return nomeDoSacado;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> enderecoDoSacado() {
    return enderecoDoSacado;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> primeiraMensagem() {
    return primeiraMensagem;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Cep> cep() {
    return cep;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, String> sacadoAvalista() {
    return sacadoAvalista;
  }

  @Override
  public CnabKey<BradescoLoteRemessa, Integer> numeroSequencialDoRegistro() {
    return numeroSequencialDoRegistro;
  }

}