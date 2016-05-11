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

import br.com.objectos.comuns.io.FixedLine;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class HeaderPadrao extends RegistroPadrao implements Header {

  public HeaderPadrao(Banco banco, Modelo modelo, FixedLine line) {
    super(banco, modelo.getHeaderSpec(), line);
  }

  @Override
  public final RegistroTipo getTipo() {
    return RegistroTipo.HEADER;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <K extends BancoKey & HeaderKey, V> V get(CnabKey<K, V> key) {
    return (V) map.get(key);
  }

}