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

import static com.google.common.base.Preconditions.checkNotNull;

import br.com.objectos.way.base.br.Cep;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ColunaCep extends Coluna<Cep> {

  private final Cep valor;

  public ColunaCep(int inicio, int fim) {
    super(inicio, fim);
    this.valor = Cep.vazio();
  }

  private ColunaCep(int inicio, int fim, Cep valor) {
    super(inicio, fim);

    checkNotNull(valor, "Cep não pode ser nulo");

    this.valor = valor;
  }

  @Override
  public String get() {
    return format(inicio, fim, valor);
  }

  @Override
  public ColunaWriter<Cep> set(Object valor) {
    Cep val = Cep.class.cast(valor);
    return new ColunaCep(inicio, fim, val);
  }

  private String format(int inicio, int fim, Cep valor) {
    int prefixo = valor.getPrefixo();
    int sufixo = valor.getSufixo();

    return String.format("%05d%03d", prefixo, sufixo);
  }

}