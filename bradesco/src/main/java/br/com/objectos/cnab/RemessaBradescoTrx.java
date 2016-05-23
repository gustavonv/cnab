/*
 * Copyright 2016 Objectos, Fábrica de Software LTDA.
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

import java.time.LocalDate;
import java.util.Optional;

import br.com.objectos.flat.DecimalOption;
import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.LongOption;
import br.com.objectos.flat.TextOption;
import br.com.objectos.flat.pojo.BooleanFormat;
import br.com.objectos.flat.pojo.CustomFormat;
import br.com.objectos.flat.pojo.DecimalFormat;
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.FlatEnumFormat;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.flat.pojo.LocalDateFormat;
import br.com.objectos.flat.pojo.LongFormat;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.flat.pojo.WhenAbsent;
import br.com.objectos.flat.pojo.WhenZero;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cep;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class RemessaBradescoTrx implements FlatRecord {

  @Fixed("1")
  abstract String id();

  @IntegerFormat(length = 5)
  @WhenZero("     ")
  abstract int agenciaCredito();

  @IntegerFormat(length = 0)
  @WhenZero(" ")
  abstract int agenciaCreditoDigito();

  @IntegerFormat(length = 5)
  @WhenZero("     ")
  abstract int razaoContaCorrente();

  @IntegerFormat(length = 7)
  @WhenZero("       ")
  abstract int contaCorrenteCredito();

  @IntegerFormat(length = 1)
  @WhenZero(" ")
  abstract int contaCorrenteCreditoDigito();

  @Fixed("0")
  abstract String zero();

  @FlatEnumFormat(length = 3)
  abstract CarteiraBradesco carteira();

  @IntegerFormat(length = 5, options = IntegerOption.ZEROFILL)
  abstract int agencia();

  @IntegerFormat(length = 7, options = IntegerOption.ZEROFILL)
  abstract int contaCorrente();

  @IntegerFormat(length = 1)
  abstract int contaCorrenteDigito();

  @Text(length = 25)
  abstract String usoDaEmpresa();

  @Fixed("000")
  abstract String codigoDoBanco();

  @BooleanFormat(trueValue = "2", falseValue = "0")
  abstract boolean multa();

  @DecimalFormat(precision = 4, scale = 2, options = DecimalOption.ZEROFILL)
  abstract double percentualMulta();

  @LongFormat(length = 12, options = LongOption.ZEROFILL)
  abstract long nossoNumero();

  @DecimalFormat(precision = 10, scale = 2)
  @WhenZero("          ")
  abstract double descontoBonificacaoPorDia();

  @IntegerFormat(length = 1)
  abstract int condicaoParaEmissaoDeCobranca();

  @BooleanFormat(trueValue = " ", falseValue = "N")
  abstract boolean debitoAutomatico();

  @Fill(character = ' ', length = 10)
  abstract String idDaOperacaoNoBanco();

  @BooleanFormat(trueValue = "R", falseValue = " ")
  abstract boolean rateiroCredito();

  @FlatEnumFormat(length = 1)
  abstract EnderecamentoDebitoAutomatico enderecamentoParaAvisoDeDebito();

  @Fill(character = ' ', length = 2)
  abstract String brancos();

  @FlatEnumFormat(length = 2)
  abstract Comando ocorrencia();

  @Text(length = 10)
  abstract String numero();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  abstract LocalDate vencimento();

  @DecimalFormat(precision = 13, scale = 2, options = DecimalOption.ZEROFILL)
  abstract double valor();

  @Fixed("000")
  abstract String bancoEncarregadoDaCobranca();

  @Fixed("00000")
  abstract String agenciaDepositaria();

  @FlatEnumFormat(length = 2)
  abstract Especie especie();

  @BooleanFormat(trueValue = "A", falseValue = "N")
  abstract boolean aceite();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  @WhenAbsent("      ")
  abstract Optional<LocalDate> emissao();

  @IntegerFormat(length = 2, options = IntegerOption.ZEROFILL)
  abstract int primeiraInstrucao();

  @IntegerFormat(length = 2, options = IntegerOption.ZEROFILL)
  abstract int segundaInstrucao();

  @DecimalFormat(precision = 13, scale = 2, options = DecimalOption.ZEROFILL)
  abstract double moraDia();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  @WhenAbsent("000000")
  abstract Optional<LocalDate> limiteParaConcessaoDeDesconto();

  @DecimalFormat(precision = 13, scale = 2, options = DecimalOption.ZEROFILL)
  abstract double valorDesconto();

  @DecimalFormat(precision = 13, scale = 2, options = DecimalOption.ZEROFILL)
  abstract double valorIof();

  @DecimalFormat(precision = 13, scale = 2, options = DecimalOption.ZEROFILL)
  abstract double valorAbatimento();

  @FlatEnumFormat(length = 2)
  abstract TipoSacadoBradesco tipoDeInscricaoDoSacado();

  @CustomFormat(length = 14, formatter = CadastroRfbFormatter.class)
  abstract CadastroRFB numeroDeInscricaoDoSacado();

  @Text(length = 40, options = { TextOption.UPPERCASE, TextOption.STRIP_ACCENTS })
  abstract String nomeDoSacado();

  @Text(length = 40, options = { TextOption.STRIP_ACCENTS })
  abstract String enderecoDoSacado();

  @Text(length = 12)
  abstract String primeiraMensagem();

  @CustomFormat(length = 8, formatter = CepFormatter.class)
  abstract Cep cep();

  @CustomFormat(length = 60, formatter = SacadorAvalistaBradescoFormatter.class)
  abstract SacadorAvalistaBradesco sacadorAvalista();

  @IntegerFormat(length = 6, options = IntegerOption.ZEROFILL)
  abstract int numeroSequencialDoRegistro();

  RemessaBradescoTrx() {
  }

  public static RemessaBradescoTrxBuilder builder() {
    return new RemessaBradescoTrxBuilderPojo();
  }

}