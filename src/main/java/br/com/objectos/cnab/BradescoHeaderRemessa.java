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
interface BradescoHeaderRemessa extends BancoKey {

  CnabKey<BradescoHeaderRemessa, String> idDoRegistro();

  CnabKey<BradescoHeaderRemessa, String> idDoArquivo();

  CnabKey<BradescoHeaderRemessa, String> literalRemessa();

  CnabKey<BradescoHeaderRemessa, String> codigoServico();

  CnabKey<BradescoHeaderRemessa, String> literalServico();

  CnabKey<BradescoHeaderRemessa, Long> codigoEmpresa();

  CnabKey<BradescoHeaderRemessa, String> nomeEmpresa();

  CnabKey<BradescoHeaderRemessa, String> numeroBanco();

  CnabKey<BradescoHeaderRemessa, String> nomeBanco();

  CnabKey<BradescoHeaderRemessa, LocalDate> dataArquivo();

  CnabKey<BradescoHeaderRemessa, String> branco();

  CnabKey<BradescoHeaderRemessa, String> idSistema();

  CnabKey<BradescoHeaderRemessa, Integer> seqRemessa();

  CnabKey<BradescoHeaderRemessa, String> branco2();

  CnabKey<BradescoHeaderRemessa, String> seqRegistro();

}