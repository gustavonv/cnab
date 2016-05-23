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

import java.time.LocalDate;

import br.com.objectos.jabuticava.cnab.bradesco.TipoDeVencimento;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ColunaLocalDateVencimentoDeTitulo extends Coluna<LocalDate> {

  private final TipoDeVencimento tipo;

  private final LocalDate valor;

  private ColunaLocalDateVencimentoDeTitulo(int inicio,
                                            int fim,
                                            TipoDeVencimento tipo,
                                            LocalDate valor) {
    super(inicio, fim);
    this.tipo = tipo;
    this.valor = valor;
  }

  public ColunaLocalDateVencimentoDeTitulo(int inicio,
                                           int fim,
                                           TipoDeVencimento tipo) {
    super(inicio, fim);
    this.tipo = tipo;
    valor = LocalDate.now();
  }

  public ColunaLocalDateVencimentoDeTitulo(int inicio, int fim) {
    super(inicio, fim);
    tipo = TipoDeVencimento.DD_MM_AA;
    valor = LocalDate.now();
  }

  @Override
  public String get() {
    return format(inicio, fim, valor, tipo);
  }

  @Override
  public Class<LocalDate> getType() {
    return LocalDate.class;
  }

  @Override
  public ColunaWriter<LocalDate> set(Object valor) {
    LocalDate val = LocalDate.class.cast(valor);
    return new ColunaLocalDateVencimentoDeTitulo(inicio, fim, tipo, val);
  }

  private String format(int inicio, int fim, LocalDate valor, TipoDeVencimento tipo) {
    switch (tipo) {
    case A_VISTA:
      return "000000";
    case CONTRA_APRESENTACOES:
      return "999999";
    case COBRANCA_SEM_REGISTRO:
      return "777777";
    case ALTERAR_PARA_A_VISTA:
      return "888888";
    case DD_MM_AA:
      return LocalDateFormat.DD_MM_YY.format(valor);
    default:
      throw new UnsupportedOperationException();
    }
  }

}