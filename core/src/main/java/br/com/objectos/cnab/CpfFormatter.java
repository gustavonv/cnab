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
import br.com.objectos.jabuticava.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CpfFormatter implements CustomFormatter<Cpf> {

  private static final CpfFormatter INSTANCE = new CpfFormatter();

  public static CpfFormatter get() {
    return INSTANCE;
  }

  @Override
  public Cpf parse(String text) {
    String core = text.substring(0, 11);
    long value = Long.parseLong(core, 10);
    return Cpf.valueOf(value);
  }

  @Override
  public FlatWriter write(FlatWriter writer, Cpf value, int length) {
    return writer
        .longValue(value.longValue(), 11, LongOption.ZEROFILL)
        .fixed("000");
  }

}