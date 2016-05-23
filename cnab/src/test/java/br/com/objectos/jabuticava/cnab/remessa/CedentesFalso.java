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

import br.com.objectos.jabuticava.Cnpj;
import br.com.objectos.jabuticava.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CedentesFalso {

  public static final Cedente ARMAZEM = Cedente.builder()
      .cadastroRFB(Cnpj.valueOf(75778689000189l))
      .nome("ARMAZEM DE NEGOCIOS LTDA")
      .build();

  public static final Cedente LOJA = Cedente.builder()
      .cadastroRFB(Cnpj.valueOf(41162186000162l))
      .nome("LOJA DE COISAS LTDA")
      .build();

  public static final Cedente SUPERMERCADO = Cedente.builder()
      .cadastroRFB(Cnpj.valueOf(34048509000126l))
      .nome("SUPERMERCADO LTDA")
      .build();

  public static final Cedente PF = Cedente.builder()
      .cadastroRFB(Cpf.valueOf(15475005575l))
      .nome("CEDENTE PF")
      .build();

  private CedentesFalso() {
  }

}