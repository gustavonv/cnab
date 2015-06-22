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

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class OcorrenciaDesconhecida implements Ocorrencia {

  private final String key;

  public OcorrenciaDesconhecida(String key) {
    this.key = key;
  }

  @Override
  public OcorrenciaCodigo getCodigo() {
    return new OcorrenciaCodigoImpl();
  }

  @Override
  public OcorrenciaTipo getTipo() {
    return OcorrenciaTipo.DESCONHECIDA;
  }

  @Override
  public String getDescricao() {
    return "Não identificada";
  }

  @Override
  public List<Motivo> getMotivos() {
    return ImmutableList.of();
  }

  @Override
  public List<OcorrenciaEvento> asEventos() {
    return ImmutableList.of();
  }

  private class OcorrenciaCodigoImpl implements OcorrenciaCodigo {

    @Override
    public String get() {
      return key;
    }

    @Override
    public OcorrenciaTipo getTipo() {
      return OcorrenciaTipo.DESCONHECIDA;
    }

    @Override
    public String getDescricao() {
      return "Não identificada";
    }

    @Override
    public int intValue() {
      return Integer.valueOf(key);
    }

  }

}