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
package br.com.objectos.cnab.bradesco;

import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class RemessaTrailer implements FlatRecord {

  @Fixed("9")
  abstract String id();

  @Fill(character = ' ', length = 393)
  abstract String branco();

  @IntegerFormat(length = 6, options = IntegerOption.ZEROFILL)
  abstract int seq();

  RemessaTrailer() {
  }

  public static RemessaTrailerBuilder builder() {
    return new RemessaTrailerBuilderPojo();
  }

}