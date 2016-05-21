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
package br.com.objectos.cnab.itau;

import java.util.function.LongFunction;

import br.com.objectos.flat.CustomFormatter;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.flat.LongOption;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cnpj;
import br.com.objectos.jabuticava.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class InscricaoSacadoFormatter implements CustomFormatter<CadastroRFB> {

  @Override
  public CadastroRFB parse(String text) {
    return text.startsWith("1")
        ? parse0(text, Cpf::valueOf)
        : parse0(text, Cnpj::valueOf);
  }

  @Override
  public FlatWriter write(FlatWriter writer, CadastroRFB value, int length) {
    return value instanceof Cpf
        ? write(writer, "1", value.longValue())
        : write(writer, "2", value.longValue());
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