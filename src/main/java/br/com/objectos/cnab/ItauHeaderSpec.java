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

import br.com.objectos.cnab.CnabKey.Construtor;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ItauHeaderSpec extends CnabHeaderSpec implements ItauHeader {

  // private final CnabKey<ItauHeader, Integer> CODIGO_RETORNO = key()
  // .id("Código Retorno").at(1, 2).get(Integer.class);
  //
  // private final CnabKey<ItauHeader, String> LITERAL_RETORNO = key()
  // .id("Literal Retorno").at(2, 9).get(String.class);
  //
  // private final CnabKey<ItauHeader, Integer> CODIGO_SERVICO = key()
  // .id("Código do Serviço").at(9, 11).get(Integer.class);
  //
  // private final CnabKey<ItauHeader, String> LITERAL_SERVICO = key()
  // .id("Literal Serviço").at(11, 26).get(String.class);

  private final CnabKey<ItauHeader, Integer> AGENCIA = key()
      .id("Agência").at(26, 30).get(Integer.class);

  private final CnabKey<ItauHeader, Integer> CONTA = key()
      .id("Conta").at(32, 37).get(Integer.class);

  private final CnabKey<ItauHeader, Integer> DAC = key()
      .id("DAC").at(37, 38).get(Integer.class);

  // private final CnabKey<ItauHeader, String> NOME_EMPRESA = key()
  // .id("Nome da Empresa por Extenso").at(46, 76).get(String.class);
  //
  // private final CnabKey<ItauHeader, Integer> NUMERO_BANCO = key()
  // .id("No. Banco").at(76, 79).get(Integer.class);
  //
  // private final CnabKey<ItauHeader, String> NOME_BANCO = key()
  // .id("Nome do Banco por Extenso").at(79, 94).get(String.class);
  //
  // private final CnabKey<ItauHeader, LocalDate> DATA_GERACAO_ARQUIVO = key()
  // .id("Data de Geração do Arquivo").at(94, 100).get(LocalDate.class);

  private final CnabKey<ItauHeader, Integer> DENSIDADE = key()
      .id("Unidade da Densidade").at(100, 105).get(Integer.class);

  private final CnabKey<ItauHeader, String> UNIDADE_DENSIDADE = key()
      .id("Densidade de gravação do arquivo").at(105, 108).get(String.class);

  private final CnabKey<ItauHeader, Integer> NUMERO_ARQUIVO_RETORNO = key()
      .id("No. do Arquivo Retorno").at(108, 113).get(Integer.class);

  private final CnabKey<CnabHeader, LocalDate> DATA_CREDITO = reconf(super.dataDeCredito())
      .moveTo(113, 119);

  //
  // private final CnabKey<ItauHeader, Integer> NUMERO_REGISTRO = key()
  // .id("No. Registro").at(394, 400).get(Integer.class);

  private CnabKeyDecorator<ItauHeader> key() {
    Construtor<ItauHeader> construtor = CnabKey.of(ItauHeader.class);
    return new CnabKeyDecorator<ItauHeader>(construtor);
  }

  @Override
  public CnabKey<CnabHeader, LocalDate> dataDeCredito() {
    return DATA_CREDITO;
  }

  @Override
  public CnabKey<ItauHeader, Integer> agencia() {
    return AGENCIA;
  }

  @Override
  public CnabKey<ItauHeader, Integer> conta() {
    return CONTA;
  }

  @Override
  public CnabKey<ItauHeader, Integer> dacConta() {
    return DAC;
  }

  @Override
  public CnabKey<ItauHeader, Integer> densidade() {
    return DENSIDADE;
  }

  @Override
  public CnabKey<ItauHeader, String> unidadeDeDensidade() {
    return UNIDADE_DENSIDADE;
  }

  @Override
  public CnabKey<ItauHeader, Integer> numeroSequencialDoArquivo() {
    return NUMERO_ARQUIVO_RETORNO;
  }

}