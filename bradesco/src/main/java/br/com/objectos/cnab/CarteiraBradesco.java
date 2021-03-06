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

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.objectos.flat.FlatEnum;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum CarteiraBradesco implements FlatEnum {

  COBRANCA_SIMPLES_COM_REGISTRO("009");

  private static final Map<String, CarteiraBradesco> CODIGO_MAP = EnumSet.allOf(CarteiraBradesco.class)
      .stream()
      .collect(Collectors.toMap(CarteiraBradesco::codigo, Function.identity()));

  private final String value;

  private CarteiraBradesco(String value) {
    this.value = value;
  }

  public static CarteiraBradesco of(Carteira carteira) {
    return CarteiraBradesco.valueOf(carteira.name());
  }

  static CarteiraBradesco parse(String text) {
    return CODIGO_MAP.get(text);
  }

  @Override
  public String flatValue() {
    return value;
  }

  String codigo() {
    return value.substring(2);
  }

}