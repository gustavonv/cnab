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

import br.com.objectos.jabuticava.Cep;
import br.com.objectos.jabuticava.ExcecaoDeCepInvalido;

import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeColunaCep {

  private ColunaWriter<Cep> writer;

  public void deve_formatar_cep() {
    int inicio = 0;
    int fim = 7;
    int tamanho = 8;
    Cep valor = Cep.valueOf(20260160);

    writer = new ColunaCep(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("20260160"));
  }

  @Test(expectedExceptions = { ExcecaoDeCepInvalido.class })
  public void deve_lancar_excecao_ao_receber_cep_invalido() {
    int inicio = 0;
    int fim = 0;
    Cep valor = Cep.valueOf("INVALIDO");

    writer = new ColunaCep(inicio, fim).set(valor);
    writer.get();
  }

  @Test(expectedExceptions = { NullPointerException.class })
  public void deve_lancar_excecao_ao_receber_cep_nulo() {
    int inicio = 0;
    int fim = 0;
    Cep valor = null;

    writer = new ColunaCep(inicio, fim).set(valor);
    writer.get();
  }

}