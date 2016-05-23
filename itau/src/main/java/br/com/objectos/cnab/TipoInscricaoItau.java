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

import static br.com.objectos.jabuticava.TipoDeCadastroRFB.CPF;

import br.com.objectos.flat.FlatEnum;
import br.com.objectos.jabuticava.TipoDeCadastroRFB;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum TipoInscricaoItau implements FlatEnum {

  CEDENTE_CPF("01"),
  CEDENTE_CNPJ("02"),

  SACADOR_CPF("03"),
  SACADOR_CNPJ("04");

  private final String value;

  private TipoInscricaoItau(String value) {
    this.value = value;
  }

  static TipoInscricaoItau ofCedente(TipoDeCadastroRFB tipo) {
    return CPF.equals(tipo) ? SACADOR_CPF : SACADOR_CNPJ;
  }

  static TipoInscricaoItau ofEmpresa(TipoDeCadastroRFB tipo) {
    return CPF.equals(tipo) ? CEDENTE_CPF : CEDENTE_CNPJ;
  }

  @Override
  public String flatValue() {
    return value;
  }

}