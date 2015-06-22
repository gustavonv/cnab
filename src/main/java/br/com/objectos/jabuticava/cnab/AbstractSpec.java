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

import static com.google.common.collect.Sets.newLinkedHashSet;

import java.util.Set;

import br.com.objectos.jabuticava.cnab.CnabKey.Construtor;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class AbstractSpec implements Spec {

  final Set<CnabKey<?, ?>> keySet = newLinkedHashSet();

  @Override
  public final Set<CnabKey<?, ?>> keySet() {
    return keySet;
  }

  <K extends BancoKey, V> Reconf<K, V> reconf(CnabKey<K, V> key) {
    return new Reconf<K, V>(key);
  }

  class Reconf<K extends BancoKey, V> {

    private final CnabKey<K, V> key;

    public Reconf(CnabKey<K, V> key) {
      this.key = key;
    }

    public CnabKey<K, V> moveTo(int pos0, int pos1) {
      CnabKey<K, V> newKey = key.moveTo(pos0, pos1);
      return reconf(newKey);
    }

    public CnabKey<K, V> optional() {
      CnabKey<K, V> newKey = key.optional();
      return reconf(newKey);
    }

    public CnabKey<K, V> withDefaultValue(V value) {
      CnabKey<K, V> newKey = key.withDefaultValue(value);
      return reconf(newKey);
    }

    private CnabKey<K, V> reconf(CnabKey<K, V> newKey) {
      if (keySet.contains(newKey)) {
        keySet.remove(newKey);
      }

      keySet.add(newKey);

      return newKey;
    }

  }

  class CnabKeyDecorator<K extends BancoKey> {

    private final CnabKey.Construtor<K> construtor;

    public CnabKeyDecorator(Construtor<K> construtor) {
      this.construtor = construtor;
    }

    public CnabKeyDecorator<K> id(String id) {
      construtor.id(id);
      return this;
    }

    public CnabKeyDecorator<K> at(int pos0, int pos1) {
      construtor.at(pos0, pos1);
      return this;
    }

    public CnabKeyDecorator<K> optional() {
      construtor.optional();
      return this;
    }

    public <V> CnabKey<K, V> get(Class<V> type) {
      CnabKey<K, V> key = construtor.get(type);
      keySet.add(key);
      return key;
    }

    public <V> CnabKey<K, V> getWithDefaultValue(Class<V> type, V value) {
      CnabKey<K, V> key = construtor.getWithDefaultValue(type, value);
      keySet.add(key);
      return key;
    }

  }

}