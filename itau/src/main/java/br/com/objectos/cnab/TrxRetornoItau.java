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

import br.com.objectos.flat.BooleanFormat;
import br.com.objectos.flat.CustomFormat;
import br.com.objectos.flat.DecimalFormat;
import br.com.objectos.flat.DecimalOption;
import br.com.objectos.flat.Fill;
import br.com.objectos.flat.Fixed;
import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.IntegerFormat;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.flat.LocalDateFormat;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.Text;
import br.com.objectos.flat.TextOption;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TrxRetornoItau implements FlatRecord {

  @Fixed("1")
  abstract String id();

  @CustomFormat(length = 16, formatter = CadastroRfbItauFormatter.class)
  public abstract CadastroRFB cadastroRfb();

  @CustomFormat(length = 4, formatter = AgenciaCoreFormatter.class)
  public abstract Agencia agencia();

  @Fixed("00")
  abstract String zeros();

  @CustomFormat(length = 6, formatter = ContaCoreFormatter.class)
  public abstract Conta conta();

  @Fill(character = ' ', length = 8)
  abstract String brancos();

  @Text(length = 25)
  public abstract String usoEmpresa();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int nossoNumero();

  @Fill(character = ' ', length = 12)
  abstract String brancos1();

  @CustomFormat(length = 3, formatter = CarteiraItauNumeroFormatter.class)
  public abstract CarteiraItau carteiraNumero();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int nossoNumero2();

  @IntegerFormat(length = 1)
  public abstract int nossoNumeroDigito();

  @Fill(character = ' ', length = 13)
  abstract String brancos2();

  @CustomFormat(length = 1, formatter = CarteiraItauCodigoFormatter.class)
  public abstract CarteiraItau carteiraCodigo();

  @IntegerFormat(length = 2, options = { IntegerOption.ZEROFILL })
  public abstract int ocorrencia();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  public abstract LocalDate dataOcorrencia();

  @Text(length = 10)
  public abstract String numero();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int nossoNumero3();

  @Fill(character = ' ', length = 12)
  abstract String brancos3();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  public abstract LocalDate vencimento();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorNominal();

  @IntegerFormat(length = 3, options = { IntegerOption.ZEROFILL })
  public abstract int bancoCobrador();

  @CustomFormat(length = 5, formatter = AgenciaCoreFormatter.class)
  public abstract Agencia agenciaCobradora();

  @Text(length = 2)
  abstract String especie();

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorDespesa();

  @Fill(character = ' ', length = 26)
  abstract String brancos4();

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

  @DecimalFormat(precision = 13, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorOutrosCreditos();

  @BooleanFormat(trueValue = "1", falseValue = "0")
  public abstract boolean dda();

  @Fill(character = ' ', length = 2)
  abstract String brancos5();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  public abstract LocalDate dataCredito();

  @Text(length = 4)
  public abstract String motivo();

  @Fill(character = ' ', length = 6)
  abstract String brancos6();

  @Fill(character = '0', length = 13)
  abstract String zeros1();

  @Text(length = 30, options = { TextOption.STRIP_ACCENTS })
  public abstract String sacadoNome();

  @Fill(character = ' ', length = 23)
  abstract String brancos7();

  @Text(length = 8)
  public abstract String erros();

  @Fill(character = ' ', length = 7)
  abstract String brancos8();

  @IntegerFormat(length = 2, options = { IntegerOption.ZEROFILL })
  public abstract int codigoLiquidacao();

  @IntegerFormat(length = 6, options = { IntegerOption.ZEROFILL })
  public abstract int seq();

  TrxRetornoItau() {
  }

  public static TrxRetornoItauBuilder builder() {
    return new TrxRetornoItauBuilderPojo();
  }

}