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
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.jabuticava.Cep;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CepCoreFormatter implements CustomFormatter<Cep> {

  @Override
  public Cep parse(FlatReader reader, int length) {
    String text = reader.text(length);
    return Cep.valueOf(text);
  }

  @Override
  public FlatWriter write(FlatWriter writer, int length, Cep value) {
    return writer
        .integer(value.getPrefixo(), 5, IntegerOption.ZEROFILL)
        .integer(value.getSufixo(), 3, IntegerOption.ZEROFILL);
  }

}