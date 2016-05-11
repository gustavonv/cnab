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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeCodigo {

  public void zeros_a_esquerda_devem_ser_removidos() {
    Codigo res = Codigo.valueOf("003400C");
    assertThat(res, hasToString(equalTo("3400C")));
  }

  public void numero_sem_zeros_a_esquerda() {
    Codigo res = Codigo.valueOf("1234XPTO");
    assertThat(res, hasToString(equalTo("1234XPTO")));
  }

  public void string_vazia() {
    Codigo res = Codigo.valueOf("");
    assertThat(res, hasToString(equalTo("")));
  }

}