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

import br.com.objectos.cnab.remessa.Caixa;

import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeColunaAlfanumerica {

  private ColunaWriter<String> writer;

  public void deve_formatar_coluna_nome_do_sacado_em_caixa_alta() {
    int inicio = 235;
    int fim = 274;
    String valor = "Fulano de tal";
    Caixa caixa = Caixa.ALTA;
    int tamanho = 40;

    writer = new ColunaAlfanumerica(inicio, fim, caixa).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res.trim(), equalTo(caixaAlta(valor, tamanho)));
  }

  public void deve_formatar_coluna_endereco_do_sacado_em_caixa_normal() {
    int inicio = 275;
    int fim = 314;
    String valor = "Rua dos fulanos, 244";
    int tamanho = 40;

    writer = new ColunaAlfanumerica(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res.trim(), equalTo(caixaNormal(valor, tamanho)));
  }

  public void deve_formatar_digito_de_conta_em_caixa_alta() {
    int inicio = 20;
    int fim = 20;
    String valor = "a";
    Caixa caixa = Caixa.ALTA;
    int tamanho = 1;

    writer = new ColunaAlfanumerica(inicio, fim, caixa).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo(caixaAlta(valor, tamanho)));
  }

  @Test(expectedExceptions = { NullPointerException.class })
  public void caso_texto_for_null_lancar_excecao() {
    int inicio = 0;
    int fim = 10;
    Caixa caixa = Caixa.ALTA;
    String valor = null;

    writer = new ColunaAlfanumerica(inicio, fim, caixa).set(valor);
    writer.get();
  }

  @Test(expectedExceptions = { IllegalArgumentException.class })
  public void caso_texto_for_vazio_lancar_excecao() {
    int inicio = 0;
    int fim = 10;
    String valor = "";

    writer = new ColunaAlfanumerica(inicio, fim).set(valor);
    writer.get();
  }

  public void caso_texto_ultrapasse_largura_truncar_texto() {
    int inicio = 0;
    int fim = 4;
    Caixa caixa = Caixa.BAIXA;
    String valor = "teste-123";
    int tamanho = 5;

    writer = new ColunaAlfanumerica(inicio, fim, caixa).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("teste"));
  }

  public void caso_texto_com_acento() {
    int inicio = 0;
    int fim = 2;
    String valor = "São";
    int tamanho = 3;

    writer = new ColunaAlfanumerica(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("Sao"));
  }

  public void caso_texto_com_cedilha() {
    int inicio = 0;
    int fim = 5;
    String valor = "paçoca";
    int tamanho = 6;

    writer = new ColunaAlfanumerica(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("pacoca"));
  }

  private String caixaAlta(String texto, int largura) {
    return caixaNormal(texto, largura).toUpperCase();
  }

  private String caixaNormal(String texto, int largura) {
    return texto.trim();
  }

}