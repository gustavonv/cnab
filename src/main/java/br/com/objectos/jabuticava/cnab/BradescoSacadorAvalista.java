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

import static br.com.objectos.way.base.br.TipoDeCadastroRFB.CPF;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.Cpf;
import br.com.objectos.way.base.br.TipoDeCadastroRFB;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class BradescoSacadorAvalista {

  final CadastroRFB cadastro;

  final String nome;

  public BradescoSacadorAvalista(CadastroRFB cadastro, String nome) {
    this.cadastro = cadastro;
    this.nome = nome;
  }

  public static BradescoSacadorAvalista of(CadastroRFB cadastro, String nome) {
    TipoDeCadastroRFB tipo = cadastro.getTipo();
    return CPF.equals(tipo) ? new PessoaFisica(cadastro, nome) : new PessoaJuridica(cadastro, nome);
  }

  @Override
  public abstract String toString();

  private static class PessoaFisica extends BradescoSacadorAvalista {

    private final ColunaInteger inscricao = new ColunaInteger(1, 9);
    private final ColunaInteger digito = new ColunaInteger(1, 2);
    private final ColunaAlfanumerica avalista = new ColunaAlfanumerica(1, 43);

    public PessoaFisica(CadastroRFB cadastro, String nome) {
      super(cadastro, nome);
    }

    @Override
    public String toString() {
      StringBuilder s = new StringBuilder();

      Cpf cpf = (Cpf) cadastro;
      ColunaWriter<Integer> inscricaoCol = inscricao.set(cpf.getInscricao());
      s.append(inscricaoCol.get());

      s.append("0000");

      ColunaWriter<Integer> digitoCol = digito.set(cpf.getDigito());
      s.append(digitoCol.get());

      s.append("  ");

      ColunaWriter<String> avalistaCol = avalista.set(nome);
      s.append(avalistaCol.get());

      return s.toString();
    }

  }

  private static class PessoaJuridica extends BradescoSacadorAvalista {

    private final ColunaLong inscricao = new ColunaLong(1, 15);
    private final ColunaAlfanumerica avalista = new ColunaAlfanumerica(1, 43);

    public PessoaJuridica(CadastroRFB cadastro, String nome) {
      super(cadastro, nome);
    }

    @Override
    public String toString() {
      StringBuilder s = new StringBuilder();

      Cnpj cnpj = (Cnpj) cadastro;
      ColunaWriter<Long> inscricaoCol = inscricao.set(cnpj.longValue());
      s.append(inscricaoCol.get());

      s.append("  ");

      ColunaWriter<String> avalistaCol = avalista.set(nome);
      s.append(avalistaCol.get());

      return s.toString();
    }

  }

}