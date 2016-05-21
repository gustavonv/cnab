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
package br.com.objectos.cnab.bradesco;

import static br.com.objectos.jabuticava.TipoDeCadastroRFB.CPF;

import br.com.objectos.auto.AutoPojo;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.flat.IntegerOption;
import br.com.objectos.flat.LongOption;
import br.com.objectos.flat.TextOption;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.TipoDeCadastroRFB;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@AutoPojo
public abstract class SacadorAvalista {

  abstract CadastroRFB cadastroRfb();
  abstract String nome();

  SacadorAvalista() {
  }

  public static SacadorAvalista of(CadastroRFB cadastroRfb, String nome) {
    return new SacadorAvalistaPojo(cadastroRfb, nome);
  }

  FlatWriter write(FlatWriter writer, int length) {
    TipoDeCadastroRFB tipo = cadastroRfb().getTipo();
    return CPF.equals(tipo) ? fisica(writer, length) : juridica(writer, length);
  }

  private FlatWriter fisica(FlatWriter writer, int length) {
    CadastroRFB cpf = cadastroRfb();
    return writer
        .integer(cpf.getInscricao(), 9, IntegerOption.ZEROFILL)
        .fixed("0000")
        .integer(cpf.getDigito(), 2)
        .fixed("  ")
        .text(nome(), 43, TextOption.STRIP_ACCENTS);
  }

  private FlatWriter juridica(FlatWriter writer, int length) {
    CadastroRFB cnpj = cadastroRfb();
    return writer
        .longValue(cnpj.longValue(), 15, LongOption.ZEROFILL)
        .fixed("  ")
        .text(nome(), 43, TextOption.STRIP_ACCENTS);
  }

}