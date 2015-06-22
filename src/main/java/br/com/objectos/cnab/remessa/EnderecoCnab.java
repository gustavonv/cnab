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
package br.com.objectos.cnab.remessa;

import br.com.objectos.way.base.br.Cep;
import br.com.objectos.way.base.br.Estado;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class EnderecoCnab implements Endereco {

  private final String logradouro;
  private final String bairro;
  private final String cidade;
  private final Estado estado;
  private final Cep cep;

  public EnderecoCnab(Construtor construtor) {
    logradouro = construtor.getLogradouro();
    bairro = construtor.getBairro();
    cidade = construtor.getCidade();
    estado = construtor.getEstado();
    cep = construtor.getCep();
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