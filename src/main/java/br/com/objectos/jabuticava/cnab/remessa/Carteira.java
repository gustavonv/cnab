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
package br.com.objectos.jabuticava.cnab.remessa;

import static com.google.common.collect.Maps.newHashMap;

import java.util.EnumSet;
import java.util.Map;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum Carteira {

  COBRANCA_SIMPLES_COM_REGISTRO("CSR", "Cobrança simples (com registro)");

  private static final Map<String, Carteira> codigoMap = newHashMap();

  static {
    EnumSet<Carteira> values = EnumSet.allOf(Carteira.class);
    for (Carteira value : values) {
      String codigo = value.getCodigo();
      codigoMap.put(codigo, value);
    }
  }

  private final String codigo;

  private final String descricao;

  private Carteira(String codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public static Carteira load(String codigo) {
    return codigoMap.get(codigo);
  }

  public String getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

}