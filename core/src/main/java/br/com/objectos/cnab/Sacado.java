/*
 * Copyright 2016 Objectos, Fábrica de Software LTDA.
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

import br.com.objectos.auto.AutoPojo;
import br.com.objectos.jabuticava.CadastroRFB;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@AutoPojo
public abstract class Sacado {

  abstract CadastroRFB cadastroRfb();
  abstract String nome();
  abstract Endereco endereco();

  Sacado() {
  }

  public static Sacado of(CadastroRFB cadastroRfb, String nome, Endereco endereco) {
    return new SacadoPojo(cadastroRfb, nome, endereco);
  }

}