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
import java.util.Optional;

import br.com.objectos.flat.CustomFormatter;
import br.com.objectos.flat.FlatReader;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.flat.LocalDatePattern;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class VencimentoItauFormatter implements CustomFormatter<Optional<LocalDate>> {

  @Override
  public Optional<LocalDate> parse(FlatReader reader, int length) {
    String text = reader.text(length);
    return "".equals(text)
        ? Optional.empty()
        : "000000".equals(text)
            ? Optional.empty()
            : Optional.of(LocalDatePattern.DDMMYY.parse(text));
  }

  @Override
  public FlatWriter write(FlatWriter writer, int length, Optional<LocalDate> value) {
    return value.isPresent()
        ? writer.localDate(value, LocalDatePattern.DDMMYY, "      ")
        : writer.fixed("000000");
  }

}