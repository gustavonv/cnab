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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class BradescoLoteSpec extends CnabLoteSpec implements BradescoLote {

  private final CnabKey<BradescoLote, Codigo> IDENTIFICACAO_EMPRESA = key()
      .id("Identificação da Empresa Cedente no Banco").at(20, 37).get(Codigo.class);

  private final CnabKey<BradescoLote, String> INDICADOR_RATEIO_CREDITO = key()
      .id("Indicador de Rateio Crédito").at(104, 105).get(String.class);

  private final CnabKey<CnabLote, String> NUMERO_DOCUMENTO = reconf(super.numeroDoDocumento())
      .optional();

  private final CnabKey<BradescoLote, Double> VALOR_OUTRAS_DESPESAS = key()
      .id("Outras despesas / Custas de Protesto").at(188, 201).get(Double.class);

  private final CnabKey<BradescoLote, Double> JUROS_OPERACAO_ATRASO = key()
      .id("Juros Operação em Atraso").at(201, 214).get(Double.class);

  private final CnabKey<BradescoLote, String> MOTIVO_CODIGO_OCORRENCIA = key()
      .id("Motivo do Código de Ocorrência 19 (Protesto)").at(294, 295).optional().get(String.class);

  private final CnabKey<BradescoLote, Long> MOTIVOS_REJEICOES = key()
      .id("Motivos das Rejeições").at(318, 328).get(Long.class);

  private CnabKeyDecorator<BradescoLote> key() {
    Construtor<BradescoLote> construtor = CnabKey.of(BradescoLote.class);
    return new CnabKeyDecorator<BradescoLote>(construtor);
  }

  @Override
  public CnabKey<BradescoLote, Codigo> identicacaoDaEmpresa() {
    return IDENTIFICACAO_EMPRESA;
  }

  @Override
  public CnabKey<BradescoLote, String> indicadorDeRateio() {
    return INDICADOR_RATEIO_CREDITO;
  }

  @Override
  public CnabKey<CnabLote, String> numeroDoDocumento() {
    return NUMERO_DOCUMENTO;
  }

  @Override
  public CnabKey<BradescoLote, Double> valorOutrasDespesas() {
    return VALOR_OUTRAS_DESPESAS;
  }

  @Override
  public CnabKey<BradescoLote, Double> valorJurosOperacao() {
    return JUROS_OPERACAO_ATRASO;
  }

  @Override
  public CnabKey<BradescoLote, String> motivoOcorrencia() {
    return MOTIVO_CODIGO_OCORRENCIA;
  }

  @Override
  public CnabKey<BradescoLote, Long> motivoRejeicao() {
    return MOTIVOS_REJEICOES;
  }

}