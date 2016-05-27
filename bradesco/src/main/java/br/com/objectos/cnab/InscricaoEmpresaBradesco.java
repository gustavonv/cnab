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

import br.com.objectos.auto.AutoPojo;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.flat.LongOption;
import br.com.objectos.jabuticava.CadastroRFB;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@AutoPojo
public abstract class InscricaoEmpresaBradesco {

  public abstract TipoInscricaoEmpresaBradesco tipo();
  public abstract CadastroRFB cadastroRfb();

  InscricaoEmpresaBradesco() {
  }

  static InscricaoEmpresaBradesco of(TipoInscricaoEmpresaBradesco tipo) {
    return new SomenteTipo(tipo);
  }

  static InscricaoEmpresaBradesco of(TipoInscricaoEmpresaBradesco tipo, CadastroRFB cadastroRfb) {
    return new InscricaoEmpresaBradescoPojo(tipo, cadastroRfb);
  }

  FlatWriter write(FlatWriter writer) {
    return writer.flatEnum(tipo(), 2).longValue(cadastroRfbValue(), 14, LongOption.ZEROFILL);
  }

  long cadastroRfbValue() {
    return cadastroRfb().longValue();
  }

  private static class SomenteTipo extends InscricaoEmpresaBradesco {

    private final TipoInscricaoEmpresaBradesco tipo;

    public SomenteTipo(TipoInscricaoEmpresaBradesco tipo) {
      this.tipo = tipo;
    }

    @Override
    public TipoInscricaoEmpresaBradesco tipo() {
      return tipo;
    }

    @Override
    public CadastroRFB cadastroRfb() {
      throw new UnsupportedOperationException();
    }

    @Override
    long cadastroRfbValue() {
      return 0;
    }

  }

}