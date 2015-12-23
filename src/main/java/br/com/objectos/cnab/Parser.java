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
package br.com.objectos.cnab;

import java.time.LocalDate;

import br.com.objectos.comuns.io.ParsedFixedLines;
import br.com.objectos.comuns.io.csv.FixedFile;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class Parser {

  private final FixedFile file;

  public Parser(FixedFile file) {
    this.file = file;
  }

  public ParsedFixedLines get() {
    return file
        .withConverter(Double.class, new ConverterDouble())
        .withConverter(LocalDate.class, new ConverterLocalDate())
        .withConverter(Codigo.class, new ConverterCodigo())
        .getLines();
  }

}