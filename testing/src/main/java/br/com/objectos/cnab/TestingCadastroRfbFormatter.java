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

import java.util.function.LongFunction;

import br.com.objectos.flat.CustomFormatter;
import br.com.objectos.flat.FlatReader;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.flat.LongOption;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cnpj;
import br.com.objectos.jabuticava.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class TestingCadastroRfbFormatter implements CustomFormatter<CadastroRFB> {

  private static final TestingCadastroRfbFormatter INSTANCE = new TestingCadastroRfbFormatter();

  public static TestingCadastroRfbFormatter get() {
    return INSTANCE;
  }

  @Override
  public CadastroRFB parse(FlatReader reader, int length) {
    String text = reader.text(length);
    return text.startsWith("F")
        ? parse0(text, Cpf::valueOf)
        : parse0(text, Cnpj::valueOf);
  }

  @Override
  public FlatWriter write(FlatWriter writer, int length, CadastroRFB value) {
    return value instanceof Cnpj
        ? write(writer, "J", value.longValue())
        : write(writer, "F", value.longValue());
  }

  private CadastroRFB parse0(String text, LongFunction<CadastroRFB> f) {
    String value = text.substring(1);
    long longValue = Long.parseLong(value, 10);
    return f.apply(longValue);
  }

  private FlatWriter write(FlatWriter writer, String prefix, long longValue) {
    return writer.fixed(prefix).longValue(longValue, 14, LongOption.ZEROFILL);
  }

}