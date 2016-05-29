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

import br.com.objectos.flat.BooleanFormat;
import br.com.objectos.flat.CustomFormat;
import br.com.objectos.flat.DecimalFormat;
import br.com.objectos.flat.DecimalOption;
import br.com.objectos.flat.Fill;
import br.com.objectos.flat.Fixed;
import br.com.objectos.flat.FlatEnumFormat;
import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.IntegerFormat;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.flat.LocalDateFormat;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.Text;
import br.com.objectos.flat.WhenZero;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TrxRetornoBradesco implements FlatRecord {

  @Fixed("1")
  abstract String id();

  @CustomFormat(length = 16, formatter = InscricaoEmpresaBradescoFormatter.class)
  public abstract InscricaoEmpresaBradesco inscricaoEmpresa();

  @Fixed("000")
  abstract String zeros();

  @Fixed("0")
  abstract String zero();

  @FlatEnumFormat(length = 3)
  public abstract CarteiraBradesco carteira();

  @IntegerFormat(length = 5, options = IntegerOption.ZEROFILL)
  public abstract int agencia();

  @IntegerFormat(length = 7, options = IntegerOption.ZEROFILL)
  public abstract int contaCorrente();

  @IntegerFormat(length = 1)
  public abstract int contaCorrenteDigito();

  @Text(length = 25)
  public abstract String usoEmpresa();

  @Fill(character = '0', length = 8)
  abstract String zero1();

  @Text(length = 12)
  public abstract String nossoNumero();

  @Fill(character = '0', length = 10)
  abstract String zero2();

  @Fill(character = '0', length = 12)
  abstract String zero3();

  @BooleanFormat(trueValue = "R", falseValue = "0")
  public abstract boolean rateioCredito();

  @Fill(character = '0', length = 2)
  abstract String zero4();

  @CustomFormat(length = 1, formatter = CarteiraBradescoCodigoFormatter.class)
  abstract CarteiraBradesco carteiraCodigo();

  @IntegerFormat(length = 2, options = { IntegerOption.ZEROFILL })
  public abstract int ocorrencia();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  public abstract LocalDate dataOcorrencia();

  @Text(length = 10)
  public abstract String numero();

  @Text(length = 20)
  public abstract String nossoNumero2();

  @CustomFormat(length = 6, formatter = LocalDateBradescoFormatter.class)
  public abstract Optional<LocalDate> vencimento();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorNominal();

  @IntegerFormat(length = 3, options = { IntegerOption.ZEROFILL })
  public abstract int bancoCobrador();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int agenciaCobradora();

  @Text(length = 2)
  abstract String especie();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorDespesa();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorDespesaOutras();

  @Fill(character = '0', length = 13)
  abstract String jurosOperacaoAtraso();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorIof();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorAbatimento();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorDesconto();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorRecebido();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorJuros();

  @Fill(character = '0', length = 13)
  abstract String valorOutrosCreditos();

  @Text(length = 2)
  abstract String brancos();

  @Text(length = 1)
  public abstract String motivoProtesto();

  @CustomFormat(length = 6, formatter = LocalDateBradescoFormatter.class)
  public abstract Optional<LocalDate> dataCredito();

  @Text(length = 3)
  public abstract String origemPagamento();

  @Fill(character = ' ', length = 10)
  abstract String brancos1();

  @Text(length = 4)
  public abstract String codigoBanco();

  @Text(length = 10)
  public abstract String motivo();

  @Fill(character = ' ', length = 40)
  abstract String brancos2();

  @IntegerFormat(length = 2, options = { IntegerOption.ZEROFILL })
  @WhenZero("  ")
  public abstract int numeroCartorio();

  @Text(length = 10)
  public abstract String numeroProtocolo();

  @Fill(character = ' ', length = 14)
  abstract String brancos3();

  @IntegerFormat(length = 6, options = { IntegerOption.ZEROFILL })
  public abstract int seq();

  TrxRetornoBradesco() {
  }

  public static TrxRetornoBradescoBuilder builder() {
    return new TrxRetornoBradescoBuilderPojo();
  }

}