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

import java.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class BradescoHeaderRemessaSpec
    extends AbstractRemessaSpec<BradescoHeaderRemessa> implements BradescoHeaderRemessa {

  private final CnabKey<BradescoHeaderRemessa, String> idDoRegistro;
  private final CnabKey<BradescoHeaderRemessa, String> idDoArquivo;
  private final CnabKey<BradescoHeaderRemessa, String> literalRemessa;
  private final CnabKey<BradescoHeaderRemessa, String> codigoServico;
  private final CnabKey<BradescoHeaderRemessa, String> literalServico;
  private final CnabKey<BradescoHeaderRemessa, Long> codigoEmpresa;
  private final CnabKey<BradescoHeaderRemessa, String> nomeEmpresa;
  private final CnabKey<BradescoHeaderRemessa, String> numeroBanco;
  private final CnabKey<BradescoHeaderRemessa, String> nomeBanco;
  private final CnabKey<BradescoHeaderRemessa, LocalDate> dataArquivo;
  private final CnabKey<BradescoHeaderRemessa, String> branco;
  private final CnabKey<BradescoHeaderRemessa, String> idSistema;
  private final CnabKey<BradescoHeaderRemessa, Integer> seqRemessa;
  private final CnabKey<BradescoHeaderRemessa, String> branco2;
  private final CnabKey<BradescoHeaderRemessa, String> seqRegistro;

  BradescoHeaderRemessaSpec() {
    idDoRegistro = id("Identificação do registro")

        .at(1, 1).colunaFixa("0").toKey();

    idDoArquivo = id("Identificação do Arquivo Remessa")

        .at(2, 2).colunaFixa("1").toKey();

    literalRemessa = id("Literal Remessa")

        .at(3, 9).colunaFixa("REMESSA").toKey();

    codigoServico = id("Código de Serviço")

        .at(10, 11).colunaFixa("01").toKey();

    literalServico = id("Literal Serviço")

        .at(12, 26).colunaFixa("COBRANCA       ").toKey();

    codigoEmpresa = id("Código da Empresa")

        .at(27, 46).colunaLong().toKey();

    nomeEmpresa = id("Nome da Empresa")

        .at(47, 76).colunaAlfanumerica().toKey();

    numeroBanco = id("Número do Banco")

        .at(77, 79).colunaFixa("237").toKey();

    nomeBanco = id("Nome do Banco por Extenso")

        .at(80, 94).colunaFixa("BRADESCO       ").toKey();

    dataArquivo = id("Data da Gravação do Arquivo")

        .at(95, 100).colunaLocalDate().toKey();

    branco = id("Branco")

        .at(101, 108).colunaBranco().toKey();

    idSistema = id("Identificação do sistema")

        .at(109, 110).colunaFixa("MX").toKey();

    seqRemessa = id("No. sequencial de Remessa")

        .at(111, 117).colunaInteger().toKey();

    branco2 = id("Branco2")

        .at(118, 394).colunaBranco().toKey();

    seqRegistro = id("No. sequencial do Registro")

        .at(395, 400).colunaFixa("000001").toKey();
  }

  @Override
  Class<BradescoHeaderRemessa> getBancoKeyClass() {
    return BradescoHeaderRemessa.class;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> idDoRegistro() {
    return idDoRegistro;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> idDoArquivo() {
    return idDoArquivo;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> literalRemessa() {
    return literalRemessa;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> codigoServico() {
    return codigoServico;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> literalServico() {
    return literalServico;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, Long> codigoEmpresa() {
    return codigoEmpresa;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> nomeEmpresa() {
    return nomeEmpresa;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> numeroBanco() {
    return numeroBanco;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> nomeBanco() {
    return nomeBanco;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, LocalDate> dataArquivo() {
    return dataArquivo;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> branco() {
    return branco;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> idSistema() {
    return idSistema;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, Integer> seqRemessa() {
    return seqRemessa;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> branco2() {
    return branco2;
  }

  @Override
  public CnabKey<BradescoHeaderRemessa, String> seqRegistro() {
    return seqRegistro;
  }

}