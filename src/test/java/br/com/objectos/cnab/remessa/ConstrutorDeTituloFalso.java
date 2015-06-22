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

import br.com.objectos.cnab.remessa.Cedente;
import br.com.objectos.cnab.remessa.EspecieDeTitulo;
import br.com.objectos.cnab.remessa.Sacado;
import br.com.objectos.cnab.remessa.Titulo;
import br.com.objectos.cnab.remessa.TituloCnab;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeTituloFalso implements Titulo.Construtor {

  private String usoDaEmpresa;
  private EspecieDeTitulo especie;
  private long nossoNumero;
  private String numero;
  private Cedente cedente;
  private Sacado sacado;
  private LocalDate emissao;
  private LocalDate vencimento;
  private int prazo;
  private double valor;
  private double valorDesconto;
  private double valorIof;
  private double valorAbatimento;
  private boolean negociado = true;

  @Override
  public Titulo novaInstancia() {
    return new TituloCnab(this);
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

  @Override
  public String getUsoDaEmpresa() {
    return usoDaEmpresa;
  }

  @Override
  public EspecieDeTitulo getEspecie() {
    return especie;
  }

  @Override
  public long getNossoNumero() {
    return nossoNumero;
  }

  @Override
  public String getNumero() {
    return numero;
  }

  @Override
  public Cedente getCedente() {
    return cedente;
  }

  @Override
  public Sacado getSacado() {
    return sacado;
  }

  @Override
  public LocalDate getEmissao() {
    return emissao;
  }

  @Override
  public LocalDate getVencimento() {
    return vencimento;
  }

  @Override
  public int getPrazo() {
    return prazo;
  }

  @Override
  public double getValor() {
    return valor;
  }

  @Override
  public double getValorDesconto() {
    return valorDesconto;
  }

  @Override
  public double getValorIof() {
    return valorIof;
  }

  @Override
  public double getValorAbatimento() {
    return valorAbatimento;
  }

  @Override
  public boolean isNegociado() {
    return negociado;
  }

}