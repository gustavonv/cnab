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

import java.util.Arrays;

import br.com.objectos.core.Preconditions;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
abstract class Coluna<T> implements ColunaWriter<T> {

  final int inicio;

  final int fim;

  final int tamanho;

  String id;

  private boolean optional;

  public Coluna(int inicio, int fim) {
    this.inicio = inicio;
    this.fim = fim;
    this.tamanho = fim - inicio + 1;

    Preconditions.checkArgument(inicio >= 0, "Inicio deve ser maior ou igual a zero");
    Preconditions.checkArgument(fim >= inicio, "Fim deve ser maior ou igual ao inicio");
  }

  @Override
  public final int getInicio() {
    return inicio;
  }

  @Override
  public final int getFim() {
    return fim;
  }

  @Override
  public ColunaWriter<T> withId(String id) {
    this.id = id;
    return this;
  }

  @Override
  public final ColunaWriter<T> optional() {
    optional = true;
    return this;
  }

  int getTamanho() {
    return tamanho;
  }

  boolean isOptional() {
    return optional;
  }

  String blankString() {
    char[] chars = new char[tamanho];
    Arrays.fill(chars, ' ');
    return new String(chars);
  }

}