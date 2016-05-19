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

import static br.com.objectos.assertion.StringAssertion.assertThat;

import java.util.List;
import java.util.Map;

import br.com.objectos.jabuticava.cnab.Banco;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CnabAssert {

  private final Banco banco;
  private final String id;
  private final TestingRemessa remessa;
  private final String expectedOutput;

  private CnabAssert(Banco banco, String id, TestingRemessa remessa, String expectedOutput) {
    this.banco = banco;
    this.id = id;
    this.remessa = remessa;
    this.expectedOutput = expectedOutput;
  }

  static CnabAssert of(Banco banco, Map.Entry<String, List<CnabEntry>> entry) {
    List<CnabEntry> valueList = entry.getValue();
    return new CnabAssert(
        banco,
        entry.getKey(),
        valueList.get(1).toTestingRemessa(),
        valueList.get(0).toExpectedOutput());
  }

  public String id() {
    return id;
  }

  public void verifyTestingRemessa() {
    try {
      String txt = remessa.toTxt(banco);
      assertThat(txt).hasLinesEqualTo(expectedOutput);
    } catch (AssertionError e) {
      System.out.println(id);
      throw e;
    }
  }

}