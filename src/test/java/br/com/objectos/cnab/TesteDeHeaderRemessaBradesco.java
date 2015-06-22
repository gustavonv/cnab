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

import static br.com.objectos.cnab.Bradesco.headerRemessa;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URL;

import br.com.objectos.cnab.Banco;
import br.com.objectos.cnab.BradescoHeaderRemessa;
import br.com.objectos.cnab.CnabKey;
import br.com.objectos.cnab.HeaderRemessa;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeHeaderRemessaBradesco {

  private final Banco banco = Banco.BRADESCO;
  private String linha;

  @BeforeClass
  public void setUp() throws IOException {
    URL url = Resources.getResource(getClass(), "/header-bradesco.txt");
    linha = Resources.toString(url, Charsets.UTF_8);
  }

  public void identificacao_do_registro() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().idDoRegistro();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void identificacao_do_arquivo() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().idDoRegistro();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void literal_remessa() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().literalRemessa();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void codigo_servico() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().codigoServico();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void literal_servico() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().literalServico();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void codigo_empresa() {
    CnabKey<BradescoHeaderRemessa, Long> col = headerRemessa().codigoEmpresa();
    long valor = 1234l;
    writeAndAssert(col, valor);
  }

  public void nome_empresa() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().nomeEmpresa();
    String valor = "OBJECTOS FABRICA DE SOFTWARE L";
    writeAndAssert(col, valor);
  }

  public void numero_banco() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().numeroBanco();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void nome_banco() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().nomeBanco();
    String valor = "-";
    writeAndAssert(col, valor);
  }

  public void data_arquivo() {
    CnabKey<BradescoHeaderRemessa, LocalDate> col = headerRemessa().dataArquivo();
    LocalDate valor = new LocalDate(2012, 3, 14);
    writeAndAssert(col, valor);
  }

  public void brancos() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().branco();
    String valor = "";
    writeAndAssert(col, valor);
  }

  public void id_sistema() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().idSistema();
    String valor = "";
    writeAndAssert(col, valor);
  }

  public void seq_remessa() {
    CnabKey<BradescoHeaderRemessa, Integer> col = headerRemessa().seqRemessa();
    int valor = 123;
    writeAndAssert(col, valor);
  }

  public void brancos2() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().branco2();
    String valor = "";
    writeAndAssert(col, valor);
  }

  public void seq_registro() {
    CnabKey<BradescoHeaderRemessa, String> col = headerRemessa().seqRegistro();
    String valor = "";
    writeAndAssert(col, valor);
  }

  private <T> void writeAndAssert(CnabKey<BradescoHeaderRemessa, T> key, T value) {
    HeaderRemessa lote = novoHeader(key, value);
    String res = lote.write();

    assertCol(key, res);
  }

  private <T> HeaderRemessa novoHeader(CnabKey<BradescoHeaderRemessa, T> key, T value) {
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