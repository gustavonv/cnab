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
import java.util.Optional;

import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class Titulo {

  public abstract String getUsoDaEmpresa();
  public abstract EspecieDeTitulo getEspecie();
  public abstract long getNossoNumero();
  public abstract String getNumero();
  public abstract Cedente getCedente();
  public abstract Sacado getSacado();
  public abstract Optional<LocalDate> getEmissao();
  public abstract LocalDate getVencimento();
  public abstract int getPrazo();
  public abstract double getValor();
  public abstract double getValorDesconto();
  public abstract double getValorIof();
  public abstract double getValorAbatimento();
  public abstract boolean isNegociado();

  protected Titulo() {
  }

  public static TituloBuilder builder() {
    return new TituloBuilderPojo();
  }

}