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

import java.time.LocalDate;

import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeColunaLocalDate {

  private ColunaWriter<LocalDate> writer;

  public void deve_formatar_coluna_data_limite_para_desconto_no_padrao_DD_MM_AA() {
    int inicio = 0;
    int fim = 5;
    LocalDate data = LocalDate.of(2012, 1, 1);
    int tamanho = 6;

    writer = new ColunaLocalDate(inicio, fim).set(data);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("010112"));
  }

  public void deve_retornar_000000_caso_data_seja_null() {
    int inicio = 0;
    int fim = 5;
    LocalDate data = null;
    int tamanho = 6;

    writer = new ColunaLocalDate(inicio, fim).set(data);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("000000"));
  }

}