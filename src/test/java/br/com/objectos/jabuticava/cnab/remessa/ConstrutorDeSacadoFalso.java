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
package br.com.objectos.jabuticava.cnab.remessa;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cep;
import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.Cpf;
import br.com.objectos.way.base.br.Estado;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeSacadoFalso implements Sacado.Construtor {

  private CadastroRFB cadastroRFB;

  private String nome;

  private final ConstrutorDeEnderecoFalso endereco = new ConstrutorDeEnderecoFalso();

  @Override
  public Sacado novaInstancia() {
    return new SacadoCnab(this);
  }

  public ConstrutorDeSacadoFalso cpf(long cpf) {
    this.cadastroRFB = Cpf.valueOf(cpf);
    return this;
  }
  public ConstrutorDeSacadoFalso cnpj(long cnpj) {
    this.cadastroRFB = Cnpj.valueOf(cnpj);
    return this;
  }

  public ConstrutorDeSacadoFalso nome(String nome) {
    this.nome = nome;
    return this;
  }

  public ConstrutorDeSacadoFalso logradouro(String logradouro) {
    endereco.logradouro(logradouro);
    return this;
  }

  public ConstrutorDeSacadoFalso bairro(String bairro) {
    endereco.bairro(bairro);
    return this;
  }

  public ConstrutorDeSacadoFalso cidade(String cidade) {
    endereco.cidade(cidade);
    return this;
  }

  public ConstrutorDeSacadoFalso estado(Estado estado) {
    endereco.estado(estado);
    return this;
  }

  public ConstrutorDeSacadoFalso cep(String cep) {
    endereco.cep(Cep.valueOf(cep));
    return this;
  }
  public ConstrutorDeSacadoFalso cep(int cep) {
    endereco.cep(Cep.valueOf(cep));
    return this;
  }

  @Override
  public CadastroRFB getCadastroRFB() {
    return cadastroRFB;
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public Endereco getEndereco() {
    return endereco.novaInstancia();
  }

}