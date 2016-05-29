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
import br.com.objectos.jabuticava.Cnpj;
import br.com.objectos.jabuticava.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum TipoInscricaoEmpresaBradesco implements FlatEnum {

  CPF("01") {
    @Override
    public InscricaoEmpresaBradesco parse(long value) {
      Cpf cpf = Cpf.valueOf(value);
      return InscricaoEmpresaBradesco.of(this, cpf);
    }
  },

  CNPJ("02") {
    @Override
    public InscricaoEmpresaBradesco parse(long value) {
      Cnpj cnpj = Cnpj.valueOf(value);
      return InscricaoEmpresaBradesco.of(this, cnpj);
    }
  },

  PIS_PASEP("03"),

  NAO_TEM("04"),

  OUTROS("05");

  private final String value;

  private TipoInscricaoEmpresaBradesco(String value) {
    this.value = value;
  }

  @Override
  public String flatValue() {
    return value;
  }

  public InscricaoEmpresaBradesco parse(long value) {
    return InscricaoEmpresaBradesco.of(this);
  }

}