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

import br.com.objectos.way.base.br.Cep;
import br.com.objectos.way.base.br.Estado;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeEnderecoFalso implements Endereco.Construtor {

  private String logradouro;
  private String bairro;
  private String cidade;
  private Estado estado;
  private Cep cep;

  @Override
  public Endereco novaInstancia() {
    return new EnderecoCnab(this);
  }

  public ConstrutorDeEnderecoFalso logradouro(String logradouro) {
    this.logradouro = logradouro;
    return this;
  }

  public ConstrutorDeEnderecoFalso bairro(String bairro) {
    this.bairro = bairro;
    return this;
  }

  public ConstrutorDeEnderecoFalso cidade(String cidade) {
    this.cidade = cidade;
    return this;
  }

  public ConstrutorDeEnderecoFalso estado(Estado estado) {
    this.estado = estado;
    return this;
  }

  public ConstrutorDeEnderecoFalso cep(Cep cep) {
    this.cep = cep;
    return this;
  }

  @Override
  public String getLogradouro() {
    return logradouro;
  }

  @Override
  public String getBairro() {
    return bairro;
  }

  @Override
  public String getCidade() {
    return cidade;
  }

  @Override
  public Estado getEstado() {
    return estado;
  }

  @Override
  public Cep getCep() {
    return cep;
  }

}