/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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
public interface LoteExt extends Lote {

  OcorrenciaCodigo getOcorrencia();

  Motivo getMotivo();

  String getUsoDaEmpresa();

  String getNumeroCobranca();

  String getNumeroTitulo();

  LocalDate getDataVencimento();

  LocalDate getDataOcorrencia();

  LocalDate getDataCredito();

  double getValorNominal();

  double getValorRecebido();

  double getValorJuros();

  double getValorDesconto();

  double getValorTarifa();

  int getSeq();

}