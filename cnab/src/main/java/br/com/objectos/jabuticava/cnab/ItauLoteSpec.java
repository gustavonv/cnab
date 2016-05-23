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

import java.time.LocalDate;

import br.com.objectos.jabuticava.cnab.CnabKey.Construtor;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ItauLoteSpec extends CnabLoteSpec implements ItauLote {

  // private final CnabKey<ItauLote, Integer> TIPO_INSCRICAO_EMPRESA = key()
  // .id("Tipo De Inscrição Empresa").at(1, 3).get(Integer.class);
  //
  // private final CnabKey<ItauLote, Long> NUMERO_INSCRICAO_EMPRESA = key()
  // .id("No. Inscrição da Emprea").at(3, 17).get(Long.class);

  private final CnabKey<ItauLote, Integer> AGENCIA = key()
      .id("Agência").at(17, 21).get(Integer.class);

  private final CnabKey<ItauLote, Integer> CONTA = key()
      .id("Conta").at(23, 28).get(Integer.class);

  private final CnabKey<ItauLote, Integer> DAC_CONTA = key()
      .id("DAC Conta").at(28, 29).get(Integer.class);

  private final CnabKey<CnabLote, String> NOSSO_NUMERO = reconf(super.nossoNumero())
      .moveTo(62, 70);

  private final CnabKey<CnabLote, Integer> NUMERO_CARTEIRA = reconf(super.carteiraNumero())
      .moveTo(82, 85);
  //
  // private final CnabKey<ItauLote, String> NOSSO_NUMERO_2 = key()
  // .id("Nosso número 2").at(85, 93).get(String.class);

  private final CnabKey<ItauLote, Integer> DAC_NOSSO_NUMERO_2 = key()
      .id("DAC Nosso número").at(93, 94).get(Integer.class);

  private final CnabKey<ItauLote, String> CODIGO_CARTEIRA = key()
      .id("Código Carteira").at(107, 108).get(String.class);

  // private final CnabKey<ItauLote, Integer> ID_OCORRENCIA = key()
  // .id("ID de Ocorrência").at(108, 110).get(Integer.class);
  //
  // private final CnabKey<ItauLote, LocalDate> DATA_OCORRENCIA = key()
  // .id("Data Ocorrência no Banco").at(110, 116).get(LocalDate.class);
  //
  // private final CnabKey<ItauLote, Codigo> NUMERO_DOCUMENTO = key()
  // .id("Número do Documento").at(116, 126).get(Codigo.class);

  private final CnabKey<ItauLote, Integer> NOSSO_NUMERO_3 = key()
      .id("Nosso número 3").at(126, 134).get(Integer.class);

  private final CnabKey<CnabLote, LocalDate> DATA_VENCIMENTO = reconf(super.dataDeVencimento())
      .optional();
  //
  // private final CnabKey<ItauLote, Double> VALOR_TITULO = key()
  // .id("Valor do Título").at(152, 165).get(Double.class);
  //
  // private final CnabKey<ItauLote, Integer> BANCO_COBRADOR = key()
  // .id("Banco Cobrador").at(165, 168).get(Integer.class);
  //
  // private final CnabKey<ItauLote, Integer> AGENCIA_COBRADORA = key()
  // .id("Agência Cobradora").at(168, 172).get(Integer.class);

  private final CnabKey<ItauLote, Integer> DAC_AGENCIA_COBRADORA = key()
      .id("DAC Agência Cobradora").at(172, 173).get(Integer.class);

  private final CnabKey<ItauLote, Integer> ESPECIE = key()
      .id("Espécie").at(173, 175).getWithDefaultValue(Integer.class, Integer.valueOf(0));

  // private final CnabKey<ItauLote, Double> VALOR_DESPESA_COBRANCA = key()
  // .id("Despesas de cobrança para os Códigos de Ocorrência").at(175,
  // 188).get(Double.class);
  //
  // private final CnabKey<ItauLote, Double> VALOR_IOF = key()
  // .id("IOF Devido").at(214, 227).get(Double.class);
  //
  // private final CnabKey<ItauLote, Double> VALOR_ABATIMENTO = key()
  // .id("Abatimento Concedido Sobre o Título").at(227, 240).get(Double.class);
  //
  // private final CnabKey<ItauLote, Double> VALOR_DESCONTO = key()
  // .id("Desconto Concedido").at(240, 253).get(Double.class);
  //
  // private final CnabKey<ItauLote, Double> VALOR_PAGO = key()
  // .id("Valor Pago").at(253, 266).get(Double.class);
  //
  // private final CnabKey<ItauLote, Double> VALOR_MORA = key()
  // .id("Juros de Mora").at(266, 279).get(Double.class);
  //
  // private final CnabKey<ItauLote, Double> VALOR_OUTROS_CREDITOS = key()
  // .id("Outros Créditos").at(279, 292).get(Double.class);

  private final CnabKey<ItauLote, String> BOLETO_DDA = key()
      .id("Boleto DDA").at(292, 293).optional().get(String.class);

  // private final CnabKey<ItauLote, LocalDate> DATA_CREDITO = key()
  // .id("Data do Crédito").at(295, 301).optional().get(LocalDate.class);

  private final CnabKey<ItauLote, Integer> INSTRUCAO_CANCELADA = key()
      .id("Instrução Cancelada").at(301, 305).get(Integer.class);

  private final CnabKey<ItauLote, String> NOME_SACADO = key()
      .id("Nome Sacado").at(324, 354).optional().get(String.class);

  private final CnabKey<ItauLote, String> ERROS = key()
      .id("Erros").at(377, 385).optional().get(String.class);

  private final CnabKey<ItauLote, String> CODIGO_LIQUIDACAO = key()
      .id("Código Liquidação").at(392, 394).optional().get(String.class);

  private CnabKeyDecorator<ItauLote> key() {
    Construtor<ItauLote> construtor = CnabKey.of(ItauLote.class);
    return new CnabKeyDecorator<ItauLote>(construtor);
  }

  @Override
  public CnabKey<ItauLote, Integer> agencia() {
    return AGENCIA;
  }

  @Override
  public CnabKey<ItauLote, Integer> conta() {
    return CONTA;
  }

  @Override
  public CnabKey<ItauLote, Integer> dacConta() {
    return DAC_CONTA;
  }

  @Override
  public CnabKey<CnabLote, String> nossoNumero() {
    return NOSSO_NUMERO;
  }

  @Override
  public CnabKey<CnabLote, Integer> carteiraNumero() {
    return NUMERO_CARTEIRA;
  }

  @Override
  public CnabKey<ItauLote, Integer> dacNossoNumero2() {
    return DAC_NOSSO_NUMERO_2;
  }

  @Override
  public CnabKey<ItauLote, Integer> dacAgenciaCobradora() {
    return DAC_AGENCIA_COBRADORA;
  }

  @Override
  public CnabKey<ItauLote, String> codigoDaCarteira() {
    return CODIGO_CARTEIRA;
  }

  @Override
  public CnabKey<ItauLote, Integer> nossoNumero3() {
    return NOSSO_NUMERO_3;
  }

  @Override
  public CnabKey<CnabLote, LocalDate> dataDeVencimento() {
    return DATA_VENCIMENTO;
  }

  @Override
  public CnabKey<ItauLote, Integer> especie() {
    return ESPECIE;
  }

  @Override
  public CnabKey<ItauLote, String> boletoDDA() {
    return BOLETO_DDA;
  }

  @Override
  public CnabKey<ItauLote, Integer> instrucaoCancelada() {
    return INSTRUCAO_CANCELADA;
  }

  @Override
  public CnabKey<ItauLote, String> nomeDoSacado() {
    return NOME_SACADO;
  }

  @Override
  public CnabKey<ItauLote, String> erros() {
    return ERROS;
  }

  @Override
  public CnabKey<ItauLote, String> codigoDeLiquidacao() {
    return CODIGO_LIQUIDACAO;
  }

}