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

import br.com.objectos.comuns.matematica.financeira.Percentual;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CobrancaOpcoes {

  private boolean aceite = false;
  private boolean cobrancaSimples = false;
  private boolean debitoAutomatico = false;

  private final Percentual multa = Percentual.ZERO;
  private double moraDia = 0d;

  private Instrucao instrucao1 = InstrucaoVazia.get();
  private Instrucao instrucao2 = InstrucaoVazia.get();

  private CobrancaOpcoes() {
  }

  public static CobrancaOpcoes of() {
    return new CobrancaOpcoes();
  }
  public static CobrancaOpcoes padrao() {
    return CobrancaOpcoes.of();
  }

  //

  public CobrancaOpcoes aceite(boolean aceite) {
    this.aceite = aceite;
    return this;
  }

  public CobrancaOpcoes cobrancaSimples(boolean cobrancaSimples) {
    this.cobrancaSimples = cobrancaSimples;
    return this;
  }

  public CobrancaOpcoes debitoAutomatico(boolean debitoAutomatico) {
    this.debitoAutomatico = debitoAutomatico;
    return this;
  }

  public CobrancaOpcoes moraDia(double moraDia) {
    this.moraDia = moraDia;
    return this;
  }

  public CobrancaOpcoes instrucao1(Instrucao instrucao1) {
    this.instrucao1 = instrucao1;
    return this;
  }

  public CobrancaOpcoes instrucao2(Instrucao instrucao2) {
    this.instrucao2 = instrucao2;
    return this;
  }

  //

  public boolean isAceite() {
    return aceite;
  }

  public boolean isCobrancaSimples() {
    return cobrancaSimples;
  }

  public boolean isDebitoAutomatico() {
    return debitoAutomatico;
  }

  public Percentual getMulta() {
    return multa;
  }

  public double getMoraDia() {
    return moraDia;
  }

  public Instrucao getInstrucao1() {
    return instrucao1;
  }

  public Instrucao getInstrucao2() {
    return instrucao2;
  }

}