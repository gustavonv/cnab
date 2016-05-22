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
package br.com.objectos.cnab.itau;

import java.time.LocalDate;
import java.util.Optional;

import br.com.objectos.cnab.CadastroRfbFormatter;
import br.com.objectos.cnab.CarteiraItau;
import br.com.objectos.cnab.CepFormatter;
import br.com.objectos.cnab.Especie;
import br.com.objectos.cnab.EstadoFormatter;
import br.com.objectos.cnab.OcorrenciaItau;
import br.com.objectos.cnab.TipoInscricaoItau;
import br.com.objectos.flat.DecimalOption;
import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.LongOption;
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
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cep;
import br.com.objectos.jabuticava.Estado;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class RemessaItauTrx implements FlatRecord {

  @Fixed("1")
  abstract String id();

  @FlatEnumFormat(length = 1)
  public abstract TipoInscricaoItau tipoInscricaoEmpresa();

  @CustomFormat(length = 14, formatter = CadastroRfbFormatter.class)
  public abstract CadastroRFB numeroInscricaoEmpresa();

  @IntegerFormat(length = 4, options = { IntegerOption.ZEROFILL })
  public abstract int agencia();

  @Fixed("00")
  abstract String zeros();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int conta();

  @IntegerFormat(length = 1)
  public abstract int contaDigito();

  @Fill(character = ' ', length = 4)
  abstract String brancos();

  @IntegerFormat(length = 4, options = { IntegerOption.ZEROFILL })
  public abstract int instrucaoCancelada();

  @Text(length = 25)
  public abstract String usoEmpresa();

  @LongFormat(length = 8, options = { LongOption.ZEROFILL })
  public abstract long nossoNumero();

  @DecimalFormat(precision = 8, scale = 5, options = { DecimalOption.ZEROFILL })
  public abstract double quantidadeMoeda();

  @CustomFormat(length = 3, formatter = CarteiraItauNumeroFormatter.class)
  public abstract CarteiraItau carteiraNumero();

  @Text(length = 21)
  public abstract String usoBanco();

  @CustomFormat(length = 1, formatter = CarteiraItauCodigoFormatter.class)
  public abstract CarteiraItau carteiraCodigo();

  @FlatEnumFormat(length = 2)
  public abstract OcorrenciaItau ocorrencia();

  @Text(length = 10)
  public abstract String numero();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  public abstract LocalDate vencimento();

  @DecimalFormat(precision = 11, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valor();

  @Fixed("341")
  abstract String codigoBanco();

  @Fixed("00000")
  abstract String agenciaCobradora();

  @FlatEnumFormat(length = 2)
  public abstract Especie especie();

  @BooleanFormat(trueValue = "A", falseValue = "N")
  public abstract boolean aceite();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  @WhenAbsent("      ")
  public abstract Optional<LocalDate> emissao();

  @IntegerFormat(length = 2, options = { IntegerOption.ZEROFILL })
  public abstract int instrucao1();

  @IntegerFormat(length = 2, options = { IntegerOption.ZEROFILL })
  public abstract int instrucao2();

  @DecimalFormat(precision = 11, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double moraDia();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  @WhenAbsent("      ")
  public abstract Optional<LocalDate> descontoAte();

  @DecimalFormat(precision = 11, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorDesconto();

  @DecimalFormat(precision = 11, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorIof();

  @DecimalFormat(precision = 11, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorAbatimento();

  @CustomFormat(length = 15, formatter = InscricaoSacadoFormatter.class)
  public abstract CadastroRFB sacadoInscricao();

  @Text(length = 30)
  public abstract String sacadoNome();

  @Fill(character = ' ', length = 10)
  abstract String brancos2();

  @Text(length = 40)
  public abstract String sacadoLogradouro();

  @Text(length = 12)
  public abstract String sacadoBairro();

  @CustomFormat(length = 8, formatter = CepFormatter.class)
  public abstract Cep sacadoCep();

  @Text(length = 15)
  public abstract String sacadoCidade();

  @CustomFormat(length = 2, formatter = EstadoFormatter.class)
  public abstract Estado sacadoEstado();

  @Text(length = 30)
  public abstract String sacadorAvalista();

  @Fill(character = ' ', length = 4)
  abstract String brancos3();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  @WhenAbsent("      ")
  public abstract Optional<LocalDate> dataMora();

  @IntegerFormat(length = 2, options = { IntegerOption.ZEROFILL })
  public abstract int prazo();

  @Fixed(" ")
  abstract String brancos4();

  @IntegerFormat(length = 6, options = { IntegerOption.ZEROFILL })
  public abstract int seq();

  RemessaItauTrx() {
  }

  public static RemessaItauTrxBuilder builder() {
    return new RemessaItauTrxBuilderPojo();
  }

}