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
import java.util.Set;

import br.com.objectos.collections.ImmutableList;
import br.com.objectos.comuns.io.FixedLine;
import br.com.objectos.core.Preconditions;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class OcorrenciaCodigoPadrao implements OcorrenciaCodigo {

  final int codigo;

  final String descricao;

  final String key;

  final MotivoParser motivoParser;

  public OcorrenciaCodigoPadrao(int codigo, String descricao, MotivoParser motivoParser) {
    this.codigo = codigo;
    this.descricao = descricao;
    key = String.format("%02d", codigo);
    this.motivoParser = motivoParser;

    Preconditions.checkArgument(codigo >= 0, "Código deve ser um número entre 0 e 99");
    Preconditions.checkArgument(codigo < 100, "Código deve ser um número entre 0 e 99");
  }

  final Ocorrencia apply(FixedLine line) {
    List<Motivo> motivos = parseMotivos(line);
    return new OcorrenciaPadrao(this, motivos);
  }

  final Motivo motivoVazio() {
    return motivoParser.vazio();
  }

  final List<Motivo> parseMotivos(FixedLine line) {
    Set<Motivo> motivos = motivoParser.parse(line);
    return ImmutableList.copyOf(motivos);
  }

  abstract Banco getBanco();

  @Override
  public abstract OcorrenciaTipo getTipo();

  @Override
  public final String getDescricao() {
    return descricao;
  }

  @Override
  public final String get() {
    return key;
  }

  @Override
  public final int intValue() {
    return codigo;
  }

  @Override
  public final String toString() {
    return key;
  }

}