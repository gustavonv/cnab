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

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ColunaVazia extends Coluna<String> {

  private final String valor;

  public ColunaVazia(int inicio, int fim) {
    super(inicio, fim);
    this.valor = "";
  }

  private ColunaVazia(int inicio, int fim, String valor) {
    super(inicio, fim);
    this.valor = valor;
  }

  @Override
  public String get() {
    return format(inicio, fim, valor);
  }

  @Override
  public ColunaWriter<String> set(Object valor) {
    String val = String.class.cast(valor);
    return new ColunaVazia(inicio, fim, val);
  }

  private String format(int inicio, int fim, String valor) {
    StringBuilder sb = new StringBuilder(valor);

    for (int i = 1; i < getTamanho(); i++) {
      sb.insert(0, valor);
    }

    return sb.toString();
  }

}