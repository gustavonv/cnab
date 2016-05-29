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
public abstract class HeaderRemessaItau implements FlatRecord {

  @Fixed("0")
  abstract String id();

  @Fixed("1")
  abstract String operacao();

  @Fixed("REMESSA")
  abstract String literalRemessa();

  @Fixed("01")
  abstract String codigoServico();

  @Fixed("COBRANCA       ")
  abstract String literalServico();

  @IntegerFormat(length = 4, options = IntegerOption.ZEROFILL)
  public abstract int agencia();

  @Fixed("00")
  abstract String zeros();

  @IntegerFormat(length = 5, options = IntegerOption.ZEROFILL)
  public abstract int conta();

  @IntegerFormat(length = 1)
  public abstract int contaDigito();

  @Fill(character = ' ', length = 8)
  abstract String brancos();

  @Text(length = 30)
  abstract String nomeEmpresa();

  @Fixed("341")
  abstract String codigoBanco();

  @Fixed("BANCO ITAU SA  ")
  abstract String nomeBanco();

  @LocalDateFormat(LocalDatePattern.DDMMYY)
  public abstract LocalDate dataGeracao();

  @Fill(character = ' ', length = 294)
  abstract String complementoRegistro();

  @Fixed("000001")
  abstract String seq();

  HeaderRemessaItau() {
  }

  public static HeaderRemessaItauBuilder builder() {
    return new HeaderRemessaItauBuilderPojo();
  }

}