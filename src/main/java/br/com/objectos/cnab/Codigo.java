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

import br.com.objectos.core.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Codigo {

  private final String text;

  private final String codigo;

  private Codigo(String text, String value) {
    this.text = text;
    codigo = value;
  }

  public String getText() {
    return text;
  }

  public String getValue() {
    return codigo;
  }

  @Override
  public String toString() {
    return codigo;
  }

  public static Codigo valueOf(String text) {
    text = Strings.nullToEmpty(text);
    String value = text.replaceAll("^[0]+", "");
    return new Codigo(text, value);
  }

}