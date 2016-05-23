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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class BradescoTest {

  private List<CnabAssert> cnabList;

  @BeforeClass
  public void setUp() {
    cnabList = CnabWget.of(br.com.objectos.jabuticava.cnab.Banco.BRADESCO);
  }

  @Test(groups = "rio")
  public void bradesco() {
    Bradesco bradesco = Bradesco.instance();
    for (CnabAssert cnab : cnabList) {
      cnab.verifyRemessa(bradesco);
    }
  }

  @Test(groups = "rio")
  public void cnabLegacy() {
    for (CnabAssert cnab : cnabList) {
      cnab.verifyTestingRemessa();
    }
  }

}