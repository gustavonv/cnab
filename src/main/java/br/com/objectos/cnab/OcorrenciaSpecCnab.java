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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class OcorrenciaSpecCnab implements OcorrenciaSpec {

  private final Banco banco;

  private final OcorrenciaCodigoPadrao codigo;

  private final Map<String, Motivo> motivoMap;

  private final List<Motivo> motivos;

  private final List<OcorrenciaEvento> eventos;

  private OcorrenciaSpecCnab(Banco banco, OcorrenciaCodigoPadrao codigo) {
    this.banco = banco;
    this.codigo = codigo;
    MotivoParser parser = codigo.motivoParser;
    this.motivoMap = parser.toMap();

    Collection<Motivo> values = motivoMap.values();
    this.motivos = ImmutableList.copyOf(values);

    List<OcorrenciaEvento> _lazy;
    _lazy = Lists.transform(motivos, new ToEvento());

    List<OcorrenciaEvento> eventos;
    eventos = ImmutableList.copyOf(_lazy);

    if (eventos.isEmpty()) {
      OcorrenciaEvento evento = OcorrenciaEventoPadrao.of(this);
      eventos = ImmutableList.of(evento);
    }
    this.eventos = eventos;
  }

  public static Map<String, OcorrenciaSpec> transform(
      Banco banco, Map<String, OcorrenciaCodigoPadrao> map) {

    Map<String, OcorrenciaSpec> specs = Maps.transformValues(map, new FromCodigo(banco));
    return ImmutableSortedMap.copyOf(specs);

  }

  @Override
  public Banco getBanco() {
    return banco;
  }

  @Override
  public OcorrenciaCodigo getCodigo() {
    return codigo;
  }

  @Override
  public String getDescricao() {
    return codigo.getDescricao();
  }

  @Override
  public List<Motivo> getMotivos() {
    return motivos;
  }

  @Override
  public Motivo getMotivo(String codigo) {
    return motivoMap.get(codigo);
  }

  @Override
  public List<OcorrenciaEvento> getEventos() {
    return eventos;
  }

  @Override
  public OcorrenciaEvento getEvento(String motivo) {
    OcorrenciaEvento evento = OcorrenciaEventoPadrao.of(this);

    Motivo _motivo = motivoMap.get(motivo);
    if (_motivo != null) {
      evento = OcorrenciaEventoPadrao.of(this, _motivo);
    }

    return evento;
  }

  private static class FromCodigo implements Function<OcorrenciaCodigoPadrao, OcorrenciaSpec> {

    private final Banco banco;

    public FromCodigo(Banco banco) {
      this.banco = banco;
    }

    @Override
    public OcorrenciaSpec apply(OcorrenciaCodigoPadrao input) {
      return new OcorrenciaSpecCnab(banco, input);
    }

  }

  private class ToEvento implements Function<Motivo, OcorrenciaEvento> {
    @Override
    public OcorrenciaEvento apply(Motivo input) {
      return OcorrenciaEventoPadrao.of(OcorrenciaSpecCnab.this, input);
    }
  }

}