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

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import br.com.objectos.assertion.StringAssertion;
import br.com.objectos.core.util.zip.UnzipEntry;
import br.com.objectos.flat.FlatWriter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CnabRetornoAssert {

  private final String entryName;
  private final String source;

  private CnabRetornoAssert(String entryName, String source) {
    this.entryName = entryName;
    this.source = source.replace(" 2654 A", "2654 A ");
  }

  public static CnabRetornoAssert of(UnzipEntry entry) {
    String source;
    try (Scanner scanner = new Scanner(entry.open())) {
      source = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
    }
    return new CnabRetornoAssert(
        entry.name(),
        source);
  }

  public CnabRetornoResult verifyRetorno(Banco banco) {
    try {
      Retorno retorno = banco.read(source);
      StringBuilder text = new StringBuilder();
      try (FlatWriter writer = FlatWriter.of(text).withLineSeparator("\r\n")) {
        retorno.writeTo(writer);
      }
      StringAssertion.assertThat(text.toString()).hasLinesEqualTo(source);
      return CnabRetornoResult.success(entryName);
    } catch (AssertionError | DateTimeParseException e) {
      return CnabRetornoResult.fail(entryName, e);
    }
  }

}