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

import static br.com.objectos.jabuticava.cnab.Itau.loteRemessa;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cep;
import br.com.objectos.jabuticava.Estado;
import br.com.objectos.jabuticava.TipoDeCadastroRFB;
import br.com.objectos.jabuticava.cnab.remessa.Comando;
import br.com.objectos.jabuticava.cnab.remessa.EspecieDeTitulo;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeLoteRemessaItau {

  private final Banco banco = Banco.ITAU;
  private String linha;

  @BeforeClass
  public void setUp() throws IOException {
    URL url = Resources.getResource(getClass(), "/lote-itau.txt");
    linha = Resources.toString(url, Charsets.UTF_8);
  }

  public void id_do_registro() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().idDoRegistro();
    String valor = "ABC";
    writeAndAssert(col, valor);
  }

  public void codigo_de_inscricao_da_empresa() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().codigoDeInscricao();
    int valor = 4;
    writeAndAssert(col, valor);
  }

  public void numero_de_inscricao_da_empresa() {
    CnabKey<ItauLoteRemessa, CadastroRFB> col = loteRemessa().numeroDeInscricao();
    CadastroRFB valor = CadastroRFB.valueOf(TipoDeCadastroRFB.CNPJ, 7430629000110l);
    writeAndAssert(col, valor);
  }

  public void agencia_matedora_da_conta() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().agencia();
    int valor = 789;
    writeAndAssert(col, valor);
  }

  public void zeros() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().zeros();
    String valor = "1";
    writeAndAssert(col, valor);
  }

  public void conta() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().conta();
    int valor = 12349;
    writeAndAssert(col, valor);
  }

  public void dac() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().dac();
    int valor = 2;
    writeAndAssert(col, valor);
  }

  public void brancos() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().brancos();
    String valor = " ";
    writeAndAssert(col, valor);
  }

  public void instrucao_alegacao() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().instrucaoCancelada();
    int valor = 1; // N
    writeAndAssert(col, valor);
  }

  public void id_do_titulo_na_empresa() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().usoDaEmpresa();
    String valor = "190101";
    writeAndAssert(col, valor);
  }

  public void nosso_numero() {
    CnabKey<ItauLoteRemessa, Long> col = loteRemessa().nossoNumero();
    long valor = 0;
    writeAndAssert(col, valor);
  }

  public void quantidade_de_moeda() {
    CnabKey<ItauLoteRemessa, Double> col = loteRemessa().quantidadeMoeda();
    double valor = 0d;
    writeAndAssert(col, valor);
  }

  public void numero_da_carteira() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().carteiraNumero();
    int valor = 112;
    writeAndAssert(col, valor);
  }

  public void uso_do_banco() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().usoDoBanco();
    String valor = "";
    writeAndAssert(col, valor);
  }

  public void carteira() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().carteiraCodigo();
    String valor = "I";
    writeAndAssert(col, valor);
  }

  public void codigo_de_ocorrecia() {
    CnabKey<ItauLoteRemessa, Comando> col = loteRemessa().comando();
    Comando valor = Comando.REMESSA;
    writeAndAssert(col, valor);
  }

  public void numero_do_documento() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().numeroDocumento();
    String valor = "123/ABC";
    writeAndAssert(col, valor);
  }

  public void vencimento_do_titulo() {
    CnabKey<ItauLoteRemessa, LocalDate> col = loteRemessa().vencimento();
    LocalDate valor = LocalDate.of(2012, 11, 12);
    writeAndAssert(col, valor);
  }

  public void valor_do_titulo() {
    CnabKey<ItauLoteRemessa, Double> col = loteRemessa().valorTitulo();
    double valor = 948.14;
    writeAndAssert(col, valor);
  }

  public void codigo_do_banco() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().codigoBanco();
    String valor = "237";
    writeAndAssert(col, valor);
  }

  public void agencia_cobradora() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().agenciaCobradora();
    String valor = "000000";
    writeAndAssert(col, valor);
  }

  public void especie_do_titulo() {
    CnabKey<ItauLoteRemessa, EspecieDeTitulo> col = loteRemessa().especie();
    EspecieDeTitulo valor = EspecieDeTitulo.DUPLICATA;
    writeAndAssert(col, valor);
  }

  public void identificacao() {
    CnabKey<ItauLoteRemessa, Boolean> col = loteRemessa().aceite();
    Boolean valor = Boolean.FALSE;
    writeAndAssert(col, valor);
  }

  public void emissao_do_titulo() {
    CnabKey<ItauLoteRemessa, LocalDate> col = loteRemessa().emissao();
    LocalDate valor = LocalDate.of(2012, 10, 9);
    writeAndAssert(col, valor);
  }

  public void primeira_instrucao() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().instrucao1();
    int valor = 9;
    writeAndAssert(col, valor);
  }

  public void segunda_instrucao() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().instrucao2();
    int valor = 52;
    writeAndAssert(col, valor);
  }

  public void valor_cobrado_por_atraso() {
    CnabKey<ItauLoteRemessa, Double> col = loteRemessa().moraDia();
    double valor = 2.53;
    writeAndAssert(col, valor);
  }

  public void limite_para_concessao_de_desconto() {
    CnabKey<ItauLoteRemessa, LocalDate> col = loteRemessa().descontoAte();
    LocalDate valor = null;
    writeAndAssert(col, valor);
  }

  public void valor_do_desconto() {
    CnabKey<ItauLoteRemessa, Double> col = loteRemessa().valorDesconto();
    double valor = 0d;
    writeAndAssert(col, valor);
  }

  public void valor_iof() {
    CnabKey<ItauLoteRemessa, Double> col = loteRemessa().valorIOF();
    double valor = 0d;
    writeAndAssert(col, valor);
  }

  public void valor_abatimento() {
    CnabKey<ItauLoteRemessa, Double> col = loteRemessa().valorAbatimento();
    double valor = 0d;
    writeAndAssert(col, valor);
  }

  public void tipo_de_inscricao_do_sacado() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().sacadoInscricaoTipo();
    Integer valor = 2;
    writeAndAssert(col, valor);
  }

  public void numero_de_inscricao_do_sacado() {
    CnabKey<ItauLoteRemessa, CadastroRFB> col = loteRemessa().sacadoInscricaoNumero();
    CadastroRFB valor = CadastroRFB.valueOf(TipoDeCadastroRFB.CNPJ, 56291625000104l);
    writeAndAssert(col, valor);
  }

  public void nome_do_sacado() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().sacadoNome();
    String valor = "SACADOA";
    writeAndAssert(col, valor);
  }

  public void endereco_do_sacado() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().sacadoLogradouro();
    String valor = "Rua Demóstenes, 627";
    writeAndAssert(col, valor);
  }

  public void bairro_do_sacado() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().sacadoBairro();
    String valor = "Centro";
    writeAndAssert(col, valor);
  }

  public void cep() {
    CnabKey<ItauLoteRemessa, Cep> col = loteRemessa().sacadoCep();
    Cep valor = Cep.valueOf("10124-500");
    writeAndAssert(col, valor);
  }

  public void cidade() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().sacadoCidade();
    String valor = "Santa Barbara";
    writeAndAssert(col, valor);
  }

  public void estado() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().sacadoEstado();
    String valor = Estado.SP.name();
    writeAndAssert(col, valor);
  }

  public void sacador_avalista() {
    CnabKey<ItauLoteRemessa, String> col = loteRemessa().sacadorAvalista();
    String valor = "SACADOB";
    writeAndAssert(col, valor);
  }

  public void data_de_mora() {
    CnabKey<ItauLoteRemessa, LocalDate> col = loteRemessa().dataMora();
    LocalDate valor = null;
    writeAndAssert(col, valor);
  }

  public void prazo() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().prazo();
    int valor = 2;
    writeAndAssert(col, valor);
  }

  public void numero_sequencial_do_registro() {
    CnabKey<ItauLoteRemessa, Integer> col = loteRemessa().seqRegistro();
    int valor = 2;
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