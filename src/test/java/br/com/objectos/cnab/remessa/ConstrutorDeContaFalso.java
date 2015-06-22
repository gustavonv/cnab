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
package br.com.objectos.cnab.remessa;

import br.com.objectos.cnab.remessa.Conta;
import br.com.objectos.cnab.remessa.ContaCnab;




/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeContaFalso implements Conta.Construtor {

  private int numero;

  private int digito;

  @Override
  public Conta novaInstancia() {
    return new ContaCnab(this);
  }

  public ConstrutorDeContaFalso numero(int numero) {
    this.numero = numero;
    return this;
  }

  public ConstrutorDeContaFalso digito(int digito) {
    this.digito = digito;
    return this;
  }

  @Override
  public int getNumero() {
    return numero;
  }

  @Override
  public int getDigito() {
    return digito;
  }

}