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

import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.pojo.DecimalFormat;
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class RetornoBradescoTrailer implements FlatRecord {

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

  @IntegerFormat(length = 8)
  public abstract int quantidadeTotal();

  @DecimalFormat(scale = 14, precision = 2)
  public abstract double valorTotal();

  @IntegerFormat(length = 8)
  public abstract int numeroAvisoBancario();

  @Fill(character = ' ', length = 10)
  abstract String brancos1();

  @IntegerFormat(length = 5)
  public abstract int quantidadeEntradaConfirmada();

  @DecimalFormat(scale = 12, precision = 2)
  public abstract double valorEntradaConfirmada();

  @DecimalFormat(scale = 12, precision = 2)
  abstract double valorLiquidacao2();

  @IntegerFormat(length = 5)
  public abstract int quantidadeLiquidacao();

  @DecimalFormat(scale = 12, precision = 2)
  public abstract double valorLiquidacao();

  @IntegerFormat(length = 5)
  public abstract int quantidadeBaixa();

  @DecimalFormat(scale = 12, precision = 2)
  public abstract double valorBaixa();

  @IntegerFormat(length = 5)
  public abstract int quantidadeAbatimentoCancelado();

  @DecimalFormat(scale = 12, precision = 2)
  public abstract double valorAbatimentoCancelado();

  @IntegerFormat(length = 5)
  public abstract int quantidadeVencimentoAlterado();

  @DecimalFormat(scale = 12, precision = 2)
  public abstract double valorVencimentoAlterado();

  @IntegerFormat(length = 5)
  public abstract int quantidadeAbatimentoConcedido();

  @DecimalFormat(scale = 12, precision = 2)
  public abstract double valorAbatimentoConcedido();

  @IntegerFormat(length = 5)
  public abstract int quantidadeProtesto();

  @DecimalFormat(scale = 12, precision = 2)
  public abstract double valorProtesto();

  @Fill(character = ' ', length = 174)
  abstract String brancos2();

  @DecimalFormat(scale = 15, precision = 2)
  public abstract double valorRateio();

  @IntegerFormat(length = 8)
  public abstract int quantidadeRateio();

  @Fill(character = ' ', length = 9)
  abstract String brancos3();

  @IntegerFormat(length = 6)
  public abstract int seq();

  RetornoBradescoTrailer() {
  }

  public static RetornoBradescoTrailerBuilder builder() {
    return new RetornoBradescoTrailerBuilderPojo();
  }

}