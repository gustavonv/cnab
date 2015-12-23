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
import java.util.TreeMap;
import java.util.stream.Collectors;

import br.com.objectos.collections.ImmutableList;
import br.com.objectos.collections.MoreCollectors;

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
    motivoMap = parser.toMap();

    Collection<Motivo> values = motivoMap.values();
    motivos = ImmutableList.copyOf(values);

    List<OcorrenciaEvento> eventos = motivos.stream()
        .map(input -> OcorrenciaEventoPadrao.of(OcorrenciaSpecCnab.this, input))
        .collect(MoreCollectors.toImmutableList());

    if (eventos.isEmpty()) {
      OcorrenciaEvento evento = OcorrenciaEventoPadrao.of(this);
      eventos = ImmutableList.of(evento);
    }

    this.eventos = eventos;
  }

  public static Map<String, OcorrenciaSpec> transform(
      Banco banco, Map<String, OcorrenciaCodigoPadrao> map) {

    Map<String, OcorrenciaSpec> specs = map.entrySet()
        .stream()
        .collect(Collectors.toMap(e -> e.getKey(), e -> new OcorrenciaSpecCnab(banco, e.getValue())));

    return new TreeMap<>(specs);

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

}