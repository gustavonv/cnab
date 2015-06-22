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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import br.com.objectos.cnab.remessa.Caixa;
import br.com.objectos.core.lang.Strings;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ColunaAlfanumerica extends Coluna<String> {

  private final String valor;

  private final Caixa caixa;

  public ColunaAlfanumerica(int inicio, int fim, Caixa caixa) {
    super(inicio, fim);
    valor = "";
    this.caixa = caixa;
  }

  public ColunaAlfanumerica(int inicio, int fim) {
    super(inicio, fim);
    valor = "";
    caixa = Caixa.NORMAL;
  }

  private ColunaAlfanumerica(int inicio, int fim, String valor, Caixa caixa) {
    super(inicio, fim);

    this.valor = valor;
    this.caixa = caixa;
  }

  @Override
  public String get() {
    return format(inicio, fim, valor, caixa);
  }

  @Override
  public ColunaWriter<String> set(Object valor) {
    String val = String.class.cast(valor);

    if (!isOptional()) {
      checkNotNull(val, "%s: Valor não pode ser 'null'", id);
      checkArgument(!val.isEmpty(), "%s: Valor não pode ser 'vazio'", id);
    }

    return new ColunaAlfanumerica(inicio, fim, val, caixa);
  }

  private String format(int inicio, int fim, String valor, Caixa caixa) {
    String res = blankString();

    if (valor != null) {
      res = new StringBuilder(valor).append(res).toString();
    }

    switch (caixa) {
    case ALTA:
      res = res.toUpperCase();
      break;
    case BAIXA:
      res = res.toLowerCase();
      break;
    default:
      break;
    }

    res = paraTamanhoCorreto(res);
    res = removeAcentos(res);

    return res;
  }

  private String paraTamanhoCorreto(String res) {
    return res.substring(0, tamanho);
  }

  private String removeAcentos(String res) {
    return Strings.accentsToAscii(res).toString();
  }

}
