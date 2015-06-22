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

import java.util.Map;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class LoteRemessa extends AbstractRegistroRemessa<LoteRemessa> {

  LoteRemessa(Banco banco, Map<CnabKey<?, ?>, Object> map) {
    super(banco, map);
  }

  public static Builder paraBanco(Banco banco) {
    return new Builder(banco);
  }

  @Override
  RemessaSpec getSpec(Modelo modelo) {
    return modelo.getLoteRemessaSpec();
  }

  public static class Builder extends AbstractBuilder<Builder, LoteRemessa> {

    public Builder(Banco banco) {
      super(banco);
    }

    @Override
    public LoteRemessa build() {
      return new LoteRemessa(banco, map);
    }

    @Override
    Builder getSelf() {
      return this;
    }

    @Override
    public String toString() {
      return build().toString();
    }

  }

}