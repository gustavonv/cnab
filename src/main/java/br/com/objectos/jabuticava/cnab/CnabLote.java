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

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public interface CnabLote extends BancoKey, LoteKey {

  CnabKey<CnabLote, Integer> tipoDeInscricaoDaEmpresa();

  CnabKey<CnabLote, Long> numeroDeInscricaoDaEmpresa();

  CnabKey<CnabLote, String> usoDaEmpresa();

  CnabKey<CnabLote, String> nossoNumero();

  CnabKey<CnabLote, Integer> carteiraNumero();

  CnabKey<CnabLote, String> nossoNumero2();

  CnabKey<CnabLote, Ocorrencia> ocorrencia();

  CnabKey<CnabLote, Integer> codigoDeOcorrencia();

  CnabKey<CnabLote, LocalDate> dataDeOcorrencia();

  CnabKey<CnabLote, String> numeroDoDocumento();

  CnabKey<CnabLote, LocalDate> dataDeVencimento();

  CnabKey<CnabLote, Double> valorTitulo();

  CnabKey<CnabLote, Integer> bancoCobrador();

  CnabKey<CnabLote, Integer> agenciaCobradora();

  CnabKey<CnabLote, Double> despesaDeCobranca();

  CnabKey<CnabLote, Double> valorIOF();

  CnabKey<CnabLote, Double> valorAbatimento();

  CnabKey<CnabLote, Double> valorDesconto();

  CnabKey<CnabLote, Double> valorPago();

  CnabKey<CnabLote, Double> valorMora();

  CnabKey<CnabLote, Double> valorOutros();

  CnabKey<CnabLote, LocalDate> dataDeCredito();

  CnabKey<CnabLote, Integer> numeroSeqRegistro();

}