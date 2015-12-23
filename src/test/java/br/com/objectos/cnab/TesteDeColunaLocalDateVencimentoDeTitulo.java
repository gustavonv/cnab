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

import java.time.LocalDate;

import br.com.objectos.cnab.bradesco.TipoDeVencimento;

import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeColunaLocalDateVencimentoDeTitulo {

  private ColunaWriter<LocalDate> writer;

  public void deve_formatar_data_de_vencimento_do_titulo() {
    int inicio = 161;
    int fim = 173;
    LocalDate valor = LocalDate.of(2012, 1, 1);
    int tamanho = 6;

    writer = new ColunaLocalDateVencimentoDeTitulo(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("010112"));
  }

  public void deve_retornar_0_para_vencimento_a_vista() {
    int inicio = 161;
    int fim = 173;
    TipoDeVencimento valor = TipoDeVencimento.A_VISTA;
    int tamanho = 6;

    writer = new ColunaLocalDateVencimentoDeTitulo(inicio, fim, valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("000000"));
  }

  public void deve_retornar_9_para_vencimento_contra_apresentacao() {
    int inicio = 161;
    int fim = 173;
    TipoDeVencimento valor = TipoDeVencimento.CONTRA_APRESENTACOES;
    int tamanho = 6;

    writer = new ColunaLocalDateVencimentoDeTitulo(inicio, fim, valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("999999"));
  }

  public void deve_retornar_7_para_vencimento_de_cobranca_sem_registro() {
    int inicio = 161;
    int fim = 173;
    TipoDeVencimento valor = TipoDeVencimento.COBRANCA_SEM_REGISTRO;
    int tamanho = 6;

    writer = new ColunaLocalDateVencimentoDeTitulo(inicio, fim, valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("777777"));
  }

  public void deve_retornar_8_para_vencimentos_de_titulos_registrados() {
    int inicio = 161;
    int fim = 173;
    TipoDeVencimento valor = TipoDeVencimento.ALTERAR_PARA_A_VISTA;
    int tamanho = 6;

    writer = new ColunaLocalDateVencimentoDeTitulo(inicio, fim, valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("888888"));
  }

}