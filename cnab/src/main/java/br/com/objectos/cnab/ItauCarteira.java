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

import br.com.objectos.cnab.remessa.Carteira;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ItauCarteira {

  private final Carteira carteira;

  public ItauCarteira(Carteira carteira) {
    this.carteira = carteira;
  }

  public String getCodigo() {
    return codigo();
  }

  public int getNumero() {
    return numero();
  }

  private String codigo() {
    switch (carteira) {
    case COBRANCA_SIMPLES_COM_REGISTRO:
      return "I";
    default:
      throw new IllegalArgumentException();
    }
  }

  private int numero() {
    switch (carteira) {
    case COBRANCA_SIMPLES_COM_REGISTRO:
      return 112;
    default:
      throw new IllegalArgumentException();
    }
  }

}