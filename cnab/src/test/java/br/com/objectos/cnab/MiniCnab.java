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

import static br.com.objectos.cnab.RegistroTipo.HEADER;
import static br.com.objectos.cnab.RegistroTipo.LOTE;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class MiniCnab {

  private static final Charset charset = Charsets.UTF_8;
  private static final String separator = System.getProperty("line.separator");

  private final File file;

  private final List<String> lines;

  private final String headerLine;
  private final String loteLines;

  public MiniCnab(File file) {
    this.file = file;
    this.lines = readLines();

    this.headerLine = getLinesOf(HEADER);
    this.loteLines = getLinesOf(LOTE);
  }

  public File getFile() {
    return file;
  }

  public List<String> getLines() {
    return lines;
  }
  public String getLineAt(int index) {
    return lines.get(index);
  }

  public String getHeaderLine() {
    return headerLine;
  }
  public String getLoteLines() {
    return loteLines;
  }

  @Override
  public String toString() {
    try {
      return Files.toString(file, charset);
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

  private List<String> readLines() {
    try {
      return Files.readLines(file, charset);
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

  private String getLinesOf(RegistroTipo tipo) {
    Iterable<String> filtered = Iterables.filter(lines, new FiltroRegistroTipo(tipo));
    List<String> lines = ImmutableList.copyOf(filtered);
    return Joiner.on(separator).join(lines);
  }

  private class FiltroRegistroTipo implements Predicate<String> {

    private final RegistroTipo tipo;

    public FiltroRegistroTipo(RegistroTipo tipo) {
      this.tipo = tipo;
    }

    @Override
    public boolean apply(String input) {
      return tipo.matches(input);
    }

  }

}