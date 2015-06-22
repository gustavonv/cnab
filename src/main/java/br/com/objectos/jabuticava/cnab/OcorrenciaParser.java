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
import java.util.Map;

import br.com.objectos.comuns.io.FixedLine;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSortedMap;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class OcorrenciaParser {

  public Ocorrencia apply(FixedLine line) {
    String text = line.column(108, 110).get(String.class);
    Ocorrencia ocorrencia = new OcorrenciaDesconhecida(text);

    Map<String, OcorrenciaCodigoPadrao> map = getCodigoMap();
    if (map.containsKey(text)) {
      OcorrenciaCodigoPadrao codigo = getCodigoMap().get(text);
      ocorrencia = codigo.apply(line);
    }

    return ocorrencia;
  }

  public Map<String, OcorrenciaSpec> toSpecMap() {
    Banco banco = getBanco();
    Map<String, OcorrenciaCodigoPadrao> map = getCodigoMap();
    return OcorrenciaSpecCnab.transform(banco, map);
  }

  abstract Banco getBanco();

  abstract Map<String, OcorrenciaCodigoPadrao> getCodigoMap();

  abstract static class BuilderWrapper {

    private final Builder<String, OcorrenciaCodigoPadrao> map;

    public BuilderWrapper() {
      map = ImmutableSortedMap.<String, OcorrenciaCodigoPadrao> naturalOrder();
    }

    public OcorrenciaBuilder codigo(int codigo, String descricao) {
      return new OcorrenciaBuilder(codigo, descricao);
    }

    public ImmutableMap<String, OcorrenciaCodigoPadrao> build() {
      return map.build();
    }

    abstract OcorrenciaCodigoPadrao newInstance(
        int codigo, String descricao, MotivoParser motivoParser);

    class OcorrenciaBuilder {

      private final int codigo;
      private final String descricao;

      public OcorrenciaBuilder(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
      }

      public MotivoBuilder motivosAt(int pos0, int pos1) {
        return new MotivoBuilder(codigo, descricao, pos0, pos1);
      }

      public BuilderWrapper semMotivo() {
        Motivo motivo = MotivoVazio.INSTANCE;
        return semMotivo(motivo);
      }
      public BuilderWrapper semMotivo(Motivo motivo) {
        MotivoParser motivoParser = new MotivoParserVazio(motivo);

        OcorrenciaCodigoPadrao value = newInstance(codigo, descricao, motivoParser);
        String key = value.get();
        map.put(key, value);

        return BuilderWrapper.this;
      }

    }

    class MotivoBuilder {

      private final int codigo;
      private final String descricao;

      private final int pos0;
      private final int pos1;

      String ignorarExtras;
      final List<Motivo> motivos = newArrayList();

      public MotivoBuilder(int codigo, String descricao, int pos0, int pos1) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.pos0 = pos0;
        this.pos1 = pos1;
      }

      public MotivoBuilder ignorarExtras(String codigo) {
        this.ignorarExtras = codigo;
        return this;
      }

      public MotivoBuilder add(String codigo, String descricao) {
        motivos.add(new MotivoPadrao(codigo, descricao));
        return this;
      }
      public MotivoBuilder add(Motivo motivo) {
        motivos.add(motivo);
        return this;
      }

      public BuilderWrapper put() {
        MotivoParser motivoParser = new MotivoParserPadrao(pos0, pos1, ignorarExtras, motivos);

        OcorrenciaCodigoPadrao value = newInstance(codigo, descricao, motivoParser);
        String key = value.get();
        map.put(key, value);

        return BuilderWrapper.this;
      }

    }

  }

}