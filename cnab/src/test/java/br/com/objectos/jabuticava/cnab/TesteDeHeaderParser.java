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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.fail;

import java.io.File;

import br.com.objectos.comuns.io.ParsedFixedLines;
import br.com.objectos.comuns.io.csv.FixedFile;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeHeaderParser {

  public void excecao_de_header() {
    File file = CnabsFalso.HEADER_01.getFile();
    ParsedFixedLines lines = new Parser(FixedFile.parse(file)).get();
    try {
      new HeaderParser(lines).get();
      fail();
    } catch (ExcecaoCnab e) {
      e.printStackTrace();
    }
  }

  public void banco_correto() {
    File file = CnabsFalso.RETORNO_237_01.getFile();
    ParsedFixedLines lines = new Parser(FixedFile.parse(file)).get();

    Header res = new HeaderParser(lines).get();
    assertThat(res.getBanco(), equalTo(Banco.BRADESCO));
  }

}