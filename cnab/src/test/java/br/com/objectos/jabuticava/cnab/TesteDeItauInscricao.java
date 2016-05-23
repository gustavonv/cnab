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

import br.com.objectos.jabuticava.cnab.remessa.Cedente;
import br.com.objectos.jabuticava.cnab.remessa.CedentesFalso;
import br.com.objectos.jabuticava.cnab.remessa.ConstrutorDeTituloFalso;
import br.com.objectos.jabuticava.cnab.remessa.Empresa;
import br.com.objectos.jabuticava.cnab.remessa.EmpresasFalso;
import br.com.objectos.jabuticava.cnab.remessa.Titulo;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeItauInscricao {

  Empresa empresa = EmpresasFalso.OBJECTOS;

  Cedente pj = CedentesFalso.ARMAZEM;
  Cedente pf = CedentesFalso.PF;

  public void tipo_02() {
    Titulo titulo = novoTitulo()
        .cedente(pf)
        .negociado(false)
        .novaInstancia();

    ItauInscricao res = ItauInscricao.of(empresa, titulo);

    assertThat(res.getTipo(), equalTo(2));
    assertThat(res.getCadastro(), equalTo(empresa.getCadastroRFB()));
  }

  public void tipo_03() {
    Titulo titulo = novoTitulo()
        .cedente(pf)
        .negociado(true)
        .novaInstancia();

    ItauInscricao res = ItauInscricao.of(empresa, titulo);

    assertThat(res.getTipo(), equalTo(3));
    assertThat(res.getCadastro(), equalTo(pf.getCadastroRFB()));
  }

  public void tipo_04() {
    Titulo titulo = novoTitulo()
        .cedente(pj)
        .negociado(true)
        .novaInstancia();

    ItauInscricao res = ItauInscricao.of(empresa, titulo);

    assertThat(res.getTipo(), equalTo(4));
    assertThat(res.getCadastro(), equalTo(pj.getCadastroRFB()));
  }

  private ConstrutorDeTituloFalso novoTitulo() {
    return new ConstrutorDeTituloFalso();
  }

}