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

import static com.google.common.collect.Maps.newLinkedHashMap;

import java.util.Map;

import br.com.objectos.comuns.io.FixedLine;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class RegistroPadrao implements Registro {

  final Banco banco;

  final Map<CnabKey<?, ?>, Object> map;

  public RegistroPadrao(Banco banco, Spec spec, FixedLine line) {
    this.banco = banco;

    Map<CnabKey<?, ?>, Object> map = newLinkedHashMap();

    for (CnabKey<?, ?> key : spec.keySet()) {
      Object value = key.apply(banco, line);
      map.put(key, value);
    }

    this.map = map;
  }

  @Override
  public Banco getBanco() {
    return banco;
  }

  @Override
  public String toString() {
    return map.toString();
  }

}