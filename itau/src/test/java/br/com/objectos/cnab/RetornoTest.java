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

import static br.com.objectos.assertion.ListAssertion.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class RetornoTest {

  private List<CnabRetornoAssert> cnabList;

  @BeforeClass
  public void setUp() {
    cnabList = CnabRetornoWget.of(br.com.objectos.jabuticava.cnab.Banco.ITAU);
  }

  @Test(groups = "rio")
  public void itau() throws Throwable {
    Itau itau = Itau.instance();
    List<CnabRetornoResult> resultList = cnabList.stream()
        .map(cnab -> cnab.verifyRetorno(itau))
        .filter(CnabRetornoResult::hasFailed)
        .collect(Collectors.toList());
    for (CnabRetornoResult result : resultList) {
      result.propagate();
      // result.print();
    }
    assertThat(resultList).hasSize(0);
  }

}