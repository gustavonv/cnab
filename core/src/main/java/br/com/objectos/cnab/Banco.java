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

import br.com.objectos.flat.FlatWriter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public abstract class Banco {

  Banco() {
  }

  public abstract Retorno read(String txt);

  public final String toString(Remessa remessa) {
    StringBuilder str = new StringBuilder();
    try (FlatWriter writer = FlatWriter.of(str).withLineSeparator("\r\n")) {
      writeRemessaTo(remessa, writer);
    }
    return str.toString();
  }

  abstract void writeRemessaTo(Remessa remessa, FlatWriter writer);

}