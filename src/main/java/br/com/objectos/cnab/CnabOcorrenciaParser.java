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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.objectos.collections.ImmutableList;
import br.com.objectos.comuns.io.FixedLine;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CnabOcorrenciaParser extends OcorrenciaParser {

  @Override
  public Ocorrencia apply(FixedLine line) {
    return new Ocorrencia() {
      @Override
      public OcorrenciaTipo getTipo() {
        return OcorrenciaTipo.DESCONHECIDA;
      }

      @Override
      public List<Motivo> getMotivos() {
        return ImmutableList.of();
      }

      @Override
      public List<OcorrenciaEvento> asEventos() {
        return ImmutableList.of();
      }

      @Override
      public String getDescricao() {
        return "";
      }

      @Override
      public OcorrenciaCodigo getCodigo() {
        return new OcorrenciaCodigoPadrao(0, null, null) {
          @Override
          Banco getBanco() {
            return Banco.OUTROS;
          }

          @Override
          public OcorrenciaTipo getTipo() {
            return OcorrenciaTipo.DESCONHECIDA;
          }
        };
      }
    };
  }

  @Override
  Banco getBanco() {
    return Banco.OUTROS;
  }

  @Override
  Map<String, OcorrenciaCodigoPadrao> getCodigoMap() {
    return Collections.emptyMap();
  }

}