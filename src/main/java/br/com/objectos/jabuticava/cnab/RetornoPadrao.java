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

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class RetornoPadrao implements Retorno {

  private final Banco banco;

  private final Header header;

  private final List<Lote> lotes;

  private final List<LoteExt> lotesExt;

  public RetornoPadrao(Header header, Iterable<Registro> registros) {
    this.banco = header.getBanco();
    this.header = header;

    registros = Iterables.filter(registros, Predicates.notNull());

    List<Lote> lotes = newArrayList();
    for (Registro registro : registros) {
      RegistroTipo tipo = registro.getTipo();
      switch (tipo) {

      default:
        break;

      case LOTE:
        Lote lote = Lote.class.cast(registro);
        lotes.add(lote);
        break;

      }
    }
    this.lotes = ImmutableList.copyOf(lotes);
    this.lotesExt = LoteExtPadrao.transform(lotes);
  }

  @Override
  public Banco getBanco() {
    return banco;
  }

  @Override
  public Header getHeader() {
    return header;
  }

  @Override
  public List<Lote> getLotes() {
    return lotes;
  }

  @Override
  public List<LoteExt> getLotesExt() {
    return lotesExt;
  }

}