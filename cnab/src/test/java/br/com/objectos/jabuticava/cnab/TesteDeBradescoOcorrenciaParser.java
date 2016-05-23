/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;

import br.com.objectos.comuns.io.FixedLine;
import br.com.objectos.comuns.io.ParsedFixedLines;
import br.com.objectos.comuns.io.csv.FixedFile;
import br.com.objectos.core.util.MoreCollectors;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeBradescoOcorrenciaParser {

  private final OcorrenciaParser parser = Bradesco.ocorrenciaParser;

  public void cod_02_entrada_confirmada() {
    FixedLine line = firstLineOf("02", "00 000000");
    Ocorrencia res = parser.apply(line);
    OcorrenciaCodigo codigo = res.getCodigo();

    assertThat(codigo.get(), equalTo("02"));
    assertThat(codigo.getDescricao(), equalTo("Entrada Confirmada"));

    List<Motivo> motivos = res.getMotivos();
    assertThat(motivos.size(), equalTo(1));

    Motivo m0 = motivos.get(0);
    assertThat(m0.getCodigo(), equalTo("00"));
    assertThat(m0.getDescricao(), equalTo("Ocorrência aceita"));
  }

  public void cod_02_entrada_confirmada_um_motivo() {
    FixedLine line = firstLineOf("02", "7600000000");
    Ocorrencia res = parser.apply(line);
    OcorrenciaCodigo codigo = res.getCodigo();

    assertThat(codigo.get(), equalTo("02"));
    assertThat(codigo.getDescricao(), equalTo("Entrada Confirmada"));

    List<Motivo> motivos = res.getMotivos();
    assertThat(motivos.size(), equalTo(1));

    Motivo m0 = motivos.get(0);
    assertThat(m0.getCodigo(), equalTo("76"));
    assertThat(m0.getDescricao(), equalTo("Sacado Eletrônico DDA (NOVO)"));
  }

  public void cod_02_entrada_confirmada_dois_motivos() {
    FixedLine line = firstLineOf("02", "76750000000");
    Ocorrencia res = parser.apply(line);
    OcorrenciaCodigo codigo = res.getCodigo();

    assertThat(codigo.get(), equalTo("02"));
    assertThat(codigo.getDescricao(), equalTo("Entrada Confirmada"));

    List<Motivo> motivos = res.getMotivos();
    assertThat(motivos.size(), equalTo(2));

    Motivo m0 = motivos.get(0);
    assertThat(m0.getCodigo(), equalTo("76"));
    assertThat(m0.getDescricao(), equalTo("Sacado Eletrônico DDA (NOVO)"));

    Motivo m1 = motivos.get(1);
    assertThat(m1.getCodigo(), equalTo("75"));
    assertThat(m1.getDescricao(),
        equalTo("Débito não agendado - Tipo do número de inscrição do sacado debitado inválido"));
  }

  private FixedLine firstLineOf(String ocorrencia, String motivos) {
    String line = toLine(ocorrencia, motivos);
    FixedFile file = FixedFile.parseString(line);
    ParsedFixedLines _lines = file.getLines();
    List<FixedLine> lines = _lines.stream().collect(MoreCollectors.toImmutableList());
    return lines.get(0);
  }

  private String toLine(String ocorrencia, String motivos) {
    StringBuilder sb = new StringBuilder();
    sb.append(blankString(108));
    sb.append(ocorrencia);
    sb.append(blankString(208));
    sb.append(motivos);
    sb.append(blankString(200));
    return sb.toString();
  }

  private String blankString(int tamanho) {
    char[] chars = new char[tamanho];
    Arrays.fill(chars, ' ');
    return new String(chars);
  }

}