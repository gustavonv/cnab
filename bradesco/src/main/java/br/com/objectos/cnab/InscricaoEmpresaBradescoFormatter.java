/*
 * Copyright 2016 Objectos, Fábrica de Software LTDA.
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

import br.com.objectos.flat.CustomFormatter;
import br.com.objectos.flat.FlatEnumParser;
import br.com.objectos.flat.FlatWriter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class InscricaoEmpresaBradescoFormatter implements CustomFormatter<InscricaoEmpresaBradesco> {

  @Override
  public InscricaoEmpresaBradesco parse(String text) {
    TipoInscricaoEmpresaBradesco tipo = parseTipo(text);
    long value = parseValue(text);
    return tipo.parse(value);
  }

  @Override
  public FlatWriter write(FlatWriter writer, InscricaoEmpresaBradesco value, int length) {
    return value.write(writer);
  }

  private TipoInscricaoEmpresaBradesco parseTipo(String text) {
    FlatEnumParser<TipoInscricaoEmpresaBradesco> parser = FlatEnumParser.of(TipoInscricaoEmpresaBradesco.class);
    String key = text.substring(0, 2);
    return parser.parse(key);
  }

  private long parseValue(String text) {
    String valueText = text.substring(2);
    return Long.parseLong(valueText, 10);
  }

}