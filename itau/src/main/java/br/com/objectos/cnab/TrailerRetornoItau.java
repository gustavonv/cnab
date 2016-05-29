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

import br.com.objectos.flat.CustomFormat;
import br.com.objectos.flat.DecimalFormat;
import br.com.objectos.flat.DecimalOption;
import br.com.objectos.flat.Fill;
import br.com.objectos.flat.Fixed;
import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.IntegerFormat;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TrailerRetornoItau implements FlatRecord {

  @Fixed("9")
  abstract String id();

  @Fixed("2")
  abstract String idRetorno();

  @Fixed("01")
  abstract String idTipoRegistro();

  @Fixed("341")
  abstract String codigoBanco();

  @Fill(character = ' ', length = 10)
  abstract String brancos();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeCobrancaSimples();

  @DecimalFormat(precision = 14, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorCobrancaSimples();

  @CustomFormat(length = 8, formatter = ReferenciaItauFormatter.class)
  public abstract String referenciaCobrancaSimples();

  @Fill(character = ' ', length = 10)
  abstract String brancos1();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeCobrancaVinculada();

  @DecimalFormat(precision = 14, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorCobrancaVinculada();

  @CustomFormat(length = 8, formatter = ReferenciaItauFormatter.class)
  public abstract String referenciaCobrancaVinculada();

  @Fill(character = ' ', length = 50)
  abstract String brancos2();

  @Fill(character = '0', length = 30)
  abstract String zeros();

  @Fill(character = ' ', length = 10)
  abstract String brancos3();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeCobranca();

  @DecimalFormat(precision = 14, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorCobranca();

  @CustomFormat(length = 8, formatter = ReferenciaItauFormatter.class)
  public abstract String referenciaCobranca();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int numeroSeqArquivoRetorno();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeTotal();

  @DecimalFormat(precision = 14, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorTotal();

  @Fill(character = ' ', length = 160)
  abstract String brancos4();

  @IntegerFormat(length = 6, options = { IntegerOption.ZEROFILL })
  public abstract int seq();

  TrailerRetornoItau() {
  }

  public static TrailerRetornoItauBuilder builder() {
    return new TrailerRetornoItauBuilderPojo();
  }

}