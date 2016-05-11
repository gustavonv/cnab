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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import br.com.objectos.comuns.io.FixedLine;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ExcecaoCnab extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final FixedLine line;

  ExcecaoCnab(FixedLine line, String message) {
    super(message);
    this.line = line;
  }

  ExcecaoCnab(FixedLine line, String message, Throwable cause) {
    super(message, cause);
    this.line = line;
  }

  @Override
  public String getMessage() {
    StringWriter sw = new StringWriter();
    BufferedWriter writer = new BufferedWriter(sw);

    try {
      writer.write("Não foi possível processar a linha:");
      writer.newLine();
      writer.write(line.getText());
      writer.newLine();
      writer.newLine();
      writer.write("Com a seguinte mensagem:");
      writer.newLine();
      writer.write(getMsg());
      writer.flush();
      return sw.toString();

    } catch (IOException e) {
      return super.getMessage();

    } finally {
      try {
        writer.close();
      } catch (IOException e) {
        // não há muito o que se fazer neste caso
      }
    }
  }

  public FixedLine getLine() {
    return line;
  }

  protected String getMsg() {
    return super.getMessage();
  }

}