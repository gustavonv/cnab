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

import br.com.objectos.jabuticava.cnab.RemessaEnum;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
public enum EspecieDeTitulo implements RemessaEnum {

  DUPLICATA(1, "Duplicata"),

  NOTA_PROMISSORIA(2, "Nota promissória"),

  NOTA_SEGURO(3, "Nota seguro"),

  COBRANCA_SERIADA(4, "Cobrança seriada"),

  RECIBO(5, "Recibo"),

  LETRA_DE_CAMBIO(10, "Letra de câmbio"),

  NOTA_DE_DEBITO(11, "Nota de débito"),

  DUPLICATA_DE_SERV(12, "Duplicata de serviço"),

  OUTROS(99, "Outros");

  private static final Map<Integer, EspecieDeTitulo> codigoMap = newHashMap();

  static {
    EnumSet<EspecieDeTitulo> especies = EnumSet.allOf(EspecieDeTitulo.class);
    for (EspecieDeTitulo especie : especies) {
      codigoMap.put(especie.codigo, especie);
    }
  }

  private final int codigo;

  private final String descricao;

  private EspecieDeTitulo(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public static EspecieDeTitulo valueOf(int codigo) {
    return codigoMap.get(codigo);
  }

  @Override
  public String getValor() {
    return String.format("%02d", codigo);
  }

  public int getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

}