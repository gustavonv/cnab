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
package br.com.objectos.jabuticava.cnab;

import static br.com.objectos.testing.MoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import com.google.common.collect.ImmutableList;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeLoteExtItau extends TesteDeLoteExtAbstrato {

  @Override
  MiniCnab cnab() {
    return CnabsFalso.RETORNO_341_01;
  }

  public void nosso_numero() {
    List<String> prova = ImmutableList.<String> builder()
        .add("193892026")
        .add("160103779")
        .add("184020447")
        .add("187458040")
        .add("193891788")
        .add("193891887")
        .add("193892059")
        .add("201773655")
        .add("201773663")
        .add("201773713")
        .add("201773721")
        .add("201773739")
        .add("202456342")
        .add("202456391")
        .add("193892257")
        .add("236942283")
        .add("172464003")
        .add("172464003")
        .add("172464326")
        .add("172464326")
        .add("172464334")
        .add("172464334")
        .add("172464342")
        .add("172464342")
        .add("256421408")
        .add("256421416")
        .add("256421424")
        .add("256421432")
        .add("256421440")
        .add("256421457")
        .add("256421465")
        .add("256421473")
        .add("256421481")
        .add("256421499")
        .add("256421507")
        .add("256421515")
        .add("256421523")
        .add("256421531")
        .add("256421549")
        .add("256421556")
        .add("256421564")
        .add("256421572")
        .add("256421580")
        .add("256421598")
        .add("256421606")
        .add("256421614")
        .add("256421622")
        .add("256421630")
        .add("256421648")
        .add("256421655")
        .add("256421663")
        .add("256421671")
        .add("256421689")
        .add("256421697")
        .add("256421705")
        .build();

    List<String> res = lotesTo(LoteExtToNossoNumero.INSTANCE);
    assertThat(res, equalTo(prova));
  }

}