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

import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.TipoDeCadastroRFB;
import br.com.objectos.cnab.remessa.Cedente;
import br.com.objectos.cnab.remessa.Empresa;
import br.com.objectos.cnab.remessa.Titulo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ItauInscricao {

  private final int tipo;

  private final CadastroRFB cadastro;

  private ItauInscricao(int tipo, CadastroRFB cadastro) {
    this.tipo = tipo;
    this.cadastro = cadastro;
  }

  public static ItauInscricao of(Empresa empresa, Titulo titulo) {
    boolean negociado = titulo.isNegociado();
    Cedente cedente = titulo.getCedente();

    CadastroRFB cadastro = negociado ? cedente.getCadastroRFB() : empresa.getCadastroRFB();
    TipoDeCadastroRFB cadastroTipo = cadastro.getTipo();
    boolean pf = TipoDeCadastroRFB.CPF.equals(cadastroTipo);

    int tipo = !negociado ? pf ? 1 : 2 : pf ? 3 : 4;

    return new ItauInscricao(tipo, cadastro);
  }

  public int getTipo() {
    return tipo;
  }

  public CadastroRFB getCadastro() {
    return cadastro;
  }

}