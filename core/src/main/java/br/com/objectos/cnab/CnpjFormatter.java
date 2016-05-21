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

import br.com.objectos.flat.CustomFormatter;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.flat.LongOption;
import br.com.objectos.jabuticava.Cnpj;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CnpjFormatter implements CustomFormatter<Cnpj> {

  private static final CnpjFormatter INSTANCE = new CnpjFormatter();

  public static CnpjFormatter get() {
    return INSTANCE;
  }

  @Override
  public Cnpj parse(String text) {
    long value = Long.parseLong(text, 10);
    return Cnpj.valueOf(value);
  }

  @Override
  public FlatWriter write(FlatWriter writer, Cnpj value, int length) {
    return writer.longValue(value.longValue(), length, LongOption.ZEROFILL);
  }

}