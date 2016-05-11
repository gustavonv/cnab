/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public final class Bradesco implements Modelo {

  private static enum Singleton {

    INSTANCE;

    private final Bradesco instance;

    private Singleton() {
      BradescoHeaderSpec headerSpec = new BradescoHeaderSpec();
      BradescoLoteSpec loteSpec = new BradescoLoteSpec();

      BradescoHeaderRemessaSpec headerRemessaSpec = new BradescoHeaderRemessaSpec();
      BradescoLoteRemessaSpec loteRemessaSpec = new BradescoLoteRemessaSpec();
      BradescoTrailerRemessaSpec trailerRemessaSpec = new BradescoTrailerRemessaSpec();

      this.instance = new Bradesco(
          headerSpec,
          loteSpec,

          headerRemessaSpec,
          loteRemessaSpec,
          trailerRemessaSpec);
    }

    public Bradesco get() {
      return instance;
    }

  }

  public static final Bradesco banco = Singleton.INSTANCE.get();

  static final OcorrenciaParser ocorrenciaParser = new BradescoOcorrenciaParser();

  private final BradescoHeaderSpec headerSpec;

  private final BradescoLoteSpec loteSpec;

  private final BradescoHeaderRemessaSpec headerRemessaSpec;

  private final BradescoLoteRemessaSpec loteRemessaSpec;

  private final BradescoTrailerRemessaSpec trailerRemessaSpec;

  public Bradesco(BradescoHeaderSpec headerSpec,
                  BradescoLoteSpec loteSpec,
                  BradescoHeaderRemessaSpec headerRemessaSpec,
                  BradescoLoteRemessaSpec loteRemessaSpec,
                  BradescoTrailerRemessaSpec trailerRemessaSpec) {
    this.headerSpec = headerSpec;
    this.loteSpec = loteSpec;
    this.headerRemessaSpec = headerRemessaSpec;
    this.loteRemessaSpec = loteRemessaSpec;
    this.trailerRemessaSpec = trailerRemessaSpec;
  }

  public static BradescoHeader header() {
    return banco.headerSpec;
  }
  public static BradescoLote lote() {
    return banco.loteSpec;
  }
  public static BradescoHeaderRemessa headerRemessa() {
    return banco.headerRemessaSpec;
  }
  public static BradescoLoteRemessa loteRemessa() {
    return banco.loteRemessaSpec;
  }
  public static BradescoTrailerRemessa trailerRemessa() {
    return banco.trailerRemessaSpec;
  }

  @Override
  public Spec getHeaderSpec() {
    return headerSpec;
  }

  @Override
  public Spec getLoteSpec() {
    return loteSpec;
  }

  @Override
  public RemessaSpec getHeaderRemessaSpec() {
    return headerRemessaSpec;
  }

  @Override
  public BradescoLoteRemessaSpec getLoteRemessaSpec() {
    return loteRemessaSpec;
  }

  @Override
  public RemessaSpec getTrailerRemessaSpec() {
    return trailerRemessaSpec;
  }

}