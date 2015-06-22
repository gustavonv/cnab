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

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ItauHeaderRemessaSpec
    extends AbstractRemessaSpec<ItauHeaderRemessa> implements ItauHeaderRemessa {

  private final CnabKey<ItauHeaderRemessa, String> tipoDeRegistro;
  private final CnabKey<ItauHeaderRemessa, String> operacao;
  private final CnabKey<ItauHeaderRemessa, String> literalRemessa;
  private final CnabKey<ItauHeaderRemessa, String> codigoServico;
  private final CnabKey<ItauHeaderRemessa, String> literalServico;
  private final CnabKey<ItauHeaderRemessa, Integer> agencia;
  private final CnabKey<ItauHeaderRemessa, String> zeros;
  private final CnabKey<ItauHeaderRemessa, Integer> conta;
  private final CnabKey<ItauHeaderRemessa, Integer> dac;
  private final CnabKey<ItauHeaderRemessa, String> brancos;
  private final CnabKey<ItauHeaderRemessa, String> nomeEmpresa;
  private final CnabKey<ItauHeaderRemessa, String> codigoBanco;
  private final CnabKey<ItauHeaderRemessa, String> nomeBanco;
  private final CnabKey<ItauHeaderRemessa, LocalDate> dataGeracao;
  private final CnabKey<ItauHeaderRemessa, String> brancos2;
  private final CnabKey<ItauHeaderRemessa, String> seqRegistro;

  public ItauHeaderRemessaSpec() {
    tipoDeRegistro = id("Tipo de registro")

        .at(1, 1).colunaFixa("0").toKey();

    operacao = id("Operação")

        .at(2, 2).colunaFixa("1").toKey();

    literalRemessa = id("Literal Remessa")

        .at(3, 9).colunaFixa("REMESSA").toKey();

    codigoServico = id("Código de Serviço")

        .at(10, 11).colunaFixa("01").toKey();

    literalServico = id("Literal Serviço")

        .at(12, 26).colunaFixa("COBRANCA       ").toKey();

    agencia = id("Agência")

        .at(27, 30).colunaInteger().toKey();

    zeros = id("Zeros")

        .at(31, 32).colunaFixa("00").toKey();

    conta = id("Conta")

        .at(33, 37).colunaInteger().toKey();

    dac = id("DAC")

        .at(38, 38).colunaInteger().toKey();

    brancos = id("Brancos")

        .at(39, 46).colunaBranco().toKey();

    nomeEmpresa = id("Nome da empresa")

        .at(47, 76).colunaAlfanumerica().toKey();

    codigoBanco = id("Código do banco")

        .at(77, 79).colunaFixa("341").toKey();

    nomeBanco = id("Nome do banco")

        .at(80, 94).colunaFixa("BANCO ITAU SA  ").toKey();

    dataGeracao = id("Data de geração")

        .at(95, 100).colunaLocalDate().toKey();

    brancos2 = id("Brancos 2")

        .at(101, 394).colunaBranco().toKey();

    seqRegistro = id("No. sequencial do Registro")

        .at(395, 400).colunaFixa("000001").toKey();
  }

  @Override
  Class<ItauHeaderRemessa> getBancoKeyClass() {
    return ItauHeaderRemessa.class;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> tipoDeRegistro() {
    return tipoDeRegistro;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> operacao() {
    return operacao;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> literalRemessa() {
    return literalRemessa;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> codigoServico() {
    return codigoServico;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> literalServico() {
    return literalServico;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, Integer> agencia() {
    return agencia;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> zeros() {
    return zeros;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, Integer> conta() {
    return conta;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, Integer> dac() {
    return dac;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> brancos() {
    return brancos;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> nomeEmpresa() {
    return nomeEmpresa;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> codigoBanco() {
    return codigoBanco;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> nomeBanco() {
    return nomeBanco;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, LocalDate> dataGeracao() {
    return dataGeracao;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> brancos2() {
    return brancos2;
  }

  @Override
  public CnabKey<ItauHeaderRemessa, String> seqRegistro() {
    return seqRegistro;
  }

}