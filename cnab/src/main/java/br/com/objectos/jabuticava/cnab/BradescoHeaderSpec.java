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

import br.com.objectos.jabuticava.cnab.CnabKey.Construtor;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class BradescoHeaderSpec extends CnabHeaderSpec implements BradescoHeader {

  private final CnabKey<BradescoHeader, Long> CODIGO_EMPRESA = key()
      .id("Código da Empresa").at(26, 46).get(Long.class);

  private CnabKeyDecorator<BradescoHeader> key() {
    Construtor<BradescoHeader> construtor = CnabKey.of(BradescoHeader.class);
    return new CnabKeyDecorator<BradescoHeader>(construtor);
  }

  @Override
  public CnabKey<BradescoHeader, Long> codigoDaEmpresa() {
    return CODIGO_EMPRESA;
  }

}