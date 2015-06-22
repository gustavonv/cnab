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

import br.com.objectos.cnab.BancoKey;
import br.com.objectos.cnab.CnabKey;
import br.com.objectos.cnab.Lote;
import br.com.objectos.cnab.LoteKey;

import com.google.common.base.Function;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class LoteToCnabKey<B extends BancoKey & LoteKey, V> implements Function<Lote, V> {

  private final CnabKey<B, V> key;

  private LoteToCnabKey(CnabKey<B, V> key) {
    this.key = key;
  }

  public static <B extends BancoKey & LoteKey, V> Function<Lote, V> of(CnabKey<B, V> key) {
    return new LoteToCnabKey<B, V>(key);
  }

  @Override
  public V apply(Lote input) {
    return input.get(key);
  }

}