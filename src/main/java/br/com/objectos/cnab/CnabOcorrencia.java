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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CnabOcorrencia extends OcorrenciaCodigoPadrao {

  public CnabOcorrencia(int codigo, String descricao, MotivoParser motivoParser) {
    super(codigo, descricao, motivoParser);
  }

  @Override
  Banco getBanco() {
    return Banco.OUTROS;
  }

  @Override
  public final OcorrenciaTipo getTipo() {
    switch (codigo) {
    case 2:
      return OcorrenciaTipo.ENTRADA_CONFIRMADA;
    default:
      return OcorrenciaTipo.DESCONHECIDA;
    }
  }

}