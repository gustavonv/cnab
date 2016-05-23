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

import static br.com.objectos.jabuticava.cnab.Bradesco.loteRemessa;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cep;
import br.com.objectos.jabuticava.Cnpj;
import br.com.objectos.jabuticava.cnab.bradesco.TipoDeIncricaoDoSacado;
import br.com.objectos.jabuticava.cnab.remessa.Comando;
import br.com.objectos.jabuticava.cnab.remessa.EnderecamentoDebitoAutomatico;
import br.com.objectos.jabuticava.cnab.remessa.EspecieDeTitulo;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeLoteRemessaBradesco {

  private final Banco banco = Banco.BRADESCO;
  private String linha;

  @BeforeClass
  public void setUp() throws IOException {
    URL url = Resources.getResource(getClass(), "/lote-bradesco.txt");
    linha = Resources.toString(url, Charsets.UTF_8);
  }

  public void identificacao_do_registro() {
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().idDoRegistro();
    String valor = "ABC";
    writeAndAssert(col, valor);
  }

  public void agencia_de_debito() {
    CnabKey<BradescoLoteRemessa, Integer> col = loteRemessa().agenciaDeDebito();
    Integer valor = null;
    writeAndAssert(col, valor);
  }

  public void digito_da_agencia_de_debito() {
    String valor = " ";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().digitoDaAgenciaDeDebito();
    writeAndAssert(col, valor);
  }

  public void razao_da_conta_corrente() {
    CnabKey<BradescoLoteRemessa, Integer> col = loteRemessa().razaoDaContaCorrente();
    Integer valor = null;
    writeAndAssert(col, valor);
  }

  public void conta_corrente() {
    CnabKey<BradescoLoteRemessa, Integer> col = loteRemessa().contaCorrente();
    Integer valor = null;
    writeAndAssert(col, valor);
  }

  public void digito_da_conta_corrente() {
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().digitoDaContaCorrente();
    String valor = " ";
    writeAndAssert(col, valor);
  }

  public void identificacao_da_empresa_cedente_no_banco() {
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().idDoCedenteNoBanco();
    String valor = "00012345678901234";
    writeAndAssert(col, valor);
  }

  public void numero_de_controle_do_participantes() {
    String valor = "123123";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().numeroDeControleDoParticipante();
    writeAndAssert(col, valor);
  }

  public void codigo_do_banco() {
    int valor = 0; // 237 para débito aut. ou 000 caso contrário
    CnabKey<BradescoLoteRemessa, Integer> col = loteRemessa().codigoDoBanco();
    writeAndAssert(col, valor);
  }

  public void zeros() {
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().zeros();
    String valor = "WHATEVER"; // coluna fixa, será zeros independente do valor
    writeAndAssert(col, valor);
  }

  public void id_do_titulo_no_banco() {
    long valor = 0;
    CnabKey<BradescoLoteRemessa, Long> col = loteRemessa().idDoTituloNoBanco();
    writeAndAssert(col, valor);
  }

  public void valor_do_desconto() {
    double valor = 0d;
    CnabKey<BradescoLoteRemessa, Double> col = loteRemessa().valorDesconto();
    writeAndAssert(col, valor);
  }

  public void condicao_para_emissao_de_cobranca() {
    int valor = 1;
    CnabKey<BradescoLoteRemessa, Integer> col = loteRemessa().condicaoParaEmissaoDeCobranca();
    writeAndAssert(col, valor);
  }

  public void id_para_emissao_de_debito() {
    String valor = " ";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().idParaEmissaoDeDebito();
    writeAndAssert(col, valor);
  }

  public void identificacao_da_operacao_no_banco() {
    String valor = " ";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().idDaOperacaoNoBanco();
    writeAndAssert(col, valor);
  }

  public void indicador_rateio_credito() {
    Boolean valor = Boolean.FALSE;
    CnabKey<BradescoLoteRemessa, Boolean> col = loteRemessa().indicadorRateioCredito();
    writeAndAssert(col, valor);
  }

  public void enderecamento_para_aviso_de_debito() {
    EnderecamentoDebitoAutomatico valor = null;
    CnabKey<BradescoLoteRemessa, EnderecamentoDebitoAutomatico> col;
    col = loteRemessa().enderecamentoParaAvisoDeDebito();
    writeAndAssert(col, valor);
  }

  public void brancos() {
    String valor = " ";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().brancos();
    writeAndAssert(col, valor);
  }

  public void id_da_ocorrencia() {
    Comando valor = Comando.REMESSA;
    CnabKey<BradescoLoteRemessa, Comando> col = loteRemessa().comando();
    writeAndAssert(col, valor);
  }

  public void numero_do_documento() {
    String valor = "10116 S";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().numeroDoDocumento();
    writeAndAssert(col, valor);
  }

  public void vencimento_do_titulo() {
    LocalDate valor = LocalDate.of(2012, 4, 5);
    CnabKey<BradescoLoteRemessa, LocalDate> col = loteRemessa().vencimentoDoTitulo();
    writeAndAssert(col, valor);
  }

  public void valor_do_titulo() {
    double valor = 8925.00d;
    CnabKey<BradescoLoteRemessa, Double> col = loteRemessa().valorDoTitulo();
    writeAndAssert(col, valor);
  }

  public void banco_encarregado_da_cobranca() {
    String valor = "232";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().bancoEncarregadoDaCobranca();
    writeAndAssert(col, valor);
  }

  public void agencia_depositaria() {
    String valor = "50591";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().agenciaDepositaria();
    writeAndAssert(col, valor);
  }

  public void especie_do_titulo() {
    EspecieDeTitulo valor = EspecieDeTitulo.DUPLICATA;
    CnabKey<BradescoLoteRemessa, EspecieDeTitulo> col = loteRemessa().especieDeTitulo();
    writeAndAssert(col, valor);
  }

  public void aceite() {
    Boolean valor = Boolean.FALSE;
    CnabKey<BradescoLoteRemessa, Boolean> col = loteRemessa().aceite();
    writeAndAssert(col, valor);
  }

  public void emissao_do_titulo() {
    LocalDate valor = LocalDate.of(2012, 3, 2);
    CnabKey<BradescoLoteRemessa, LocalDate> col = loteRemessa().emissaoDoTitulo();
    writeAndAssert(col, valor);
  }

  public void primeira_instrucao() {
    int valor = 6;
    CnabKey<BradescoLoteRemessa, Integer> col = loteRemessa().primeiraInstrucao();
    writeAndAssert(col, valor);
  }

  public void segunda_instrucao() {
    int valor = 5;
    CnabKey<BradescoLoteRemessa, Integer> col = loteRemessa().segundaInstrucao();
    writeAndAssert(col, valor);
  }

  public void valor_cobrado_por_atraso() {
    double valor = 23.80d;
    CnabKey<BradescoLoteRemessa, Double> col = loteRemessa().valorCobradoPorAtraso();
    writeAndAssert(col, valor);
  }

  public void limite_para_concessao_de_desconto() {
    CnabKey<BradescoLoteRemessa, LocalDate> col = loteRemessa().limiteParaConcessaoDeDesconto();
    LocalDate valor = null;
    writeAndAssert(col, valor);
  }

  public void valor_iof() {
    double valor = 0d;
    CnabKey<BradescoLoteRemessa, Double> col = loteRemessa().valorIOF();
    writeAndAssert(col, valor);
  }

  public void valor_abatimento() {
    double valor = 0d;
    CnabKey<BradescoLoteRemessa, Double> col = loteRemessa().valorAbatimento();
    writeAndAssert(col, valor);
  }

  public void tipo_de_inscricao_do_sacado() {
    TipoDeIncricaoDoSacado valor = TipoDeIncricaoDoSacado.CNPJ;
    CnabKey<BradescoLoteRemessa, TipoDeIncricaoDoSacado> col;
    col = loteRemessa().tipoDeInscricaoDoSacado();
    writeAndAssert(col, valor);
  }

  public void numero_de_inscricao_do_sacado() {
    CadastroRFB valor = Cnpj.valueOf("07.430.629/0001-10");
    CnabKey<BradescoLoteRemessa, CadastroRFB> col = loteRemessa().numeroDeInscricaoDoSacado();
    writeAndAssert(col, valor);
  }

  public void nome_do_sacado() {
    String valor = "SACADO XYZ INDUSTRIA DE WHATEVERS LTD";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().nomeDoSacado();
    writeAndAssert(col, valor);
  }

  public void endereco_do_sacado() {
    String valor = "Rua Demostenes, 627, cj. 123, Sao Paulo.";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().enderecoDoSacado();
    writeAndAssert(col, valor);
  }

  public void primeira_mensagem() {
    String valor = " ";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().primeiraMensagem();
    writeAndAssert(col, valor);
  }

  public void cep() {
    Cep valor = Cep.valueOf("04614-013");
    CnabKey<BradescoLoteRemessa, Cep> col = loteRemessa().cep();
    writeAndAssert(col, valor);
  }

  public void sacador_avalista() {
    String valor = "007430629000110  SACADOABC";
    CnabKey<BradescoLoteRemessa, String> col = loteRemessa().sacadoAvalista();
    writeAndAssert(col, valor);
  }

  public void numero_sequencial_do_registro() {
    int valor = 2;
    CnabKey<BradescoLoteRemessa, Integer> col = loteRemessa().numeroSequencialDoRegistro();
    writeAndAssert(col, valor);
  }

  private <T> void writeAndAssert(CnabKey<BradescoLoteRemessa, T> key, T value) {
    LoteRemessa lote = novoLote(key, value);
    String res = lote.write();

    assertCol(key, res);
  }

  private <T> LoteRemessa novoLote(CnabKey<BradescoLoteRemessa, T> key, T value) {
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