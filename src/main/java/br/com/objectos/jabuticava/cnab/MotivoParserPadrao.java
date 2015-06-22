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

import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newLinkedHashSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.objectos.comuns.io.FixedLine;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterables;

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

    Map<String, Motivo> codigoMap = newHashMap();

    for (Motivo motivo : motivos) {
      String codigo = motivo.getCodigo();
      codigoMap.put(codigo, motivo);
    }

    this.ignorarExtras = ignorarExtras != null ? new MotivoPadrao(ignorarExtras, "") : null;
    this.codigoMap = ImmutableSortedMap.copyOf(codigoMap);
  }

  @Override
  public Set<Motivo> parse(FixedLine line) {
    String text = line.column(pos0, pos1).get(String.class);

    Iterable<String> parts;
    parts = Splitter.fixedLength(length).split(text);

    Iterable<Motivo> motivos;
    motivos = Iterables.transform(parts, new ToMotivo());

    Iterable<Motivo> validos;
    validos = Iterables.filter(motivos, Predicates.notNull());

    Set<Motivo> distintos;
    distintos = newLinkedHashSet(validos);

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

  private class ToMotivo implements Function<String, Motivo> {
    @Override
    public Motivo apply(String codigo) {
      return codigoMap.get(codigo);
    }
  }

}