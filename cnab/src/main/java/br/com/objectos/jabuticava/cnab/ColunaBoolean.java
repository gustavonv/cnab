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
package br.com.objectos.jabuticava.cnab;

import br.com.objectos.core.lang.Preconditions;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ColunaBoolean extends Coluna<Boolean> {

  private final String trueText;
  private final String falseText;
  private final boolean value;

  public ColunaBoolean(int inicio, int fim, String trueText, String falseText) {
    this(inicio, fim, trueText, falseText, false);
  }

  private ColunaBoolean(int inicio, int fim, String trueText, String falseText, boolean value) {
    super(inicio, fim);
    this.trueText = trueText;
    this.falseText = falseText;
    this.value = value;

    Preconditions.checkArgument(trueText.length() == tamanho);
    Preconditions.checkArgument(falseText.length() == tamanho);
  }

  @Override
  public String get() {
    return value ? trueText : falseText;
  }

  @Override
  public Class<Boolean> getType() {
    return Boolean.class;
  }

  @Override
  public ColunaWriter<Boolean> set(Object value) {
    Boolean val = Boolean.class.cast(value);
    return new ColunaBoolean(inicio, fim, trueText, falseText, val);
  }

}