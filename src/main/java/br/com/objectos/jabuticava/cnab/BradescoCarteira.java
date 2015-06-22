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

import br.com.objectos.jabuticava.cnab.remessa.Agencia;
import br.com.objectos.jabuticava.cnab.remessa.Carteira;
import br.com.objectos.jabuticava.cnab.remessa.Cobranca;
import br.com.objectos.jabuticava.cnab.remessa.Conta;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class BradescoCarteira {

  private final Carteira carteira;

  private final Agencia agencia;

  private final Conta conta;

  public BradescoCarteira(Carteira carteira, Agencia agencia, Conta conta) {
    this.carteira = carteira;
    this.agencia = agencia;
    this.conta = conta;
  }

  public BradescoCarteira(Cobranca cobranca) {
    this(cobranca.getCarteira(), cobranca.getAgencia(), cobranca.getConta());
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    s.append("0");
    s.append(carteira());
    s.append(agencia());
    s.append(conta());

    return s.toString();
  }

  private String carteira() {
    switch (carteira) {
    case COBRANCA_SIMPLES_COM_REGISTRO:
      return "009";
    default:
      throw new IllegalArgumentException();
    }
  }

  private String agencia() {
    return new ColunaInteger(25, 29)
        .set(agencia.getCodigo())
        .get();
  }

  private String conta() {
    return new ColunaInteger(30, 36)
        .set(conta.getNumero())
        .get()

        +

        new ColunaInteger(37, 37)
            .set(conta.getDigito())
            .get();
  }

}