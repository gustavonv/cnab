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
import br.com.objectos.flat.FlatReader;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.flat.LongOption;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cnpj;
import br.com.objectos.jabuticava.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CadastroRfbItauFormatter implements CustomFormatter<CadastroRFB> {

  @Override
  public CadastroRFB parse(FlatReader reader, int length) {
    int tipo = reader.integer(2);
    long longValue = reader.longValue(14);
    return tipo == 1 ? Cpf.valueOf(longValue) : Cnpj.valueOf(longValue);
  }

  @Override
  public FlatWriter write(FlatWriter writer, int length, CadastroRFB value) {
    return value instanceof Cpf
        ? write(writer, "01", value.longValue())
        : write(writer, "02", value.longValue());
  }

  private FlatWriter write(FlatWriter writer, String prefix, long longValue) {
    return writer.fixed(prefix).longValue(longValue, 14, LongOption.ZEROFILL);
  }

}