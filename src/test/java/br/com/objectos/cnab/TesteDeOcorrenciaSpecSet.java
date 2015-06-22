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
package br.com.objectos.cnab;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import br.com.objectos.cnab.Banco;
import br.com.objectos.cnab.Motivo;
import br.com.objectos.cnab.OcorrenciaCodigo;
import br.com.objectos.cnab.OcorrenciaEvento;
import br.com.objectos.cnab.OcorrenciaSpec;
import br.com.objectos.cnab.OcorrenciaSpecSet;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeOcorrenciaSpecSet {

  public void deve_ser_possivel_extrair_specs_de_um_banco() {
    OcorrenciaSpecSet set = Banco.BRADESCO;
    List<OcorrenciaSpec> specs = set.getOcorrenciaSpecs();

    assertThat(specs.size(), equalTo(32));

    OcorrenciaSpec r0 = specs.get(0);
    assertThat(r0.getCodigo().intValue(), equalTo(2));
    assertThat(r0.getDescricao(), equalTo("Entrada Confirmada"));

    List<Motivo> m0 = r0.getMotivos();
    assertThat(m0.size(), equalTo(30));

    Motivo m00 = m0.get(0);
    assertThat(m00.getCodigo(), equalTo("00"));
    assertThat(m00.getDescricao(), equalTo("Ocorrência aceita"));

    Motivo m01 = m0.get(1);
    assertThat(m01.getCodigo(), equalTo("01"));
    assertThat(m01.getDescricao(), equalTo("Código do Banco inválido"));
  }

  public void deve_ser_possivel_extrair_ocorrencias_evento() {
    OcorrenciaSpecSet set = Banco.BRADESCO;

    List<OcorrenciaEvento> res = set.getOcorrenciaEventos();
    assertThat(res.size(), equalTo(283));

    OcorrenciaEvento r0 = res.get(0);
    OcorrenciaCodigo o0 = r0.getOcorrencia();
    assertThat(o0.intValue(), equalTo(2));
    assertThat(o0.getDescricao(), equalTo("Entrada Confirmada"));
    Motivo m0 = r0.getMotivo();
    assertThat(m0.isVazio(), is(false));
    assertThat(m0.getCodigo(), equalTo("00"));
    assertThat(m0.getDescricao(), equalTo("Ocorrência aceita"));

    OcorrenciaEvento r1 = res.get(1);
    OcorrenciaCodigo o1 = r1.getOcorrencia();
    assertThat(o1.intValue(), equalTo(2));
    assertThat(o1.getDescricao(), equalTo("Entrada Confirmada"));
    Motivo m1 = r1.getMotivo();
    assertThat(m1.isVazio(), is(false));
    assertThat(m1.getCodigo(), equalTo("01"));
    assertThat(m1.getDescricao(), equalTo("Código do Banco inválido"));
  }

  public void deve_ser_possivel_extrair_ocorrencias_evento_itau() {
    OcorrenciaSpecSet set = Banco.ITAU;

    List<OcorrenciaEvento> res = set.getOcorrenciaEventos();
    assertThat(res.size(), equalTo(63));

    OcorrenciaEvento r0 = res.get(0);
    OcorrenciaCodigo o0 = r0.getOcorrencia();
    assertThat(o0.intValue(), equalTo(2));
    assertThat(o0.getDescricao(), equalTo("ENTRADA CONFIRMADA"));
    Motivo m0 = r0.getMotivo();
    assertThat(m0.isVazio(), is(true));
  }

}