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

import br.com.objectos.flat.Fill;
import br.com.objectos.flat.Fixed;
import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.IntegerFormat;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.flat.LocalDateFormat;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.Text;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class HeaderRetornoItau implements FlatRecord {

  @Fixed("0")
  abstract String id();

  @Fixed("2")
  abstract String idRetorno();

  @Fixed("RETORNO")
  abstract String literalRetorno();

  @Fixed("01")
  abstract String codigoServico();

  @Fixed("COBRANCA       ")
  abstract String literalServico();

  @IntegerFormat(length = 4, options = { IntegerOption.ZEROFILL })
  public abstract int agencia();

  @Fill(character = '0', length = 2)
  abstract String zeros();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int conta();

  @IntegerFormat(length = 1)
  public abstract int contaDigito();

  @Fill(character = ' ', length = 8)
  abstract String brancos();

  @Text(length = 30)
  public abstract String razaoSocial();

  @Fixed("341")
  abstract String codigoItau();

  @Fixed("BANCO ITAU S.A.")
  abstract String nomeItau();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  public abstract LocalDate dataArquivo();

  @Fixed("01600")
  abstract String densidadeGravacao();

  @Fixed("BPI")
  abstract String densidadeUnidade();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int numeroAvisoBancario();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  public abstract LocalDate dataCredito();

  @Fill(character = ' ', length = 275)
  abstract String brancos1();

  @Fixed("000001")
  abstract String seq();

  HeaderRetornoItau() {
  }

  public static HeaderRetornoItauBuilder builder() {
    return new HeaderRetornoItauBuilderPojo();
  }

}