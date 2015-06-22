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

import static br.com.objectos.cnab.Itau.headerRemessa;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URL;

import br.com.objectos.cnab.Banco;
import br.com.objectos.cnab.CnabKey;
import br.com.objectos.cnab.HeaderRemessa;
import br.com.objectos.cnab.ItauHeaderRemessa;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeHeaderRemessaItau {

  private final Banco banco = Banco.ITAU;
  private String linha;

  @BeforeClass
  public void setUp() throws IOException {
    URL url = Resources.getResource(getClass(), "/header-itau.txt");
    linha = Resources.toString(url, Charsets.UTF_8);
  }

  public void tipo_registro() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().tipoDeRegistro();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void identificacao_do_arquivo() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().operacao();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void literal_remessa() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().literalRemessa();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void codigo_servico() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().codigoServico();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void literal_servico() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().literalServico();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void agencia() {
    CnabKey<ItauHeaderRemessa, Integer> col = headerRemessa().agencia();
    int valor = 234;
    writeAndAssert(col, valor);
  }

  public void conta() {
    CnabKey<ItauHeaderRemessa, Integer> col = headerRemessa().conta();
    int valor = 9845;
    writeAndAssert(col, valor);
  }

  public void dac() {
    CnabKey<ItauHeaderRemessa, Integer> col = headerRemessa().dac();
    int valor = 2;
    writeAndAssert(col, valor);
  }

  public void nome_empresa() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().nomeEmpresa();
    String valor = "OBJECTOS FABRICA DE SOFTWARE L";
    writeAndAssert(col, valor);
  }

  public void numero_banco() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().codigoBanco();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void nome_banco() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().nomeBanco();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void data_arquivo() {
    CnabKey<ItauHeaderRemessa, LocalDate> col = headerRemessa().dataGeracao();
    LocalDate valor = new LocalDate(2012, 3, 14);
    writeAndAssert(col, valor);
  }

  public void seq_registro() {
    CnabKey<ItauHeaderRemessa, String> col = headerRemessa().seqRegistro();
    String valor = "";
    writeAndAssert(col, valor);
  }

  private <T> void writeAndAssert(CnabKey<ItauHeaderRemessa, T> key, T value) {
    HeaderRemessa lote = novoHeader(key, value);
    String res = lote.write();

    assertCol(key, res);
  }

  private <T> HeaderRemessa novoHeader(CnabKey<ItauHeaderRemessa, T> key, T value) {
    return HeaderRemessa.paraBanco(banco)
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