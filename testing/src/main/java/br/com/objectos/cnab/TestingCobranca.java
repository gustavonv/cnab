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

import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.pojo.BooleanFormat;
import br.com.objectos.flat.pojo.CustomFormat;
import br.com.objectos.flat.pojo.DecimalFormat;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.FlatEnumFormat;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.flat.pojo.LocalDateFormat;
import br.com.objectos.flat.pojo.LongFormat;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.flat.pojo.WhenAbsent;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cep;
import br.com.objectos.jabuticava.Estado;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TestingCobranca implements FlatRecord {

  @Fixed("C")
  abstract String id();

  @FlatEnumFormat(length = 3)
  abstract Carteira carteira();

  @IntegerFormat(length = 10)
  abstract int agenciaNumero();

  @IntegerFormat(length = 1)
  abstract int agenciaDigito();

  @IntegerFormat(length = 10)
  abstract int contaNumero();

  @IntegerFormat(length = 1)
  abstract int contaDigito();

  @FlatEnumFormat(length = 2)
  abstract Comando comando();

  @Text(length = 25)
  abstract String usoDaEmpresa();

  @FlatEnumFormat(length = 2)
  abstract Especie especie();

  @LongFormat(length = 12)
  abstract long nossoNumero();

  @Text(length = 10)
  abstract String numero();

  @CustomFormat(length = 14, formatter = CadastroRfbFormatter.class)
  abstract CadastroRFB cedenteCadastroRfb();

  @Text(length = 40)
  abstract String cedenteNome();

  @CustomFormat(length = 14, formatter = CadastroRfbFormatter.class)
  abstract CadastroRFB sacadoCadastroRfb();

  @Text(length = 40)
  abstract String sacadoNome();

  @Text(length = 40)
  abstract String logradouro();

  @Text(length = 40)
  abstract String cidade();

  @Text(length = 40)
  abstract String bairro();

  @CustomFormat(length = 2, formatter = EstadorFormatter.class)
  abstract Estado estado();

  @CustomFormat(length = 8, formatter = CepFormatter.class)
  abstract Cep cep();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  @WhenAbsent("99999999")
  abstract Optional<LocalDate> emissao();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  abstract LocalDate vencimento();

  @IntegerFormat(length = 2)
  abstract int prazo();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double valor();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double valorDesconto();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double valorIof();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double valorAbatimento();

  @BooleanFormat(trueValue = "S", falseValue = "N")
  abstract boolean negociado();

  @BooleanFormat(trueValue = "S", falseValue = "N")
  abstract boolean aceite();

  @IntegerFormat(length = 2)
  abstract int instrucao1();

  @IntegerFormat(length = 2)
  abstract int instrucao1Valor();

  @IntegerFormat(length = 2)
  abstract int instrucao2();

  @IntegerFormat(length = 2)
  abstract int instrucao2Valor();

  @DecimalFormat(precision = 4, scale = 2)
  abstract double moraDia();

}