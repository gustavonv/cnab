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

import br.com.objectos.cnab.BradescoCarteira;
import br.com.objectos.cnab.remessa.Agencia;
import br.com.objectos.cnab.remessa.AgenciasFalso;
import br.com.objectos.cnab.remessa.Carteira;
import br.com.objectos.cnab.remessa.Conta;
import br.com.objectos.cnab.remessa.ContasFalso;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeBradescoCarteira {

  public void to_string() {
    Carteira carteira = Carteira.COBRANCA_SIMPLES_COM_REGISTRO;
    Agencia agencia = AgenciasFalso.AGENCIA_A;
    Conta conta = ContasFalso.CONTA_1;

    BradescoCarteira pojo = new BradescoCarteira(carteira, agencia, conta);
    String res = pojo.toString();

    assertThat(res, equalTo("00090012300033479"));
  }

}