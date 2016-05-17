/*
 * Copyright 2016 Objectos, Fábrica de Software LTDA.
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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum Especie implements FlatEnum {

  DUPLICATA("01", "Duplicata"),

  NOTA_PROMISSORIA("02", "Nota promissória"),

  NOTA_SEGURO("03", "Nota seguro"),

  COBRANCA_SERIADA("04", "Cobrança seriada"),

  RECIBO("05", "Recibo"),

  LETRA_DE_CAMBIO("10", "Letra de câmbio"),

  NOTA_DE_DEBITO("11", "Nota de débito"),

  DUPLICATA_DE_SERV("12", "Duplicata de serviço"),

  OUTROS("99", "Outros");

  private final String codigo;

  private Especie(String codigo, String descricao) {
    this.codigo = codigo;
  }

  @Override
  public String flatValue() {
    return codigo;
  }

}