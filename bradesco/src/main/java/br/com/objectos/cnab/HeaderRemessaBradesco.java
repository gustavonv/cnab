/*
 * Copyright 2016 Objectos, Fábrica de Software LTDA.
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

import br.com.objectos.flat.Fill;
import br.com.objectos.flat.Fixed;
import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.IntegerFormat;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.flat.LocalDateFormat;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.LongFormat;
import br.com.objectos.flat.LongOption;
import br.com.objectos.flat.Text;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class HeaderRemessaBradesco implements FlatRecord {

  @Fixed("0")
  abstract String id();

  @Fixed("1REMESSA01COBRANCA       ")
  abstract String literalRemessa();

  @LongFormat(length = 20, options = LongOption.ZEROFILL)
  abstract long codigoEmpresa();

  @Text(length = 30)
  abstract String razaoSocial();

  @Fixed("237")
  abstract String numeroBanco();

  @Fixed("BRADESCO       ")
  abstract String nomeBanco();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  abstract LocalDate dataArquivo();

  @Fill(length = 8, character = ' ')
  abstract String branco();

  @Fixed("MX")
  abstract String idSistema();

  @IntegerFormat(length = 7, options = IntegerOption.ZEROFILL)
  abstract int seqRemessa();

  @Fill(length = 277, character = ' ')
  abstract String branco2();

  @Fixed("000001")
  abstract String seqRegistro();

  HeaderRemessaBradesco() {
  }

  public static HeaderRemessaBradescoBuilder builder() {
    return new HeaderRemessaBradescoBuilderPojo();
  }

}