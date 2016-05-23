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
package br.com.objectos.cnab;

import br.com.objectos.flat.FlatEnum;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.TipoDeCadastroRFB;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
public enum TipoSacadoBradesco implements FlatEnum {

  CPF("01"),

  CNPJ("02"),

  PIS_PASEP("03"),

  NAO_TEM("98"),

  OUTROS("99");

  private String value;

  private TipoSacadoBradesco(String value) {
    this.value = value;
  }

  public static TipoSacadoBradesco valueOf(CadastroRFB cadastro) {
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
  public String flatValue() {
    return value;
  }

}