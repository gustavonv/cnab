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
public interface CnabHeader extends BancoKey, HeaderKey {

  CnabKey<CnabHeader, Integer> codigoDoRetorno();

  CnabKey<CnabHeader, String> literalRetorno();

  CnabKey<CnabHeader, Integer> codigoDoServico();

  CnabKey<CnabHeader, String> literalServico();

  CnabKey<CnabHeader, String> nomeDaEmpresa();

  CnabKey<CnabHeader, Integer> numeroDoBanco();

  CnabKey<CnabHeader, String> nomeDoBanco();

  CnabKey<CnabHeader, LocalDate> dataDeGeracaoDoArquivo();

  CnabKey<CnabHeader, Integer> numeroSeqDoArquivoRetorno();

  CnabKey<CnabHeader, LocalDate> dataDeCredito();

  CnabKey<CnabHeader, Integer> numeroSeqRegistro();

}