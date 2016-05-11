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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeColunaBoolean {

  private ColunaWriter<Boolean> writer;

  @BeforeClass
  public void setUp() {
    int inicio = 10;
    int fim = 10;
    writer = new ColunaBoolean(inicio, fim, "S", "N");
  }

  public void bool_true() {
    Boolean value = Boolean.TRUE;
    String res = writer.set(value).get();

    assertThat(res, equalTo("S"));
  }

  public void bool_false() {
    Boolean value = Boolean.FALSE;
    String res = writer.set(value).get();

    assertThat(res, equalTo("N"));
  }

}