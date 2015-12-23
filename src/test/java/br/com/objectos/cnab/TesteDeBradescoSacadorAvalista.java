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

import br.com.objectos.br.CadastroRFB;
import br.com.objectos.br.Cnpj;
import br.com.objectos.br.Cpf;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeBradescoSacadorAvalista {

  public void pessoa_fisica() {
    CadastroRFB cadastro = Cpf.valueOf(73863347021l);
    String nome = "SACADOR AVALISTA CPF";

    BradescoSacadorAvalista pojo = BradescoSacadorAvalista.of(cadastro, nome);
    String res = pojo.toString();
    assertThat(res.length(), equalTo(60));
    assertThat(res.trim(), equalTo("738633470000021  SACADOR AVALISTA CPF"));
  }

  public void pessoa_juridica() {
    CadastroRFB cadastro = Cnpj.valueOf(7430629000110l);
    String nome = "SACADOR AVALISTA CNPJ";

    BradescoSacadorAvalista pojo = BradescoSacadorAvalista.of(cadastro, nome);
    String res = pojo.toString();
    assertThat(res.length(), equalTo(60));
    assertThat(res.trim(), equalTo("007430629000110  SACADOR AVALISTA CNPJ"));
  }

}