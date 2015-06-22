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
package br.com.objectos.jabuticava.cnab.bradesco;

import br.com.objectos.jabuticava.cnab.RemessaEnum;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.TipoDeCadastroRFB;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
public enum TipoDeIncricaoDoSacado implements RemessaEnum {

  CPF("01"),

  CNPJ("02"),

  PIS_PASEP("03"),

  NAO_TEM("98"),

  OUTROS("99");

  private String valor;

  private TipoDeIncricaoDoSacado(String valor) {
    this.valor = valor;
  }

  public static TipoDeIncricaoDoSacado valueOf(CadastroRFB cadastro) {
    TipoDeCadastroRFB tipo = cadastro.getTipo();
    switch (tipo) {
    case CPF:
      return CPF;
    case CNPJ:
      return CNPJ;
    default:
      return OUTROS;
    }
  }

  @Override
  public String getValor() {
    return valor;
  }

}