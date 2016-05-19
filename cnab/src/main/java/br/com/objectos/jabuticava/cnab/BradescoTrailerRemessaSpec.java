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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class BradescoTrailerRemessaSpec
    extends AbstractRemessaSpec<BradescoTrailerRemessa> implements BradescoTrailerRemessa {

  private final CnabKey<BradescoTrailerRemessa, String> idDoRegistro;

  private final CnabKey<BradescoTrailerRemessa, String> branco;

  private final CnabKey<BradescoTrailerRemessa, Integer> seqRegistro;

  public BradescoTrailerRemessaSpec() {
    idDoRegistro = id("Identificação do registro")

        .at(1, 1).colunaFixa("9").toKey();

    branco = id("Branco")

        .at(2, 394).colunaBranco().toKey();

    seqRegistro = id("No Seqüencial do Registro")

        .at(395, 400).colunaInteger().toKey();
  }

  @Override
  Class<BradescoTrailerRemessa> getBancoKeyClass() {
    return BradescoTrailerRemessa.class;
  }

  @Override
  public CnabKey<BradescoTrailerRemessa, String> idDoRegistro() {
    return idDoRegistro;
  }

  @Override
  public CnabKey<BradescoTrailerRemessa, String> branco() {
    return branco;
  }

  @Override
  public CnabKey<BradescoTrailerRemessa, Integer> seqRegistro() {
    return seqRegistro;
  }

}