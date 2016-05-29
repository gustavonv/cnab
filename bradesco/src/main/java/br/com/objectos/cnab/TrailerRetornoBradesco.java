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
public abstract class TrailerRetornoBradesco implements FlatRecord {

  @Fixed("9")
  abstract String id();

  @Fixed("2")
  abstract String idRetorno();

  @Fixed("01")
  abstract String idTipoRegistro();

  @Fixed("237")
  abstract String codigoBanco();

  @Fill(character = ' ', length = 10)
  abstract String brancos();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeTotal();

  @DecimalFormat(precision = 14, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorTotal();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int numeroAvisoBancario();

  @Fill(character = ' ', length = 10)
  abstract String brancos1();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeEntradaConfirmada();

  @DecimalFormat(precision = 12, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorEntradaConfirmada();

  @DecimalFormat(precision = 12, scale = 2, options = { DecimalOption.ZEROFILL })
  abstract double valorLiquidacao2();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeLiquidacao();

  @DecimalFormat(precision = 12, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorLiquidacao();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeBaixa();

  @DecimalFormat(precision = 12, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorBaixa();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeAbatimentoCancelado();

  @DecimalFormat(precision = 12, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorAbatimentoCancelado();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeVencimentoAlterado();

  @DecimalFormat(precision = 12, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorVencimentoAlterado();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeAbatimentoConcedido();

  @DecimalFormat(precision = 12, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorAbatimentoConcedido();

  @IntegerFormat(length = 5, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeProtesto();

  @DecimalFormat(precision = 12, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorProtesto();

  @Fill(character = ' ', length = 174)
  abstract String brancos2();

  @DecimalFormat(precision = 15, scale = 2, options = { DecimalOption.ZEROFILL })
  public abstract double valorRateio();

  @IntegerFormat(length = 8, options = { IntegerOption.ZEROFILL })
  public abstract int quantidadeRateio();

  @Fill(character = ' ', length = 9)
  abstract String brancos3();

  @IntegerFormat(length = 6, options = { IntegerOption.ZEROFILL })
  public abstract int seq();

  TrailerRetornoBradesco() {
  }

  public static TrailerRetornoBradescoBuilder builder() {
    return new TrailerRetornoBradescoBuilderPojo();
  }

}