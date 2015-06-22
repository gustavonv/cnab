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
class ItauTrailerRemessaSpec
    extends AbstractRemessaSpec<ItauTrailerRemessa> implements ItauTrailerRemessa {

  private final CnabKey<ItauTrailerRemessa, String> idDoRegistro;

  private final CnabKey<ItauTrailerRemessa, String> branco;

  private final CnabKey<ItauTrailerRemessa, Integer> seqRegistro;

  public ItauTrailerRemessaSpec() {
    idDoRegistro = id("Identificação do registro")

        .at(1, 1).colunaFixa("9").toKey();

    branco = id("Branco")

        .at(2, 394).colunaBranco().toKey();

    seqRegistro = id("No Seqüencial do Registro")

        .at(395, 400).colunaInteger().toKey();
  }

  @Override
  Class<ItauTrailerRemessa> getBancoKeyClass() {
    return ItauTrailerRemessa.class;
  }

  @Override
  public CnabKey<ItauTrailerRemessa, String> idDoRegistro() {
    return idDoRegistro;
  }

  @Override
  public CnabKey<ItauTrailerRemessa, String> branco() {
    return branco;
  }

  @Override
  public CnabKey<ItauTrailerRemessa, Integer> seqRegistro() {
    return seqRegistro;
  }

}