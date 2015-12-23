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
package br.com.objectos.cnab.remessa;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class InstrucaoTipoVazio implements InstrucaoTipo {

  private static final InstrucaoTipo INSTANCE = new InstrucaoTipoVazio();

  private InstrucaoTipoVazio() {
  }

  public static InstrucaoTipo get() {
    return INSTANCE;
  }

  @Override
  public int getCodigo() {
    return 0;
  }

  @Override
  public String getDescricao() {
    return "N/A";
  }

  @Override
  public Instrucao with() {
    return InstrucaoVazia.get();
  }

  @Override
  public Instrucao with(int value) {
    return InstrucaoVazia.get();
  }

  @Override
  public Instrucao with(double value) {
    return InstrucaoVazia.get();
  }

}