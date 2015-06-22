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

import static br.com.objectos.jabuticava.cnab.WayCnab.lote;

import com.google.common.base.Objects;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class MotivoPadrao implements Motivo {

  private final String codigo;

  private final String descricao;

  public MotivoPadrao(String codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  @Override
  public String getCodigo() {
    return codigo;
  }

  @Override
  public String getDescricao() {
    return descricao;
  }

  @Override
  public boolean isVazio() {
    return false;
  }

  @Override
  public double recebidoDe(Lote lote) {
    Double val = lote.get(lote().valorPago());
    return val.doubleValue();
  }

  @Override
  public double jurosDe(Lote lote) {
    Double val = lote.get(WayCnab.lote().valorMora());
    return val.doubleValue();
  }

  @Override
  public double tarifaDe(Lote lote) {
    Double val = lote.get(WayCnab.lote().despesaDeCobranca());
    return val.doubleValue();
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(codigo);
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (obj instanceof MotivoPadrao) {
      final MotivoPadrao that = (MotivoPadrao) obj;
      return Objects.equal(this.codigo, that.codigo);
    } else {
      return false;
    }
  }

}