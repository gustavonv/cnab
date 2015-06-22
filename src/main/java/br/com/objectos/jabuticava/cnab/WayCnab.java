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

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import br.com.objectos.comuns.io.ParsedFixedLines;
import br.com.objectos.comuns.io.csv.FixedFile;

import com.google.common.collect.Iterables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class WayCnab implements Modelo {

  private static enum Singleton {

    INSTANCE;

    private final WayCnab instance;

    private Singleton() {
      CnabHeaderSpec headerSpec = new CnabHeaderSpec();
      CnabLoteSpec loteSpec = new CnabLoteSpec();
      this.instance = new WayCnab(headerSpec, loteSpec);
    }

    public WayCnab get() {
      return instance;
    }

  }

  public static final WayCnab banco = Singleton.INSTANCE.get();

  private final CnabHeaderSpec headerSpec;

  private final CnabLoteSpec loteSpec;

  private WayCnab(CnabHeaderSpec headerSpec, CnabLoteSpec loteSpec) {
    this.headerSpec = headerSpec;
    this.loteSpec = loteSpec;
  }

  public static Retorno retornoDe(InputStream inputStream) {
    FixedFile f = FixedFile.parse(inputStream);
    return retornoDe(f);
  }
  public static Retorno retornoDe(File file) {
    FixedFile f = FixedFile.parse(file);
    return retornoDe(f);
  }
  public static Retorno retornoDe(Reader reader) {
    FixedFile f = FixedFile.parseReader(reader);
    return retornoDe(f);
  }

  public static RemessaBuilder remessaPara(Banco banco) {
    return banco.newRemessaBuilder();
  }

  public static CnabHeader header() {
    return banco.headerSpec;
  }

  public static CnabLote lote() {
    return banco.loteSpec;
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
    throw new UnsupportedOperationException("IMPLEMENT ME!");
  }

  @Override
  public RemessaSpec getLoteRemessaSpec() {
    throw new UnsupportedOperationException("IMPLEMENT ME!");
  }

  @Override
  public RemessaSpec getTrailerRemessaSpec() {
    throw new UnsupportedOperationException("IMPLEMENT ME!");
  }

  private static Retorno retornoDe(FixedFile file) {
    ParsedFixedLines lines = new Parser(file).get();

    Header header = new HeaderParser(lines).get();
    Banco banco = header.getBanco();

    Iterable<Registro> registros;
    registros = Iterables.transform(lines, new ToRegistro(banco));

    return new RetornoPadrao(header, registros);
  }

}