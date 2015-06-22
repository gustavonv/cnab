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
package br.com.objectos.jabuticava.cnab.remessa;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class InstrucaoVazia implements Instrucao {

  private static enum Singleton {

    INSTANCE;

    private final Instrucao instance;

    private Singleton() {
      this.instance = new InstrucaoVazia();
    }

    public Instrucao get() {
      return instance;
    }

  }

  private InstrucaoVazia() {
  }

  public static Instrucao get() {
    return Singleton.INSTANCE.get();
  }

  @Override
  public InstrucaoTipo getTipo() {
    return InstrucaoTipoVazio.get();
  }

  @Override
  public int getCodigo() {
    return 0;
  }

  @Override
  public int intValue() {
    return 0;
  }

  @Override
  public double doubleValue() {
    return 0;
  }

}