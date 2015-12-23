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

import static br.com.objectos.core.Preconditions.checkNotNull;

import br.com.objectos.br.CadastroRFB;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ColunaCadastroDaEmpresa extends Coluna<CadastroRFB> {

  private final CadastroRFB valor;

  public ColunaCadastroDaEmpresa(int inicio, int fim) {
    super(inicio, fim);
    valor = null;
  }

  private ColunaCadastroDaEmpresa(int inicio, int fim, CadastroRFB valor) {
    super(inicio, fim);

    checkNotNull(valor, "CPF/CNPJ não pode ser nulo");

    this.valor = valor;
  }

  @Override
  public String get() {
    String saida = "%0" + getTamanho() + "d";
    long _cadastro = valor != null ? valor.longValue() : 0;
    return String.format(saida, _cadastro);
  }

  @Override
  public Class<CadastroRFB> getType() {
    return CadastroRFB.class;
  }

  @Override
  public ColunaWriter<CadastroRFB> set(Object valor) {
    CadastroRFB val = CadastroRFB.class.cast(valor);
    return new ColunaCadastroDaEmpresa(inicio, fim, val);
  }

}