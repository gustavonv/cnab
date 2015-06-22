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

import org.joda.time.LocalDate;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ColunaLocalDate extends Coluna<LocalDate> {

  private final LocalDate valor;

  public ColunaLocalDate(int inicio, int fim) {
    super(inicio, fim);
    this.valor = null;
  }

  private ColunaLocalDate(int inicio, int fim, LocalDate valor) {
    super(inicio, fim);
    this.valor = valor;
  }

  @Override
  public String get() {
    return format(valor);
  }

  @Override
  public ColunaWriter<LocalDate> set(Object valor) {
    LocalDate val = LocalDate.class.cast(valor);
    return new ColunaLocalDate(inicio, fim, val);
  }

  private String format(LocalDate data) {
    if (data != null) {
      return data.toString("ddMMyy");
    }

    return "000000";
  }

}