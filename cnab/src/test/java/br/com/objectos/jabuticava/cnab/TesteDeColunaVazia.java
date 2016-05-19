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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeColunaVazia {

  private ColunaWriter<String> writer;

  public void deve_formatar_coluna_com_espacos() {
    int inicio = 0;
    int fim = 3;
    int tamanho = 4;
    String valor = " ";

    writer = new ColunaVazia(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("    "));
  }

  public void deve_formatar_coluna_com_zeros() {
    int inicio = 0;
    int fim = 2;
    int tamanho = 3;
    String valor = "0";

    writer = new ColunaVazia(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("000"));
  }

}