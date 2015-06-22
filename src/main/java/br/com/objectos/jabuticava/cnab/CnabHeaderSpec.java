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

import br.com.objectos.jabuticava.cnab.CnabKey.Construtor;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CnabHeaderSpec extends AbstractSpec implements CnabHeader {

  private final CnabKey<CnabHeader, Integer> CODIGO_RETORNO = cnabKey()
      .id("ID do Arquivo Retorno").at(1, 2).get(Integer.class);

  private final CnabKey<CnabHeader, String> LITERAL_RETORNO = cnabKey()
      .id("Literal Retorno").at(2, 9).get(String.class);

  private final CnabKey<CnabHeader, Integer> CODIGO_SERVICO = cnabKey()
      .id("Código do Serviço").at(9, 11).get(Integer.class);

  private final CnabKey<CnabHeader, String> LITERAL_SERVICO = cnabKey()
      .id("Literal Serviço").at(11, 26).get(String.class);

  private final CnabKey<CnabHeader, String> NOME_EMPRESA = cnabKey()
      .id("Nome da Empresa por Extenso").at(46, 76).get(String.class);

  private final CnabKey<CnabHeader, Integer> NUMERO_BANCO = cnabKey()
      .id("No. Bradesco").at(76, 79).get(Integer.class);

  private final CnabKey<CnabHeader, String> NOME_BANCO = cnabKey()
      .id("Nome do Banco por Extenso").at(79, 94).get(String.class);

  private final CnabKey<CnabHeader, LocalDate> DATA_GRAVACAO_ARQUIVO = cnabKey()
      .id("Data da Gravação do Arquivo").at(94, 100).get(LocalDate.class);

  private final CnabKey<CnabHeader, Integer> NUMERO_AVISO_BANCARIO = cnabKey()
      .id("No. Aviso Bancário").at(108, 113).get(Integer.class);

  private final CnabKey<CnabHeader, LocalDate> DATA_CREDITO = cnabKey()
      .id("Data Crédito").at(379, 385).get(LocalDate.class);

  private final CnabKey<CnabHeader, Integer> NUMERO_REGISTRO = cnabKey()
      .id("No. Registro").at(394, 400).get(Integer.class);

  CnabKeyDecorator<CnabHeader> cnabKey() {
    Construtor<CnabHeader> construtor = CnabKey.of(CnabHeader.class);
    return new CnabKeyDecorator<CnabHeader>(construtor);
  }

  @Override
  public CnabKey<CnabHeader, Integer> codigoDoRetorno() {
    return CODIGO_RETORNO;
  }

  @Override
  public CnabKey<CnabHeader, String> literalRetorno() {
    return LITERAL_RETORNO;
  }

  @Override
  public CnabKey<CnabHeader, Integer> codigoDoServico() {
    return CODIGO_SERVICO;
  }

  @Override
  public CnabKey<CnabHeader, String> literalServico() {
    return LITERAL_SERVICO;
  }

  @Override
  public CnabKey<CnabHeader, String> nomeDaEmpresa() {
    return NOME_EMPRESA;
  }

  @Override
  public CnabKey<CnabHeader, Integer> numeroDoBanco() {
    return NUMERO_BANCO;
  }

  @Override
  public CnabKey<CnabHeader, String> nomeDoBanco() {
    return NOME_BANCO;
  }

  @Override
  public CnabKey<CnabHeader, LocalDate> dataDeGeracaoDoArquivo() {
    return DATA_GRAVACAO_ARQUIVO;
  }

  @Override
  public CnabKey<CnabHeader, Integer> numeroSeqDoArquivoRetorno() {
    return NUMERO_AVISO_BANCARIO;
  }

  @Override
  public CnabKey<CnabHeader, LocalDate> dataDeCredito() {
    return DATA_CREDITO;
  }

  @Override
  public CnabKey<CnabHeader, Integer> numeroSeqRegistro() {
    return NUMERO_REGISTRO;
  }

}