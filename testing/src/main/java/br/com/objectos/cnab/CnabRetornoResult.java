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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public abstract class CnabRetornoResult {

  private final String entryName;

  CnabRetornoResult(String entryName) {
    this.entryName = entryName;
  }

  static CnabRetornoResult fail(String entryName, Throwable e) {
    return new Fail(entryName, e);
  }

  static CnabRetornoResult success(String entryName) {
    return new Success(entryName);
  }

  public abstract boolean hasFailed();

  public void print() {
    System.out.println(entryName);
  }

  public void propagate() throws Throwable {
  }

  private static class Fail extends CnabRetornoResult {

    private final Throwable e;

    public Fail(String entryName, Throwable e) {
      super(entryName);
      this.e = e;
    }

    @Override
    public boolean hasFailed() {
      return true;
    }

    @Override
    public void print() {
      super.print();
      e.printStackTrace();
    }

    @Override
    public void propagate() throws Throwable {
      super.print();
      throw e;
    }

  }

  private static class Success extends CnabRetornoResult {

    Success(String entryName) {
      super(entryName);
    }

    @Override
    public boolean hasFailed() {
      return false;
    }

  }

}