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

import java.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeTituloFalso {

  private String usoDaEmpresa = "";
  private EspecieDeTitulo especie = EspecieDeTitulo.DUPLICATA;
  private long nossoNumero;
  private String numero = "";
  private Cedente cedente = CedentesFalso.PF;
  private Sacado sacado = SacadosFalso.CECILIA_MEIRELES;
  private LocalDate emissao;
  private LocalDate vencimento = LocalDate.now();
  private int prazo;
  private double valor;
  private double valorDesconto;
  private double valorIof;
  private double valorAbatimento;
  private boolean negociado = true;

  public Titulo novaInstancia() {
    return Titulo.builder()
        .usoDaEmpresa(usoDaEmpresa)
        .especie(especie)
        .nossoNumero(nossoNumero)
        .numero(numero)
        .cedente(cedente)
        .sacado(sacado)
        .emissaoOfNullable(emissao)
        .vencimento(vencimento)
        .prazo(prazo)
        .valor(valor)
        .valorDesconto(valorDesconto)
        .valorIof(valorIof)
        .valorAbatimento(valorAbatimento)
        .negociado(negociado)
        .build();
  }

  public ConstrutorDeTituloFalso usoDaEmpresa(String usoDaEmpresa) {
    this.usoDaEmpresa = usoDaEmpresa;
    return this;
  }

  public ConstrutorDeTituloFalso especie(EspecieDeTitulo especie) {
    this.especie = especie;
    return this;
  }

  public ConstrutorDeTituloFalso numero(String numero) {
    this.numero = numero;
    return this;
  }

  public ConstrutorDeTituloFalso cedente(Cedente cedente) {
    this.cedente = cedente;
    return this;
  }

  public ConstrutorDeTituloFalso sacado(Sacado sacado) {
    this.sacado = sacado;
    return this;
  }

  public ConstrutorDeTituloFalso emissao(LocalDate emissao) {
    this.emissao = emissao;
    return this;
  }

  public ConstrutorDeTituloFalso prazo(int prazo) {
    this.prazo = prazo;
    return this;
  }

  public ConstrutorDeTituloFalso vencimento(LocalDate vencimento) {
    this.vencimento = vencimento;
    return this;
  }

  public ConstrutorDeTituloFalso valor(double valor) {
    this.valor = valor;
    return this;
  }

  public ConstrutorDeTituloFalso valorDesconto(double valorDesconto) {
    this.valorDesconto = valorDesconto;
    return this;
  }

  public ConstrutorDeTituloFalso valorIof(double valorIof) {
    this.valorIof = valorIof;
    return this;
  }

  public ConstrutorDeTituloFalso valorAbatimento(double valorAbatimento) {
    this.valorAbatimento = valorAbatimento;
    return this;
  }

  public ConstrutorDeTituloFalso negociado(boolean negociado) {
    this.negociado = negociado;
    return this;
  }

}