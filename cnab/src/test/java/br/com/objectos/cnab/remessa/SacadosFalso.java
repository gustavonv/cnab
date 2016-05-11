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

import br.com.objectos.jabuticava.Cep;
import br.com.objectos.jabuticava.Cpf;
import br.com.objectos.jabuticava.Estado;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class SacadosFalso {

  public static final Sacado MACHADO_ASSIS = Sacado.builder()
      .cadastroRFB(Cpf.valueOf(11641451505l))
      .nome("Machado de Assis")
      .endereco(Endereco.builder()
          .logradouro("Rua ABL, sem no.")
          .cidade("Rio de Janeiro")
          .bairro("")
          .estadoOf(Estado.RJ)
          .cep(Cep.valueOf(12345020))
          .build())
      .build();

  public static final Sacado JOSE_ALENCAR = Sacado.builder()
      .cadastroRFB(Cpf.valueOf(54114537554l))
      .nome("José de Alencar")
      .endereco(Endereco.builder()
          .logradouro("Rua Whatever, 345")
          .cidade("Messejana")
          .bairro("Vilarejo")
          .estadoOf(Estado.CE)
          .cep(Cep.valueOf(78910020))
          .build())
      .build();

  public static final Sacado CECILIA_MEIRELES = Sacado.builder()
      .cadastroRFB(Cpf.valueOf(72825188824l))
      .nome("Cecília Meireles")
      .endereco(Endereco.builder()
          .logradouro("Av Principal, 97")
          .cidade("Rio de Janeiro")
          .bairro("Um bairro")
          .estadoOf(Estado.RJ)
          .cep(Cep.valueOf(13506555))
          .build())
      .build();

  public static final Sacado JORGE_LUIS_BORGES = Sacado.builder()
      .cadastroRFB(Cpf.valueOf(16723128176l))
      .nome("Jorge Luís Borges")
      .endereco(Endereco.builder()
          .logradouro("Argentina")
          .cidade("")
          .bairro("")
          .estado()
          .cep(Cep.valueOf(13506555))
          .build())
      .build();

  private SacadosFalso() {
  }

}