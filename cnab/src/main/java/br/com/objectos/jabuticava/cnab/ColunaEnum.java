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

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ColunaEnum<E extends Enum<E> & RemessaEnum> extends Coluna<E> {

  private final Class<E> enumType;

  private final RemessaEnum valor;

  public ColunaEnum(int inicio, int fim, Class<E> enumType) {
    this(inicio, fim, enumType, null);
  }

  public ColunaEnum(int inicio, int fim, Class<E> enumType, E valor) {
    super(inicio, fim);
    this.enumType = enumType;
    this.valor = valor;
  }

  @Override
  public String get() {
    String res = blankString();

    if (valor != null) {
      res = valor.getValor();
    }

    return res;
  }

  @Override
  public Class<E> getType() {
    return enumType;
  }

  @Override
  public ColunaWriter<E> set(Object valor) {
    E val = enumType.cast(valor);
    return new ColunaEnum<E>(inicio, fim, enumType, val);
  }

}