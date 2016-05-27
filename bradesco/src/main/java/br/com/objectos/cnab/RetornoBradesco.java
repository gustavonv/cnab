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

import java.util.List;

import br.com.objectos.flat.FlatReader;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class RetornoBradesco implements Retorno {

  public abstract RetornoBradescoHeader header();

  public abstract List<RetornoBradescoTrx> trxList();

  public abstract RetornoBradescoTrailer trailer();

  RetornoBradesco() {
  }

  public static RetornoBradescoBuilder builder() {
    return new RetornoBradescoBuilderPojo();
  }

  public static RetornoBradesco read(String txt) {
    try (FlatReader reader = FlatReader.ofString(txt)) {
      return RetornoBradescoPojo.readFrom(reader);
    }
  }

}