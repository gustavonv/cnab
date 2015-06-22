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
package br.com.objectos.cnab.bradesco;

import static br.com.objectos.cnab.Bradesco.lote;
import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.List;

import br.com.objectos.cnab.CnabsFalso;
import br.com.objectos.cnab.Codigo;
import br.com.objectos.cnab.Lote;
import br.com.objectos.cnab.LoteToCnabKey;
import br.com.objectos.cnab.WayCnab;

import com.google.common.base.Function;

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeLoteBradesco {

  private List<Lote> lotes;

  @BeforeClass
  public void prepararRegistro() {
    File file = CnabsFalso.RETORNO_237_01.getFile();
    lotes = WayCnab.retornoDe(file).getLotes();

    assertThat(lotes.size(), equalTo(33));
  }

  public void tipo_de_inscricao_da_empresa() {
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

  public void identificacao_da_empresa() {
    List<String> res = transform(lotes, new LoteToIdenticacaoDaEmpresa());

    assertThat(res.get(0), equalTo("90059900015806"));
    assertThat(res.get(1), equalTo("90059900015806"));
    assertThat(res.get(2), equalTo("90059900015806"));
  }

  public void controle_do_participante() {
    List<String> res = transform(lotes, new LoteToControleDoParticipante());

    assertThat(res.get(0), equalTo("129873"));
    assertThat(res.get(1), equalTo("129877"));
    assertThat(res.get(2), equalTo("130903"));
  }

  public void titulo_do_banco() {
    List<String> res = transform(lotes, new LoteToNossoNumero());

    assertThat(res.get(0), equalTo("209600000224"));
    assertThat(res.get(1), equalTo("209600000232"));
    assertThat(res.get(2), equalTo("210000000016"));
  }

  public void indicador_de_rateio() {
    List<String> res = transform(lotes, new LoteToIndicadorDeRateio());

    assertThat(res.get(0), equalTo("0"));
    assertThat(res.get(1), equalTo("0"));
    assertThat(res.get(2), equalTo("0"));
  }

  public void carteira() {
    List<Integer> res = transform(lotes, new LoteToCarteira());

    assertThat(res.get(0), equalTo(9));
    assertThat(res.get(1), equalTo(9));
    assertThat(res.get(2), equalTo(9));
  }

  public void identificacao_da_ocorrencia() {
    List<Integer> res = transform(lotes, new LoteToIdentificacaoDeOcorrencia());

    assertThat(res.get(0), equalTo(6));
    assertThat(res.get(1), equalTo(6));
    assertThat(res.get(2), equalTo(6));
  }

  public void data_da_ocorrencia() {
    List<LocalDate> res = transform(lotes, new LoteToDataOcorrencia());

    assertThat(res.get(0), equalTo(new LocalDate(2012, 4, 30)));
    assertThat(res.get(1), equalTo(new LocalDate(2012, 4, 30)));
    assertThat(res.get(2), equalTo(new LocalDate(2012, 4, 30)));
  }

  public void numero_do_documento() {
    List<String> res = transform(lotes, new LoteToNumeroDoDocumento());

    assertThat(res.get(0), equalTo("002400C"));
    assertThat(res.get(1), equalTo("002434D"));
    assertThat(res.get(2), equalTo("002716B"));
  }

  public void nosso_numero_2() {
    List<String> list = transform(lotes, LoteToCnabKey.of(lote().nossoNumero2()));
    List<String> res = transform(list, new ToCodigo());

    assertThat(res.get(0), equalTo("209600000224"));
    assertThat(res.get(1), equalTo("209600000232"));
    assertThat(res.get(2), equalTo("210000000016"));
  }

  public void data_de_vencimento() {
    List<LocalDate> res = transform(lotes, new LoteToDataDeVecimento());

    assertThat(res.get(0), equalTo(new LocalDate(2012, 4, 25)));
    assertThat(res.get(1), equalTo(new LocalDate(2012, 4, 25)));
    assertThat(res.get(2), equalTo(new LocalDate(2012, 4, 30)));
  }

  public void valor_titulo() {
    List<Double> res = transform(lotes, new LoteToValorTitulo());

    assertThat(res.get(0), equalTo(3535.0));
    assertThat(res.get(1), equalTo(12664.0));
    assertThat(res.get(2), equalTo(560.0));
  }

  public void banco_cobrador() {
    List<Integer> res = transform(lotes, new LoteToBancoCobrador());

    assertThat(res.get(0), equalTo(341));
    assertThat(res.get(1), equalTo(341));
    assertThat(res.get(2), equalTo(104));
  }

  public void agencia_cobradora() {
    List<Integer> res = transform(lotes, new LoteToAgenciaCobradora());

    assertThat(res.get(0), equalTo(3765));
    assertThat(res.get(1), equalTo(3765));
    assertThat(res.get(2), equalTo(1486));
  }

  public void despesa_cobranca() {
    List<Double> res = transform(lotes, new LoteToDespesaDeCobranca());

    assertThat(res.get(0), equalTo(0d));
    assertThat(res.get(1), equalTo(0d));
    assertThat(res.get(2), equalTo(0d));
  }

  public void outras_despesas() {
    List<Double> res = transform(lotes, new LoteToOutrasDespesas());

    assertThat(res.get(0), equalTo(0d));
    assertThat(res.get(1), equalTo(0d));
    assertThat(res.get(2), equalTo(0d));
  }

  public void juros_operacao() {
    List<Double> res = transform(lotes, new LoteToJurosOperacaoAtraso());

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

  public void valor_pago() {
    List<Double> res = transform(lotes, new LoteToValorPago());

    assertThat(res.get(0), equalTo(3582.15));
    assertThat(res.get(1), equalTo(12832.85));
    assertThat(res.get(2), equalTo(560d));
  }

  public void valor_mora() {
    List<Double> res = transform(lotes, new LoteToValorMora());

    assertThat(res.get(0), equalTo(47.15));
    assertThat(res.get(1), equalTo(168.85));
    assertThat(res.get(2), equalTo(0d));
  }

  public void valor_outros() {
    List<Double> res = transform(lotes, new LoteToValorOutros());

    assertThat(res.get(0), equalTo(0d));
    assertThat(res.get(1), equalTo(0d));
    assertThat(res.get(2), equalTo(0d));
  }

  public void motivo_codigo_ocorrencia() {
    List<String> res = transform(lotes, new LoteToMotivoDoCodigoDeOcorrencia());

    assertThat(res.get(0), equalTo(null));
    assertThat(res.get(1), equalTo(null));
    assertThat(res.get(2), equalTo(null));
  }

  public void data_de_credito() {
    List<LocalDate> res = transform(lotes, new LoteToDataDoCredito());

    assertThat(res.get(0), equalTo(new LocalDate(2012, 5, 2)));
    assertThat(res.get(1), equalTo(new LocalDate(2012, 5, 2)));
    assertThat(res.get(2), equalTo(new LocalDate(2012, 5, 2)));
  }

  public void motivo_rejeicoes_codigo() {
    List<Long> res = transform(lotes, new LoteToMotivoDasRejeicoesDeCodigo());

    assertThat(res.get(0), equalTo(0l));
    assertThat(res.get(1), equalTo(0l));
    assertThat(res.get(2), equalTo(0l));
  }

  public void numero_sequencial_de_registro() {
    List<Integer> res = transform(lotes, new LoteToNumeroSequencialDoRegistro());

    assertThat(res.get(0), equalTo(2));
    assertThat(res.get(1), equalTo(3));
    assertThat(res.get(2), equalTo(4));
  }

  private static class ToCodigo implements Function<String, String> {
    @Override
    public String apply(String input) {
      return Codigo.valueOf(input).toString();
    }
  }

}