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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CobrancaCnab implements Cobranca {

  private final Carteira carteira;
  private final Agencia agencia;
  private final Conta conta;
  private final Comando comando;
  private final Titulo titulo;
  private final CobrancaOpcoes opcoes;

  public CobrancaCnab(Construtor construtor) {
    carteira = construtor.getCarteira();
    agencia = construtor.getAgencia();
    conta = construtor.getConta();
    comando = construtor.getComando();
    titulo = construtor.getTitulo();
    opcoes = construtor.getOpcoes();
  }

  @Override
  public Carteira getCarteira() {
    return carteira;
  }

  @Override
  public Agencia getAgencia() {
    return agencia;
  }

  @Override
  public Conta getConta() {
    return conta;
  }

  @Override
  public Comando getComando() {
    return comando;
  }

  @Override
  public Titulo getTitulo() {
    return titulo;
  }

  @Override
  public CobrancaOpcoes getOpcoes() {
    return opcoes;
  }

}