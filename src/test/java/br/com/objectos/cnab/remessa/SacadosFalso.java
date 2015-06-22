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

import br.com.objectos.cnab.remessa.Sacado;
import br.com.objectos.way.base.br.Estado;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class SacadosFalso {

  public static final Sacado MACHADO_ASSIS = novo()
      .nome("Machado de Assis")
      .cpf(11641451505l)
      .logradouro("Rua ABL, sem no.")
      .cidade("Rio de Janeiro")
      .estado(Estado.RJ)
      .cep(12345020)
      .novaInstancia();

  public static final Sacado JOSE_ALENCAR = novo()
      .nome("José de Alencar")
      .cpf(54114537554l)
      .logradouro("Rua Whatever, 345")
      .bairro("Vilarejo")
      .cidade("Messejana")
      .estado(Estado.CE)
      .cep(78910020)
      .novaInstancia();

  public static final Sacado CECILIA_MEIRELES = novo()
      .nome("Cecília Meireles")
      .cpf(72825188824l)
      .logradouro("Av Principal, 97")
      .bairro("Um bairro")
      .cidade("Rio de Janeiro")
      .estado(Estado.RJ)
      .cep(13506555)
      .novaInstancia();

  public static final Sacado JORGE_LUIS_BORGES = novo()
      .nome("Jorge Luís Borges")
      .cpf(16723128176l)
      .logradouro("Argentina")
      .cep(13506555)
      .novaInstancia();

  private SacadosFalso() {
  }

  private static ConstrutorDeSacadoFalso novo() {
    return new ConstrutorDeSacadoFalso();
  }

}