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

import static br.com.objectos.cnab.Itau.loteRemessa;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
@Test
public class TesteDeLoteRemessaItauCamposOpcionais {

  private final Banco banco = Banco.ITAU;
  private String linha;

  @BeforeClass
  public void setUp() throws IOException {
    URL url = Resources.getResource(getClass(), "/lote-itau-campos-opcionais.txt");
    linha = Resources.toString(url, Charsets.UTF_8);
  }

  public void agencia_matedora_da_conta() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().agencia();
    int valor = 0;
    writeAndAssert(col, valor);
  }

  public void brancos() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().brancos();
    String valor = " ";
    writeAndAssert(col, valor);
  }

  public void instrucao_alegacao() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().instrucaoCancelada();
    int valor = 0; // N
    writeAndAssert(col, valor);
  }

  public void nosso_numero() {
    CnabKey<ItauLoteRemessa, Long> col = loteRemessa().nossoNumero();
    long valor = 0;
    writeAndAssert(col, valor);
  }

  public void uso_do_banco() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().usoDoBanco();
    String valor = null;
    writeAndAssert(col, valor);
  }
  public void uso_do_banco_string_vazia() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().usoDoBanco();
    String valor = "";
    writeAndAssert(col, valor);
  }

  public void limite_para_concessao_de_desconto() {
    CnabKey<ItauLoteRemessa, LocalDate> col = loteRemessa().descontoAte();
    LocalDate valor = null;
    writeAndAssert(col, valor);
  }

  public void bairro_do_sacado() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().sacadoBairro();
    String valor = null;
    writeAndAssert(col, valor);
  }
  public void bairro_do_sacado_string_vazia() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().sacadoBairro();
    String valor = "";
    writeAndAssert(col, valor);
  }

  private <T> void writeAndAssert(CnabKey<ItauLoteRemessa, T> key, T value) {
    LoteRemessa lote = novoLote(key, value);
    String res = lote.write();

    assertCol(key, res);
  }

  private <T> LoteRemessa novoLote(CnabKey<ItauLoteRemessa, T> key, T value) {
    return LoteRemessa.paraBanco(banco)
        .put(key, value)
        .build();
  }

  private void assertCol(CnabKey<?, ?> col, String lote) {
    String contra = linha;
    String prova = contra.substring(col.pos0, col.pos1);

    String res = lote.substring(col.pos0, col.pos1);
    assertThat(res, equalTo(prova));
  }

}