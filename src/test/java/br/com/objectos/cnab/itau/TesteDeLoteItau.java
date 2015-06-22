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
package br.com.objectos.cnab.itau;

import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.List;

import br.com.objectos.cnab.CnabsFalso;
import br.com.objectos.cnab.Lote;
import br.com.objectos.cnab.WayCnab;

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeLoteItau {

  private List<Lote> lotes;

  @BeforeClass
  public void prepararRegistro() {
    File file = CnabsFalso.RETORNO_341_01.getFile();

    lotes = WayCnab.retornoDe(file).getLotes();
  }

  public void codigo_de_inscricao() {
    List<Integer> res = transform(lotes, new LoteToInscricaoDaEmpresa());

    assertThat(res.get(0), equalTo(2));
    assertThat(res.get(1), equalTo(2));
    assertThat(res.get(2), equalTo(2));
  }

  public void numero_de_inscricao_da_empresa() {
    List<Long> res = transform(lotes, new LoteToNumeroDeInscricaoDaEmpresa());

    assertThat(res.get(0), equalTo(7430629000110l));
    assertThat(res.get(1), equalTo(7430629000110l));
    assertThat(res.get(2), equalTo(7430629000110l));
  }

  public void agencia() {
    List<Integer> res = transform(lotes, new LoteToAgencia());

    assertThat(res.get(0), equalTo(123));
    assertThat(res.get(1), equalTo(123));
    assertThat(res.get(2), equalTo(123));
  }

  public void conta() {
    List<Integer> res = transform(lotes, new LoteToConta());

    assertThat(res.get(0), equalTo(12345));
    assertThat(res.get(1), equalTo(12345));
    assertThat(res.get(2), equalTo(12345));
  }

  public void dac() {
    List<Integer> res = transform(lotes, new LoteToDac());

    assertThat(res.get(0), equalTo(2));
    assertThat(res.get(1), equalTo(2));
    assertThat(res.get(2), equalTo(2));
  }

  public void uso_da_empresa() {
    List<String> res = transform(lotes, new LoteToUsoDaEmpresa());

    assertThat(res.get(0), equalTo("131945"));
    assertThat(res.get(1), equalTo("133151"));
    assertThat(res.get(2), equalTo("133346"));
  }

  public void nosso_numero() {
    List<String> res = transform(lotes, new LoteToNossoNumero());

    assertThat(res.get(0), equalTo("19389202"));
    assertThat(res.get(1), equalTo("16010377"));
    assertThat(res.get(2), equalTo("18402044"));
  }

  public void carteira() {
    List<Integer> res = transform(lotes, new LoteToNumeroDaCarteira());

    assertThat(res.get(0), equalTo(112));
    assertThat(res.get(1), equalTo(112));
    assertThat(res.get(2), equalTo(112));
  }

  public void nosso_numero2() {
    List<String> res = transform(lotes, new LoteToNossoNumero2());

    assertThat(res.get(0), equalTo("19389202"));
    assertThat(res.get(1), equalTo("16010377"));
    assertThat(res.get(2), equalTo("18402044"));
  }

  public void dac_nosso_numero_2() {
    List<Integer> res = transform(lotes, new LoteToDacNossoNumero2());

    assertThat(res.get(0), equalTo(6));
    assertThat(res.get(1), equalTo(9));
    assertThat(res.get(2), equalTo(7));
  }

  public void codigo_da_carteira() {
    List<String> res = transform(lotes, new LoteToCodigoDaCarteira());

    assertThat(res.get(0), equalTo("I"));
    assertThat(res.get(1), equalTo("I"));
    assertThat(res.get(2), equalTo("I"));
  }

  public void identificacao_da_ocorrencia() {
    List<Integer> res = transform(lotes, new LoteToIdentificacaoDeOcorrencia());

    assertThat(res.get(0), equalTo(14));
    assertThat(res.get(1), equalTo(6));
    assertThat(res.get(2), equalTo(6));
  }

  public void data_da_ocorrencia() {
    List<LocalDate> res = transform(lotes, new LoteToDataOcorrencia());

    assertThat(res.get(0), equalTo(new LocalDate(2012, 8, 1)));
    assertThat(res.get(1), equalTo(new LocalDate(2012, 8, 1)));
    assertThat(res.get(2), equalTo(new LocalDate(2012, 8, 1)));
  }

  public void numero_do_documento() {
    List<String> res = transform(lotes, new LoteToNumeroDoDocumento());

    assertThat(res.get(0), equalTo("002953C"));
    assertThat(res.get(1), equalTo("0483 C"));
    assertThat(res.get(2), equalTo("1128 A"));
  }

  public void nosso_numero_3() {
    List<Integer> res = transform(lotes, new LoteToNossoNumero3());

    assertThat(res.get(0), equalTo(19389202));
    assertThat(res.get(1), equalTo(16010377));
    assertThat(res.get(2), equalTo(18402044));
  }

  public void data_de_vencimento() {
    List<LocalDate> res = transform(lotes, new LoteToDataDeVecimento());

    assertThat(res.get(0), equalTo(new LocalDate(2012, 8, 30)));
    assertThat(res.get(1), equalTo(new LocalDate(2012, 8, 1)));
    assertThat(res.get(2), equalTo(new LocalDate(2012, 8, 14)));
  }

  public void valor_titulo() {
    List<Double> res = transform(lotes, new LoteToValorTitulo());

    assertThat(res.get(0), equalTo(1320.00));
    assertThat(res.get(1), equalTo(1234.82));
    assertThat(res.get(2), equalTo(669.67));
  }

  public void banco_cobrador() {
    List<Integer> res = transform(lotes, new LoteToBancoCobrador());

    assertThat(res.get(0), equalTo(341));
    assertThat(res.get(1), equalTo(341));
    assertThat(res.get(2), equalTo(341));
  }

  public void agencia_cobradora() {
    List<Integer> res = transform(lotes, new LoteToAgenciaCobradora());

    assertThat(res.get(0), equalTo(174));
    assertThat(res.get(1), equalTo(80580));
    assertThat(res.get(2), equalTo(16493));
  }

  public void dac_agencia_cobradora() {
    List<Integer> res = transform(lotes, new LoteToDacAgenciaCobradora());

    assertThat(res.get(0), equalTo(4));
    assertThat(res.get(1), equalTo(0));
    assertThat(res.get(2), equalTo(3));
  }

  public void especie() {
    List<Integer> res = transform(lotes, new LoteToEspecie());

    assertThat(res.get(0), equalTo(1));
    assertThat(res.get(1), equalTo(1));
    assertThat(res.get(2), equalTo(1));
  }

  public void despesa_cobranca() {
    List<Double> res = transform(lotes, new LoteToDespesaDeCobranca());

    assertThat(res.get(0), equalTo(0d));
    assertThat(res.get(1), equalTo(0d));
    assertThat(res.get(2), equalTo(0d));
  }

  public void valor_IOF() {
    List<Double> res = transform(lotes, new LoteToValorIOF());

    assertThat(res.get(0), equalTo(0d));
    assertThat(res.get(1), equalTo(0d));
    assertThat(res.get(2), equalTo(0d));
  }

  public void valor_abatimento() {
    List<Double> res = transform(lotes, new LoteToValorAbatimento());

    assertThat(res.get(0), equalTo(0d));
    assertThat(res.get(1), equalTo(0d));
    assertThat(res.get(2), equalTo(0d));
  }

  public void valor_desconto() {
    List<Double> res = transform(lotes, new LoteToValorDesconto());

    assertThat(res.get(0), equalTo(0d));
    assertThat(res.get(1), equalTo(0d));
    assertThat(res.get(2), equalTo(0d));
  }

  public void valor_outros() {
    List<Double> res = transform(lotes, new LoteToValorOutros());

    assertThat(res.get(0), equalTo(0d));
    assertThat(res.get(1), equalTo(0d));
    assertThat(res.get(2), equalTo(0d));
  }

  public void data_de_credito() {
    List<LocalDate> res = transform(lotes, new LoteToDataDoCredito());

    assertThat(res.get(0), equalTo(null));
    assertThat(res.get(1), equalTo(new LocalDate(2012, 8, 2)));
    assertThat(res.get(2), equalTo(new LocalDate(2012, 8, 2)));
  }

  public void instrucao_cancelada() {
    List<Integer> res = transform(lotes, new LoteToInstrucaoCancelada());

    assertThat(res.get(0), equalTo(0));
    assertThat(res.get(1), equalTo(0));
    assertThat(res.get(2), equalTo(0));
  }

  public void nome_do_sacado() {
    List<String> res = transform(lotes, new LoteToNomeDoSacado());

    assertThat(res.get(0), equalTo("SACADO_A"));
    assertThat(res.get(1), equalTo("SACADO_B"));
    assertThat(res.get(2), equalTo(null));
  }

  public void erros() {
    List<String> res = transform(lotes, new LoteToErros());

    assertThat(res.get(0), equalTo(null));
    assertThat(res.get(1), equalTo(null));
    assertThat(res.get(2), equalTo(null));
  }

  public void codigo_de_liquidacao() {
    List<String> res = transform(lotes, new LoteToCodigoLiquidacao());

    assertThat(res.get(0), equalTo(null));
    assertThat(res.get(1), equalTo("BL"));
    assertThat(res.get(2), equalTo("BL"));
  }

  public void numero_sequencial() {
    List<Integer> res = transform(lotes, new LoteToNumeroSequencialDoRegistro());

    assertThat(res.get(0), equalTo(2));
    assertThat(res.get(1), equalTo(3));
    assertThat(res.get(2), equalTo(4));
  }

}