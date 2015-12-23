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

import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeColunaNumerica {

  private ColunaWriter<Long> writer;

  public void deve_formatar_codigo_de_inscricao_da_empresa() {
    int inicio = 2;
    int fim = 3;
    long valor = 4;
    int tamanho = 2;

    writer = new ColunaLong(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("04"));
  }

  public void deve_formatar_agencia_mantedora_da_conta() {
    int inicio = 18;
    int fim = 21;
    long valor = 301;
    int tamanho = 4;

    writer = new ColunaLong(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("0301"));
  }

  public void deve_formatar_numero_da_conta_corrente() {
    int inicio = 24;
    int fim = 28;
    long valor = 1234;
    int tamanho = 5;

    writer = new ColunaLong(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("01234"));
  }

  public void deve_formatar_digito_de_auto_conferencia_dac() {
    int inicio = 29;
    int fim = 29;
    long valor = 9;
    int tamanho = 1;

    writer = new ColunaLong(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("9"));
  }

  public void deve_formatar_numero_sequencial() {
    int inicio = 395;
    int fim = 400;
    long valor = 5;
    int tamanho = 6;

    writer = new ColunaLong(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("000005"));
  }

  public void caso_valor_seja_maior_que_tamanho_truncar_valor() {
    int inicio = 0;
    int fim = 2;
    long valor = 3765;
    int tamanho = 3;

    writer = new ColunaLong(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("376"));
  }

  public void caso_valor_for_menor_que_tamanho_adicionar_zeros_a_esquerda() {
    int inicio = 0;
    int fim = 4;
    long valor = 9872;
    int tamanho = 5;

    writer = new ColunaLong(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("09872"));
  }

  @Test(expectedExceptions = { IllegalArgumentException.class })
  public void deve_lancar_excecao_caso_valor_seja_menor_do_que_zero() {
    int inicio = 0;
    int fim = 4;
    long valor = -10000;

    writer = new ColunaLong(inicio, fim).set(valor);
  }

  @Test(expectedExceptions = { IllegalArgumentException.class })
  public void deve_lancar_excecao_caso_inicio_seja_negativo() {
    int inicio = -1;
    int fim = 0;
    long valor = 81;

    writer = new ColunaLong(inicio, fim).set(valor);
  }

  @Test(expectedExceptions = { IllegalArgumentException.class })
  public void deve_lancar_excecao_caso_fim_seja_menor_que_inicio() {
    int inicio = 10;
    int fim = 8;
    long valor = 34;

    writer = new ColunaLong(inicio, fim).set(valor);
  }

}