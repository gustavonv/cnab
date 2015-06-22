/*
 * Copyright 2014 Objectos, Fábrica de Software LTDA.
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

import static com.google.common.collect.Lists.transform;

import java.io.File;
import java.util.List;

import br.com.objectos.cnab.LoteExt;
import br.com.objectos.cnab.WayCnab;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public abstract class TesteDeLoteExtAbstrato {

  private List<LoteExt> lotes;

  @BeforeClass
  public void prepararLotes() {
    MiniCnab cnab = cnab();
    File cnabFile = cnab.getFile();
    lotes = WayCnab.retornoDe(cnabFile).getLotesExt();
  }

  abstract MiniCnab cnab();

  <T> List<T> lotesTo(Function<LoteExt, T> function) {
    List<T> list = transform(lotes, function);
    return ImmutableList.copyOf(list);
  }

}