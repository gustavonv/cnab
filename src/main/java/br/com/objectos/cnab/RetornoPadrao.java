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

import java.util.List;

import br.com.objectos.collections.MoreCollectors;
import br.com.objectos.comuns.io.ParsedFixedLines;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class RetornoPadrao implements Retorno {

  private final Banco banco;

  private final Header header;

  private final List<Lote> lotes;

  private final List<LoteExt> lotesExt;

  private RetornoPadrao(Header header, List<Lote> lotes, List<LoteExt> lotesExt) {
    banco = header.getBanco();
    this.header = header;
    this.lotes = lotes;
    this.lotesExt = lotesExt;
  }

  public static RetornoPadrao of(ParsedFixedLines lines) {
    Header header = new HeaderParser(lines).get();
    Banco banco = header.getBanco();

    List<Lote> lotes = lines.stream()
        .map(new ToRegistro(banco))
        .filter(reg -> reg != null)
        .filter(reg -> reg.getTipo().equals(RegistroTipo.LOTE))
        .map(reg -> Lote.class.cast(reg))
        .collect(MoreCollectors.toImmutableList());

    List<LoteExt> lotesExt = LoteExtPadrao.transform(lotes);

    return new RetornoPadrao(header, lotes, lotesExt);
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