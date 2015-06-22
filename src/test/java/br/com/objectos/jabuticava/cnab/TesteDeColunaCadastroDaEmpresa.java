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

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.Cpf;
import br.com.objectos.way.base.br.ExcecaoDeCnpjInvalido;

import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeColunaCadastroDaEmpresa {

  private ColunaWriter<CadastroRFB> writer;

  public void deve_formatar_cnpj() {
    int inicio = 221;
    int fim = 234;
    int tamanho = 14;
    Cnpj valor = Cnpj.valueOf(26337301000107l);

    writer = new ColunaCadastroDaEmpresa(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("26337301000107"));
  }

  public void deve_formatar_cpf() {
    int inicio = 4;
    int fim = 17;
    int tamanho = 14;
    Cpf valor = Cpf.valueOf(63455179762l);

    writer = new ColunaCadastroDaEmpresa(inicio, fim).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo("00063455179762"));
  }

  @Test(expectedExceptions = { NullPointerException.class })
  public void caso_cadastro_seja_null_lancar_excecao() {
    int inicio = 0;
    int fim = 0;
    Cpf valor = null;

    writer = new ColunaCadastroDaEmpresa(inicio, fim).set(valor);
    writer.get();
  }

  @Test(expectedExceptions = { ExcecaoDeCnpjInvalido.class })
  public void caso_cadastro_seja_invalido_lancar_excecao() {
    int inicio = 0;
    int fim = 0;
    Cnpj valor = Cnpj.valueOf("INVALIDO");

    writer = new ColunaCadastroDaEmpresa(inicio, fim).set(valor);
    writer.get();
  }

}