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
public class TesteDeColunaValoresFinanceiro {

  private ColunaWriter<Double> writer;

  public void deve_formatar_valor_cobrado_por_atraso() {
    int inicio = 161;
    int fim = 173;
    double valor = 507d;
    int tamanho = 13;

    writer = new ColunaValoresFinanceiros(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("0000000050700"));
  }

  public void deve_formatar_valor_do_titulo() {
    int inicio = 127;
    int fim = 139;
    double valor = 507d;
    int tamanho = 13;

    writer = new ColunaValoresFinanceiros(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("0000000050700"));
  }

  public void deve_formatar_caso_valor_possuir_casas_decimais() {
    int inicio = 127;
    int fim = 139;
    double valor = 507.85;
    int tamanho = 13;

    writer = new ColunaValoresFinanceiros(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("0000000050785"));
  }

  public void caso_valor_for_maior_que_tamanho_lancar_excecao() {
    int inicio = 0;
    int fim = 7;
    double valor = 1234567.89;
    int tamanho = 8;

    writer = new ColunaValoresFinanceiros(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res, res.length(), equalTo(tamanho));
    assertThat(res, res, equalTo("xxxxxxxx"));
  }

  @Test(expectedExceptions = { IllegalArgumentException.class })
  public void caso_valor_seja_negativo_lancar_excecao() {
    int inicio = 127;
    int fim = 139;
    double valor = -1d;

    writer = new ColunaValoresFinanceiros(inicio, fim).set(valor);
    writer.get();
  }

}