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

import java.util.Scanner;

import br.com.objectos.core.util.zip.UnzipEntry;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CnabEntry {

  private final Type type;
  private final String id;
  final UnzipEntry entry;

  private CnabEntry(Type type, String id, UnzipEntry entry) {
    this.type = type;
    this.id = id;
    this.entry = entry;
  }

  public static CnabEntry of(UnzipEntry entry) {
    String entryName = entry.name();
    return new CnabEntry(
        entryName.endsWith(".TXT") ? Type.TESTING : Type.CNAB,
        entryName.substring(0, entryName.indexOf('.')),
        entry);
  }

  public String toExpectedOutput() {
    if (!Type.CNAB.equals(type)) {
      throw new UnsupportedOperationException("Not CNAB.");
    }
    try (Scanner scanner = new Scanner(entry.open())) {
      return scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
    }
  }

  public TestingRemessa toTestingRemessa() {
    if (!Type.TESTING.equals(type)) {
      throw new UnsupportedOperationException("Not Testing.");
    }
    return TestingRemessa.readFrom(entry);
  }

  String id() {
    return id;
  }

  private enum Type {

    CNAB,

    TESTING;

  }

}