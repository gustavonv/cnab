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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import br.com.objectos.comuns.io.FixedLine;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class MotivoParserPadrao implements MotivoParser {

  private final int pos0;
  private final int pos1;

  private final int length = 2;

  private final Motivo ignorarExtras;

  private final Map<String, Motivo> codigoMap;

  public MotivoParserPadrao(int pos0, int pos1, String ignorarExtras, List<Motivo> motivos) {
    this.pos0 = pos0;
    this.pos1 = pos1;

    Map<String, Motivo> codigoMap = new TreeMap<>();

    for (Motivo motivo : motivos) {
      String codigo = motivo.getCodigo();
      codigoMap.put(codigo, motivo);
    }

    this.ignorarExtras = ignorarExtras != null ? new MotivoPadrao(ignorarExtras, "") : null;
    this.codigoMap = codigoMap;
  }

  @Override
  public Set<Motivo> parse(FixedLine line) {
    String text = line.column(pos0, pos1).get(String.class);

    Set<Motivo> distintos = new LinkedHashSet<>();

    splitEqually(text).stream()
        .map(codigoMap::get)
        .filter(o -> o != null)
        .forEach(distintos::add);

    if (ignorarExtras != null && distintos.size() > 1) {
      distintos.remove(ignorarExtras);
    }

    return distintos;
  }

  @Override
  public Motivo vazio() {
    return MotivoVazio.INSTANCE;
  }

  @Override
  public Map<String, Motivo> toMap() {
    return codigoMap;
  }

  // http://stackoverflow.com/a/3760193/717263
  private List<String> splitEqually(String text) {
    List<String> res = new ArrayList<>((text.length() + length - 1) / length);
    for (int start = 0; start < text.length(); start += length) {
      res.add(text.substring(start, Math.min(text.length(), start + length)));
    }
    return res;
  }

}