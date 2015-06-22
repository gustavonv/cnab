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
class CnabLoteSpec extends AbstractSpec implements CnabLote {

  private final CnabKey<CnabLote, Integer> TIPO_INSCRICAO_EMPRESA = cnabKey()
      .id("Tipo De Inscrição Empresa").at(1, 3).get(Integer.class);

  private final CnabKey<CnabLote, Long> NUMERO_INSCRICAO_EMPRESA = cnabKey()
      .id("No. Inscriação da Emprea").at(3, 17).get(Long.class);

  private final CnabKey<CnabLote, String> USO_EMPRESA = cnabKey()
      .id("Uso da Empresa").at(37, 62).getWithDefaultValue(String.class, "");

  private final CnabKey<CnabLote, String> NOSSO_NUMERO = cnabKey()
      .id("Nosso Número").at(70, 82).get(String.class);

  private final CnabKey<CnabLote, Integer> CARTEIRA_NUMERO = cnabKey()
      .id("Carteira (No.)").at(107, 108).get(Integer.class);

  private final CnabKey<CnabLote, Ocorrencia> OCORRENCIA = ocorrenciaKey();

  private final CnabKey<CnabLote, Integer> CODIGO_OCORRENCIA = cnabKey()
      .id("Código de Ocorrência").at(108, 110).get(Integer.class);

  private final CnabKey<CnabLote, LocalDate> DATA_OCORRENCIA = cnabKey()
      .id("Data Ocorrência no Banco").at(110, 116).get(LocalDate.class);

  private final CnabKey<CnabLote, String> NUMERO_DOCUMENTO = cnabKey()
      .id("Número do Documento").at(116, 126).get(String.class);

  private final CnabKey<CnabLote, String> NOSSO_NUMERO_2 = cnabKey()
      .id("Nosso Número 2").at(126, 146).get(String.class);

  private final CnabKey<CnabLote, LocalDate> DATA_VENCIMENTO = cnabKey()
      .id("Data Vencimento do Título").at(146, 152).get(LocalDate.class);

  private final CnabKey<CnabLote, Double> VALOR_TITULO = cnabKey()
      .id("Valor do Título").at(152, 165).get(Double.class);

  private final CnabKey<CnabLote, Integer> BANCO_COBRADOR = cnabKey()
      .id("Banco Cobrador").at(165, 168).get(Integer.class);

  private final CnabKey<CnabLote, Integer> AGENCIA_COBRADORA = cnabKey()
      .id("Agência Cobradora").at(168, 173).get(Integer.class);

  private final CnabKey<CnabLote, Double> VALOR_DESPESA_COBRANCA = cnabKey()
      .id("Despesas de cobrança para os Códigos de Ocorrência").at(175, 188).get(Double.class);

  private final CnabKey<CnabLote, Double> VALOR_IOF = cnabKey()
      .id("IOF Devido").at(214, 227).get(Double.class);

  private final CnabKey<CnabLote, Double> VALOR_ABATIMENTO = cnabKey()
      .id("Abatimento Concedido Sobre o Título").at(227, 240).get(Double.class);

  private final CnabKey<CnabLote, Double> VALOR_DESCONTO = cnabKey()
      .id("Desconto Concedido").at(240, 253).get(Double.class);

  private final CnabKey<CnabLote, Double> VALOR_PAGO = cnabKey()
      .id("Valor Pago").at(253, 266).get(Double.class);

  private final CnabKey<CnabLote, Double> VALOR_MORA = cnabKey()
      .id("Juros de Mora").at(266, 279).get(Double.class);

  private final CnabKey<CnabLote, Double> VALOR_OUTROS_CREDITOS = cnabKey()
      .id("Outros Créditos").at(279, 292).get(Double.class);

  private final CnabKey<CnabLote, LocalDate> DATA_CREDITO = cnabKey()
      .id("Data do Crédito").at(295, 301).optional().get(LocalDate.class);

  private final CnabKey<CnabLote, Integer> NUMERO_REGISTRO = cnabKey()
      .id("No. Registro").at(394, 400).get(Integer.class);

  CnabKeyDecorator<CnabLote> cnabKey() {
    Construtor<CnabLote> construtor = CnabKey.of(CnabLote.class);
    return new CnabKeyDecorator<CnabLote>(construtor);
  }

  private CnabKey<CnabLote, Ocorrencia> ocorrenciaKey() {
    CnabOcorrenciaKey<CnabLote> key = new CnabOcorrenciaKey<CnabLote>(CnabLote.class, "Ocorrência");
    keySet.add(key);
    return key;
  }

  @Override
  public CnabKey<CnabLote, Integer> tipoDeInscricaoDaEmpresa() {
    return TIPO_INSCRICAO_EMPRESA;
  }

  @Override
  public CnabKey<CnabLote, Long> numeroDeInscricaoDaEmpresa() {
    return NUMERO_INSCRICAO_EMPRESA;
  }

  @Override
  public CnabKey<CnabLote, String> usoDaEmpresa() {
    return USO_EMPRESA;
  }

  @Override
  public CnabKey<CnabLote, String> nossoNumero() {
    return NOSSO_NUMERO;
  }

  @Override
  public CnabKey<CnabLote, Integer> carteiraNumero() {
    return CARTEIRA_NUMERO;
  }

  @Override
  public CnabKey<CnabLote, String> nossoNumero2() {
    return NOSSO_NUMERO_2;
  }

  @Override
  public CnabKey<CnabLote, Ocorrencia> ocorrencia() {
    return OCORRENCIA;
  }

  @Override
  public CnabKey<CnabLote, Integer> codigoDeOcorrencia() {
    return CODIGO_OCORRENCIA;
  }

  @Override
  public CnabKey<CnabLote, LocalDate> dataDeOcorrencia() {
    return DATA_OCORRENCIA;
  }

  @Override
  public CnabKey<CnabLote, String> numeroDoDocumento() {
    return NUMERO_DOCUMENTO;
  }

  @Override
  public CnabKey<CnabLote, LocalDate> dataDeVencimento() {
    return DATA_VENCIMENTO;
  }

  @Override
  public CnabKey<CnabLote, Double> valorTitulo() {
    return VALOR_TITULO;
  }

  @Override
  public CnabKey<CnabLote, Integer> bancoCobrador() {
    return BANCO_COBRADOR;
  }

  @Override
  public CnabKey<CnabLote, Integer> agenciaCobradora() {
    return AGENCIA_COBRADORA;
  }

  @Override
  public CnabKey<CnabLote, Double> despesaDeCobranca() {
    return VALOR_DESPESA_COBRANCA;
  }

  @Override
  public CnabKey<CnabLote, Double> valorIOF() {
    return VALOR_IOF;
  }

  @Override
  public CnabKey<CnabLote, Double> valorAbatimento() {
    return VALOR_ABATIMENTO;
  }

  @Override
  public CnabKey<CnabLote, Double> valorDesconto() {
    return VALOR_DESCONTO;
  }

  @Override
  public CnabKey<CnabLote, Double> valorPago() {
    return VALOR_PAGO;
  }

  @Override
  public CnabKey<CnabLote, Double> valorMora() {
    return VALOR_MORA;
  }

  @Override
  public CnabKey<CnabLote, Double> valorOutros() {
    return VALOR_OUTROS_CREDITOS;
  }

  @Override
  public CnabKey<CnabLote, LocalDate> dataDeCredito() {
    return DATA_CREDITO;
  }

  @Override
  public CnabKey<CnabLote, Integer> numeroSeqRegistro() {
    return NUMERO_REGISTRO;
  }

}