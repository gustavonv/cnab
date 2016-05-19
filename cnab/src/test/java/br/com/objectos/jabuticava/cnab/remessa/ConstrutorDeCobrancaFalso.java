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
public class ConstrutorDeCobrancaFalso {

  private Carteira carteira;
  private Agencia agencia;
  private Conta conta;
  private Comando comando;
  private Titulo titulo;
  private CobrancaOpcoes opcoes = CobrancaOpcoes.padrao();

  public Cobranca novaInstancia() {
    return Cobranca.builder()
        .carteira(carteira)
        .agencia(agencia)
        .conta(conta)
        .comando(comando)
        .titulo(titulo)
        .opcoes(opcoes)
        .build();
  }

  public ConstrutorDeCobrancaFalso carteira(Carteira carteira) {
    this.carteira = carteira;
    return this;
  }

  public ConstrutorDeCobrancaFalso agencia(Agencia agencia) {
    this.agencia = agencia;
    return this;
  }

  public ConstrutorDeCobrancaFalso conta(Conta conta) {
    this.conta = conta;
    return this;
  }

  public ConstrutorDeCobrancaFalso comando(Comando comando) {
    this.comando = comando;
    return this;
  }

  public ConstrutorDeCobrancaFalso titulo(Titulo titulo) {
    this.titulo = titulo;
    return this;
  }

  public ConstrutorDeCobrancaFalso opcoes(CobrancaOpcoes opcoes) {
    this.opcoes = opcoes;
    return this;
  }

}