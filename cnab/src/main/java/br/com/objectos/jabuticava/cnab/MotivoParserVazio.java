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

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import br.com.objectos.comuns.io.FixedLine;
import br.com.objectos.core.util.ImmutableSet;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class MotivoParserVazio implements MotivoParser {

  private final Motivo vazio;

  public MotivoParserVazio() {
    this(MotivoVazio.INSTANCE);
  }

  public MotivoParserVazio(Motivo vazio) {
    this.vazio = vazio;
  }

  @Override
  public Set<Motivo> parse(FixedLine line) {
    return ImmutableSet.of();
  }

  @Override
  public Motivo vazio() {
    return vazio;
  }

  @Override
  public Map<String, Motivo> toMap() {
    return Collections.emptyMap();
  }

}