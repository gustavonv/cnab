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
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ColunaInteger extends ColunaNumerica<Integer> {

  public ColunaInteger(int inicio, int fim) {
    super(inicio, fim);
  }

  private ColunaInteger(int inicio, int fim, Integer valor) {
    super(inicio, fim, valor);
  }

  @Override
  public Class<Integer> getType() {
    return Integer.class;
  }

  @Override
  public ColunaWriter<Integer> set(Object valor) {
    Integer val = Integer.class.cast(valor);
    return new ColunaInteger(inicio, fim, val);
  }

}