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

import static br.com.objectos.core.lang.Preconditions.checkArgument;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
abstract class ColunaNumerica<T extends Number> extends Coluna<T> {

  private T valor;

  public ColunaNumerica(int inicio, int fim) {
    super(inicio, fim);
  }

  ColunaNumerica(int inicio, int fim, T valor) {
    super(inicio, fim);

    long longValue = valor.longValue();
    checkArgument(longValue >= 0, "Valor deve ser maior ou igual a 0");
    this.valor = valor;
  }

  @Override
  public String get() {
    return format(inicio, fim, valor);
  }

  private String format(int inicio, int fim, T valor) {
    String res = blankString();

    if (valor != null) {
      String saida = "%0" + getTamanho() + "d";
      long val = valor.longValue();
      res = String.format(saida, val);
    }

    return res.substring(0, tamanho);
  }

}