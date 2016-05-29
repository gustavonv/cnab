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

import java.util.HashMap;
import java.util.Map;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum CarteiraItau {

  COBRANCA_SIMPLES_COM_REGISTRO("I", 112);

  private static final Map<String, CarteiraItau> CODIGO_MAP;
  private static final Map<Integer, CarteiraItau> NUMERO_MAP;

  static {
    CODIGO_MAP = new HashMap<>();
    NUMERO_MAP = new HashMap<>();
    for (CarteiraItau carteira : CarteiraItau.values()) {
      CODIGO_MAP.put(carteira.codigo, carteira);
      NUMERO_MAP.put(carteira.numero, carteira);
    }
  }

  final String codigo;
  final int numero;

  private CarteiraItau(String codigo, int numero) {
    this.codigo = codigo;
    this.numero = numero;
  }

  public static CarteiraItau of(Carteira carteira) {
    return CarteiraItau.valueOf(carteira.name());
  }

  static CarteiraItau fromCodigo(String codigo) {
    return CODIGO_MAP.get(codigo);
  }

  static CarteiraItau fromNumero(int numero) {
    return NUMERO_MAP.get(numero);
  }

}