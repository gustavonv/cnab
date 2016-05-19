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

import java.util.Arrays;

import com.google.common.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class Line {

  private static final String sep = System.getProperty("line.separator");

  private final int index;

  private int errors;

  private final char[] exp;

  private final char[] out;

  private final char[] top;

  private final char[] bot;

  public Line(int index, String prova, String res) {
    this.index = index;

    exp = prova.toCharArray();
    out = Strings.nullToEmpty(res).toCharArray();

    top = new char[exp.length + 1];
    bot = new char[exp.length + 1];
    Arrays.fill(top, ' ');
    Arrays.fill(bot, ' ');

    for (int i = 0; i < exp.length; i++) {
      if (!isEqual(exp, out, i)) {
        errors++;
        top[i] = 'v';
        bot[i] = '^';
      }
    }

    if (out.length > exp.length) {
      errors++;
      top[exp.length] = 'v';
      bot[exp.length] = '^';
    }
  }

  public boolean valid() {
    return errors == 0;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append(errors)
        .append(" erro(s) na linha ")
        .append(index + 1)
        .append(":")
        .append(sep)
        .append(top)
        .append(sep)

        .append(exp)
        .append(sep)

        .append(out)
        .append(sep)

        .append(bot)
        .append(sep)

        .toString();
  }

  private boolean isEqual(char[] exp, char[] out, int i) {
    boolean equal = false;

    if (i < out.length) {
      char expChar = exp[i];
      char outChar = out[i];
      equal = expChar == outChar;
    }

    return equal;
  }

}