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
public enum ComandoItau implements FlatEnum {

  REMESSA("01"),

  BAIXA("02"),

  ABATIMENTO("04"),

  CANCELAMENTO_DO_ABATIMENTO("05"),

  ALTERACAO_DO_CONTROLE("07"),

  ALTERACAO_DO_NUMERO("08"),

  PEDIDO_DE_PROTESTO("09"),

  BAIXAR_TITULO("18"),

  MANTER_CARTEIRA("19"),

  ALTERCAO_DE_OUTROS_DADOS("31"),

  DESAGENDAMENTO("35"),

  ACERTO("68"),

  CANCELAMENTO("69");

  private final String value;

  private ComandoItau(String value) {
    this.value = value;
  }

  public static ComandoItau of(Comando comando) {
    return ComandoItau.valueOf(comando.name());
  }

  @Override
  public String flatValue() {
    return value;
  }

}