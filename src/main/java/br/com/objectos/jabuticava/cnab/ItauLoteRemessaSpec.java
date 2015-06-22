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

import br.com.objectos.jabuticava.cnab.remessa.Comando;
import br.com.objectos.jabuticava.cnab.remessa.EspecieDeTitulo;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cep;

import org.joda.time.LocalDate;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ItauLoteRemessaSpec extends AbstractRemessaSpec<ItauLoteRemessa> implements ItauLoteRemessa {

  private final CnabKey<ItauLoteRemessa, String> idDoRegistro;
  private final CnabKey<ItauLoteRemessa, Integer> codigoDeInscricao;
  private final CnabKey<ItauLoteRemessa, CadastroRFB> numeroDeInscricao;
  private final CnabKey<ItauLoteRemessa, Integer> agencia;
  private final CnabKey<ItauLoteRemessa, String> zeros;
  private final CnabKey<ItauLoteRemessa, Integer> conta;
  private final CnabKey<ItauLoteRemessa, Integer> dac;
  private final CnabKey<ItauLoteRemessa, String> brancos;
  private final CnabKey<ItauLoteRemessa, Integer> instrucaoCancelada;
  private final CnabKey<ItauLoteRemessa, String> usoDaEmpresa;
  private final CnabKey<ItauLoteRemessa, Long> nossoNumero;
  private final CnabKey<ItauLoteRemessa, Double> quantidadeMoeda;
  private final CnabKey<ItauLoteRemessa, Integer> carteiraNumero;
  private final CnabKey<ItauLoteRemessa, String> usoDoBanco;
  private final CnabKey<ItauLoteRemessa, String> carteiraCodigo;
  private final CnabKey<ItauLoteRemessa, Comando> comando;
  private final CnabKey<ItauLoteRemessa, String> numeroDocumento;
  private final CnabKey<ItauLoteRemessa, LocalDate> vencimento;
  private final CnabKey<ItauLoteRemessa, Double> valorTitulo;
  private final CnabKey<ItauLoteRemessa, String> codigoBanco;
  private final CnabKey<ItauLoteRemessa, String> agenciaCobradora;
  private final CnabKey<ItauLoteRemessa, EspecieDeTitulo> especie;
  private final CnabKey<ItauLoteRemessa, Boolean> aceite;
  private final CnabKey<ItauLoteRemessa, LocalDate> emissao;
  private final CnabKey<ItauLoteRemessa, Integer> instrucao1;
  private final CnabKey<ItauLoteRemessa, Integer> instrucao2;
  private final CnabKey<ItauLoteRemessa, Double> moraDia;
  private final CnabKey<ItauLoteRemessa, LocalDate> descontoAte;
  private final CnabKey<ItauLoteRemessa, Double> valorDesconto;
  private final CnabKey<ItauLoteRemessa, Double> valorIOF;
  private final CnabKey<ItauLoteRemessa, Double> valorAbatimento;
  private final CnabKey<ItauLoteRemessa, Integer> sacadoInscricaoTipo;
  private final CnabKey<ItauLoteRemessa, CadastroRFB> sacadoInscricaoNumero;
  private final CnabKey<ItauLoteRemessa, String> sacadoNome;
  private final CnabKey<ItauLoteRemessa, String> brancos2;
  private final CnabKey<ItauLoteRemessa, String> sacadoLogradouro;
  private final CnabKey<ItauLoteRemessa, String> sacadoBairro;
  private final CnabKey<ItauLoteRemessa, Cep> sacadoCep;
  private final CnabKey<ItauLoteRemessa, String> sacadoCidade;
  private final CnabKey<ItauLoteRemessa, String> sacadoEstado;
  private final CnabKey<ItauLoteRemessa, String> sacadorAvalista;
  private final CnabKey<ItauLoteRemessa, String> brancos3;
  private final CnabKey<ItauLoteRemessa, LocalDate> dataMora;
  private final CnabKey<ItauLoteRemessa, Integer> prazo;
  private final CnabKey<ItauLoteRemessa, String> brancos4;
  private final CnabKey<ItauLoteRemessa, Integer> seqRegistro;

  public ItauLoteRemessaSpec() {
    idDoRegistro = id("Tipo de registro")

        .at(1, 1).colunaFixa("1").toKey();

    codigoDeInscricao = id("Código de Inscrição")

        .at(2, 3).colunaInteger().toKey();

    numeroDeInscricao = id("Número de Inscrição")

        .at(4, 17).colunaCadastroDaEmpresa().toKey();

    agencia = id("Agência")

        .at(18, 21).colunaInteger().opcional().toKey();

    zeros = id("Zeros")

        .at(22, 23).colunaFixa("00").toKey();

    conta = id("Conta")

        .at(24, 28).colunaInteger().toKey();

    dac = id("DAC")

        .at(29, 29).colunaInteger().toKey();

    brancos = id("Brancos")

        .at(30, 33).colunaFixa("    ").toKey();

    instrucaoCancelada = id("Instrução/Alegação")

        .at(34, 37).colunaInteger().opcional().toKey();

    usoDaEmpresa = id("Uso da empresa")

        .at(38, 62).colunaAlfanumerica().toKey();

    nossoNumero = id("Nosso número")

        .at(63, 70).colunaLong().toKey();

    quantidadeMoeda = id("Quantidade de moeda")

        .at(71, 83).colunaValorFinanceiro().toKey();

    carteiraNumero = id("Número da carteira")

        .at(84, 86).colunaInteger().toKey();

    usoDoBanco = id("Uso do banco")

        .at(87, 107).colunaAlfanumerica().opcional().toKey();

    carteiraCodigo = id("Carteira")

        .at(108, 108).colunaAlfanumerica().toKey();

    comando = id("Código de ocorrência")

        .at(109, 110).colunaEnum(Comando.class).toKey();

    numeroDocumento = id("Número do documento")

        .at(111, 120).colunaAlfanumerica().toKey();

    vencimento = id("Vencimento")

        .at(121, 126).colunaLocalDate().toKey();

    valorTitulo = id("Valor do título")

        .at(127, 139).colunaValorFinanceiro().toKey();

    codigoBanco = id("Código do banco")

        .at(140, 142).colunaFixa("341").toKey();

    agenciaCobradora = id("Agência cobradora")

        .at(143, 147).colunaFixa("00000").toKey();

    especie = id("Espécie")

        .at(148, 149).colunaEnum(EspecieDeTitulo.class).toKey();

    aceite = id("Aceite")

        .at(150, 150).colunaBoolean("A", "N").toKey();

    emissao = id("Data de emissão")

        .at(151, 156).colunaLocalDate().toKey();

    instrucao1 = id("Instrução 1")

        .at(157, 158).colunaInteger().toKey();

    instrucao2 = id("Instrução 2")

        .at(159, 160).colunaInteger().toKey();

    moraDia = id("Juros de 1 dia")

        .at(161, 173).colunaValorFinanceiro().toKey();

    descontoAte = id("Desconto até")

        .at(174, 179).colunaLocalDate().toKey();

    valorDesconto = id("Valor do desconto")

        .at(180, 192).colunaValorFinanceiro().toKey();

    valorIOF = id("Valor do IOF")

        .at(193, 205).colunaValorFinanceiro().toKey();

    valorAbatimento = id("Abatimento")

        .at(206, 218).colunaValorFinanceiro().toKey();

    sacadoInscricaoTipo = id("Tipo de inscrição sacado")

        .at(219, 220).colunaInteger().toKey();

    sacadoInscricaoNumero = id("Número de inscrição sacado")

        .at(221, 234).colunaCadastroDaEmpresa().toKey();

    sacadoNome = id("Nome")

        .at(235, 264).colunaAlfanumerica().toKey();

    brancos2 = id("Brancos2")

        .at(265, 274).colunaFixa("          ").toKey();

    sacadoLogradouro = id("Logradouro sacado")

        .at(275, 314).colunaAlfanumerica().toKey();

    sacadoBairro = id("Bairro sacado")

        .at(315, 326).colunaAlfanumerica().opcional().toKey();

    sacadoCep = id("CEP sacado")

        .at(327, 334).colunaCep().toKey();

    sacadoCidade = id("Cidade sacado")

        .at(335, 349).colunaAlfanumerica().toKey();

    sacadoEstado = id("Estado sacado")

        .at(350, 351).colunaAlfanumerica().toKey();

    sacadorAvalista = id("Sacador/Avalista")

        .at(352, 381).colunaAlfanumerica().toKey();

    brancos3 = id("Brancos3")

        .at(382, 385).colunaFixa("    ").toKey();

    dataMora = id("Data de mora")

        .at(386, 391).colunaLocalDate().opcional().toKey();

    prazo = id("Prazo")

        .at(392, 393).colunaInteger().toKey();

    brancos4 = id("Brancos4")

        .at(394, 394).colunaFixa(" ").toKey();

    seqRegistro = id("Número Seqüencial")

        .at(395, 400).colunaInteger().toKey();
  }

  @Override
  Class<ItauLoteRemessa> getBancoKeyClass() {
    return ItauLoteRemessa.class;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> idDoRegistro() {
    return idDoRegistro;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> codigoDeInscricao() {
    return codigoDeInscricao;
  }

  @Override
  public CnabKey<ItauLoteRemessa, CadastroRFB> numeroDeInscricao() {
    return numeroDeInscricao;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> agencia() {
    return agencia;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> zeros() {
    return zeros;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> conta() {
    return conta;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> dac() {
    return dac;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> brancos() {
    return brancos;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> instrucaoCancelada() {
    return instrucaoCancelada;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> usoDaEmpresa() {
    return usoDaEmpresa;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Long> nossoNumero() {
    return nossoNumero;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Double> quantidadeMoeda() {
    return quantidadeMoeda;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> carteiraNumero() {
    return carteiraNumero;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> usoDoBanco() {
    return usoDoBanco;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> carteiraCodigo() {
    return carteiraCodigo;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Comando> comando() {
    return comando;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> numeroDocumento() {
    return numeroDocumento;
  }

  @Override
  public CnabKey<ItauLoteRemessa, LocalDate> vencimento() {
    return vencimento;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Double> valorTitulo() {
    return valorTitulo;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> codigoBanco() {
    return codigoBanco;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> agenciaCobradora() {
    return agenciaCobradora;
  }

  @Override
  public CnabKey<ItauLoteRemessa, EspecieDeTitulo> especie() {
    return especie;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Boolean> aceite() {
    return aceite;
  }

  @Override
  public CnabKey<ItauLoteRemessa, LocalDate> emissao() {
    return emissao;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> instrucao1() {
    return instrucao1;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> instrucao2() {
    return instrucao2;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Double> moraDia() {
    return moraDia;
  }

  @Override
  public CnabKey<ItauLoteRemessa, LocalDate> descontoAte() {
    return descontoAte;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Double> valorDesconto() {
    return valorDesconto;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Double> valorIOF() {
    return valorIOF;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Double> valorAbatimento() {
    return valorAbatimento;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> sacadoInscricaoTipo() {
    return sacadoInscricaoTipo;
  }

  @Override
  public CnabKey<ItauLoteRemessa, CadastroRFB> sacadoInscricaoNumero() {
    return sacadoInscricaoNumero;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> sacadoNome() {
    return sacadoNome;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> brancos2() {
    return brancos2;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> sacadoLogradouro() {
    return sacadoLogradouro;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> sacadoBairro() {
    return sacadoBairro;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Cep> sacadoCep() {
    return sacadoCep;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> sacadoCidade() {
    return sacadoCidade;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> sacadoEstado() {
    return sacadoEstado;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> sacadorAvalista() {
    return sacadorAvalista;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> brancos3() {
    return brancos3;
  }

  @Override
  public CnabKey<ItauLoteRemessa, LocalDate> dataMora() {
    return dataMora;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> prazo() {
    return prazo;
  }

  @Override
  public CnabKey<ItauLoteRemessa, String> brancos4() {
    return brancos4;
  }

  @Override
  public CnabKey<ItauLoteRemessa, Integer> seqRegistro() {
    return seqRegistro;
  }

}