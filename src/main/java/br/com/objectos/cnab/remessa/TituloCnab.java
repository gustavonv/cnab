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

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class TituloCnab implements Titulo {

  private final String usoDaEmpresa;
  private final EspecieDeTitulo especie;
  private final long nossoNumero;
  private final String numero;
  private final Cedente cedente;
  private final Sacado sacado;
  private final LocalDate emissao;
  private final LocalDate vencimento;
  private final int prazo;
  private final double valor;
  private final double valorDesconto;
  private final double valorIof;
  private final double valorAbatimento;
  private final boolean negociado;

  public TituloCnab(Construtor construtor) {
    usoDaEmpresa = construtor.getUsoDaEmpresa();
    especie = construtor.getEspecie();
    nossoNumero = construtor.getNossoNumero();
    numero = construtor.getNumero();
    cedente = construtor.getCedente();
    sacado = construtor.getSacado();
    emissao = construtor.getEmissao();
    vencimento = construtor.getVencimento();
    prazo = construtor.getPrazo();
    valor = construtor.getValor();
    valorDesconto = construtor.getValorDesconto();
    valorIof = construtor.getValorIof();
    valorAbatimento = construtor.getValorAbatimento();
    negociado = construtor.isNegociado();
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