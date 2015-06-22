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

import java.util.Map;
import java.util.Set;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class AbstractRegistroRemessa<T extends AbstractRegistroRemessa<T>> {

  private final Banco banco;

  private final Map<CnabKey<?, ?>, Object> map;

  public AbstractRegistroRemessa(Banco banco, Map<CnabKey<?, ?>, Object> map) {
    this.banco = banco;
    this.map = map;
  }

  String write() {
    StringBuilder res = new StringBuilder();

    Modelo modelo = banco.getModelo();
    RemessaSpec spec = getSpec(modelo);

    Set<CnabKey<?, ?>> keys = spec.keySet();
    for (CnabKey<?, ?> key : keys) {
      ColunaWriter<?> coluna = spec.colunaOf(key);
      Object value = valueOf(key);

      if (value != null) {
        coluna = coluna.set(value);
      }

      String text = coluna.get();
      res.append(text);
    }

    return res.toString();
  }

  abstract RemessaSpec getSpec(Modelo modelo);

  private Object valueOf(CnabKey<?, ?> key) {
    return map.get(key);
  }

  @Override
  public String toString() {
    return write();
  }

  abstract static class AbstractBuilder<S extends AbstractBuilder<S, R>, R extends AbstractRegistroRemessa<R>>
      implements br.com.objectos.way.core.lang.Builder<R> {

    final Banco banco;

    final Map<CnabKey<?, ?>, Object> map = newHashMap();

    public AbstractBuilder(Banco banco) {
      this.banco = banco;
    }

    public <T> S put(CnabKey<?, T> key, T value) {
      map.put(key, value);
      return getSelf();
    }

    abstract S getSelf();

  }

}