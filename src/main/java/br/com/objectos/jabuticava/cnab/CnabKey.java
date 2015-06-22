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

import static com.google.common.base.Preconditions.checkNotNull;

import br.com.objectos.comuns.io.ColumnConversionException;
import br.com.objectos.comuns.io.FixedLine;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CnabKey<K extends BancoKey, V> {

  private final Class<K> keyClass;

  private final String id;

  final Class<V> type;

  final int pos0;

  final int pos1;

  final boolean optional;

  final Supplier<V> defaultSupplier;

  CnabKey(Class<K> keyClass, String id, Class<V> type, int pos0, int pos1, boolean optional) {
    this(keyClass, id, type, pos0, pos1, optional, Suppliers.<V> ofInstance(null));
  }

  CnabKey(Class<K> keyClass,
          String id,
          Class<V> type,
          int pos0,
          int pos1,
          boolean optional,
          Supplier<V> defaultSupplier) {
    this.keyClass = checkNotNull(keyClass, "keyClass");
    this.id = checkNotNull(id, "id");
    this.type = checkNotNull(type, "type");
    this.pos0 = pos0;
    this.pos1 = pos1;
    this.optional = optional;
    this.defaultSupplier = defaultSupplier;

    Preconditions.checkArgument(pos0 >= 0, "pos0 deve ser >= 0");
    Preconditions.checkArgument(pos1 > 0, "pos1 deve ser > 0");
  }

  public static <K extends BancoKey> Construtor<K> of(Class<K> keyClass) {
    return new Construtor<K>(keyClass);
  }

  public CnabKey<K, V> moveTo(int pos0, int pos1) {
    return new CnabKey<K, V>(keyClass, id, type, pos0, pos1, optional);
  }

  public CnabKey<K, V> optional() {
    return new CnabKey<K, V>(keyClass, id, type, pos0, pos1, true);
  }

  public CnabKey<K, V> withDefaultValue(V value) {
    Supplier<V> supplier = Suppliers.ofInstance(value);
    return new CnabKey<K, V>(keyClass, id, type, pos0, pos1, true, supplier);
  }

  public String getId() {
    return id.toString();
  }

  public Class<?> getType() {
    return type;
  }

  Object apply(Banco banco, FixedLine line) {
    Object value = null;

    try {
      if (optional) {
        value = line.column(pos0, pos1).or(type, defaultSupplier);
      } else {
        value = line.column(pos0, pos1).get(type);
      }
    } catch (ColumnConversionException e) {
      throw new ExcecaoCnabKey(line, this, e);
    }

    return value;
  }

  public static class Construtor<K extends BancoKey> {

    private final Class<K> keyClass;

    private String id;

    private int pos0;

    private int pos1;

    private boolean optional;

    Construtor(Class<K> keyClass) {
      this.keyClass = Preconditions.checkNotNull(keyClass);
    }

    public Construtor<K> id(String id) {
      this.id = id;
      return this;
    }

    public Construtor<K> at(int pos0, int pos1) {
      this.pos0 = pos0;
      this.pos1 = pos1;
      return this;
    }

    public Construtor<K> optional() {
      this.optional = true;
      return this;
    }

    public <V> CnabKey<K, V> get(Class<V> type) {
      return new CnabKey<K, V>(keyClass, id, type, pos0, pos1, optional);
    }

    public <V> CnabKey<K, V> getWithDefaultValue(Class<V> type, V value) {
      this.optional = true;
      Supplier<V> supplier = Suppliers.ofInstance(value);
      return new CnabKey<K, V>(keyClass, id, type, pos0, pos1, optional, supplier);
    }

  }

  @Override
  public String toString() {
    return id;
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(id, keyClass);
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (obj instanceof CnabKey) {
      final CnabKey<?, ?> that = (CnabKey<?, ?>) obj;
      return Objects.equal(this.id, that.id)
          && Objects.equal(this.keyClass, that.keyClass);
    } else {
      return false;
    }
  }

}