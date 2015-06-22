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




/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CedentesFalso {

  public static final Cedente ARMAZEM = novo()
      .nome("ARMAZEM DE NEGOCIOS LTDA")
      .cnpj(75778689000189l)
      .novaInstancia();

  public static final Cedente LOJA = novo()
      .nome("LOJA DE COISAS LTDA")
      .cnpj(41162186000162l)
      .novaInstancia();

  public static final Cedente SUPERMERCADO = novo()
      .nome("SUPERMERCADO LTDA")
      .cnpj(34048509000126l)
      .novaInstancia();

  public static final Cedente PF = novo()
      .nome("CEDENTE PF")
      .cpf(15475005575l)
      .novaInstancia();

  private CedentesFalso() {
  }

  private static ConstrutorDeCedenteFalso novo() {
    return new ConstrutorDeCedenteFalso();
  }

}