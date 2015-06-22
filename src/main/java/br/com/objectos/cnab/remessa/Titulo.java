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
public interface Titulo {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Titulo> {

    String getUsoDaEmpresa();

    EspecieDeTitulo getEspecie();

    long getNossoNumero();

    String getNumero();

    Cedente getCedente();

    Sacado getSacado();

    LocalDate getEmissao();

    LocalDate getVencimento();

    int getPrazo();

    double getValor();

    double getValorDesconto();

    double getValorIof();

    double getValorAbatimento();

    boolean isNegociado();

  }

  String getUsoDaEmpresa();

  EspecieDeTitulo getEspecie();

  long getNossoNumero();

  String getNumero();

  Cedente getCedente();

  Sacado getSacado();

  LocalDate getEmissao();

  LocalDate getVencimento();

  int getPrazo();

  double getValor();

  double getValorDesconto();

  double getValorIof();

  double getValorAbatimento();

  boolean isNegociado();

}