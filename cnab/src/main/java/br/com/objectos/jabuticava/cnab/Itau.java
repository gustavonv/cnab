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
package br.com.objectos.jabuticava.cnab;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Itau implements Modelo {

  private static enum Singleton {

    INSTANCE;

    private final Itau instance;

    private Singleton() {
      ItauHeaderSpec headerSpec = new ItauHeaderSpec();
      ItauLoteSpec loteSpec = new ItauLoteSpec();

      ItauHeaderRemessaSpec headerRemessaSpec = new ItauHeaderRemessaSpec();
      ItauLoteRemessaSpec loteRemessaSpec = new ItauLoteRemessaSpec();
      ItauTrailerRemessaSpec trailerRemessaSpec = new ItauTrailerRemessaSpec();
      this.instance = new Itau(
          headerSpec,
          loteSpec,

          headerRemessaSpec,
          loteRemessaSpec,
          trailerRemessaSpec);
    }

    public Itau get() {
      return instance;
    }

  }

  public static final Itau banco = Singleton.INSTANCE.get();

  public static final OcorrenciaParser ocorrenciaParser = new ItauOcorrenciaParser();

  private final ItauHeaderSpec headerSpec;

  private final ItauLoteSpec loteSpec;

  private final ItauHeaderRemessaSpec headerRemessaSpec;

  private final ItauLoteRemessaSpec loteRemessaSpec;

  private final ItauTrailerRemessaSpec trailerRemessaSpec;

  private Itau(ItauHeaderSpec headerSpec,
               ItauLoteSpec loteSpec,
               ItauHeaderRemessaSpec headerRemessaSpec,
               ItauLoteRemessaSpec loteRemessaSpec,
               ItauTrailerRemessaSpec trailerRemessaSpec) {
    this.headerSpec = headerSpec;
    this.loteSpec = loteSpec;
    this.headerRemessaSpec = headerRemessaSpec;
    this.loteRemessaSpec = loteRemessaSpec;
    this.trailerRemessaSpec = trailerRemessaSpec;
  }

  public static ItauHeader header() {
    return banco.headerSpec;
  }
  public static ItauLote lote() {
    return banco.loteSpec;
  }
  public static ItauHeaderRemessa headerRemessa() {
    return banco.headerRemessaSpec;
  }
  public static ItauLoteRemessa loteRemessa() {
    return banco.loteRemessaSpec;
  }
  public static ItauTrailerRemessa trailerRemessa() {
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
  public RemessaSpec getLoteRemessaSpec() {
    return loteRemessaSpec;
  }

  @Override
  public RemessaSpec getTrailerRemessaSpec() {
    return trailerRemessaSpec;
  }

}