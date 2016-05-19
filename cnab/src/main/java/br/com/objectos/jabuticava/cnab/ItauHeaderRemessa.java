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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
interface ItauHeaderRemessa extends BancoKey {

  CnabKey<ItauHeaderRemessa, String> tipoDeRegistro();
  CnabKey<ItauHeaderRemessa, String> operacao();
  CnabKey<ItauHeaderRemessa, String> literalRemessa();
  CnabKey<ItauHeaderRemessa, String> codigoServico();
  CnabKey<ItauHeaderRemessa, String> literalServico();
  CnabKey<ItauHeaderRemessa, Integer> agencia();
  CnabKey<ItauHeaderRemessa, String> zeros();
  CnabKey<ItauHeaderRemessa, Integer> conta();
  CnabKey<ItauHeaderRemessa, Integer> dac();
  CnabKey<ItauHeaderRemessa, String> brancos();
  CnabKey<ItauHeaderRemessa, String> nomeEmpresa();
  CnabKey<ItauHeaderRemessa, String> codigoBanco();
  CnabKey<ItauHeaderRemessa, String> nomeBanco();
  CnabKey<ItauHeaderRemessa, LocalDate> dataGeracao();
  CnabKey<ItauHeaderRemessa, String> brancos2();
  CnabKey<ItauHeaderRemessa, String> seqRegistro();

}