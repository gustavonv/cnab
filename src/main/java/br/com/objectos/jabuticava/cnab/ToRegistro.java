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
package br.com.objectos.jabuticava.cnab;

import br.com.objectos.comuns.io.FixedLine;

import com.google.common.base.Function;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ToRegistro implements Function<FixedLine, Registro> {

  private final Banco banco;

  private final Modelo modelo;

  public ToRegistro(Banco banco) {
    this.banco = banco;
    this.modelo = banco.getModelo();
  }

  @Override
  public Registro apply(FixedLine line) {
    Integer tipo = line.column(0, 1).get(Integer.class);

    switch (tipo.intValue()) {
    case 0:
      return new HeaderPadrao(banco, modelo, line);

    case 1:
      return new LotePadrao(banco, modelo, line);

    default:
      return null;

    }
  }

}