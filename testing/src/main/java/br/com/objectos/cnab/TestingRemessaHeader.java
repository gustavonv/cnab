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

import java.time.LocalDate;

import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.pojo.CustomFormat;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.flat.pojo.LocalDateFormat;
import br.com.objectos.flat.pojo.LongFormat;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TestingRemessaHeader implements FlatRecord {

  @Fixed(value = "H")
  abstract String prefix();

  @IntegerFormat(length = 10)
  abstract int sequencia();

  @LocalDateFormat(LocalDatePattern.YYYYMMDD)
  abstract LocalDate data();

  @LongFormat(length = 20)
  abstract long codigo();

  @CustomFormat(formatter = CadastroRfbFormatter.class, length = 14)
  abstract CadastroRFB cadastroRfb();

  @Text(length = 100)
  abstract String razaoSocial();

  @IntegerFormat(length = 10)
  abstract int agenciaNumero();

  @IntegerFormat(length = 1)
  abstract int agenciaDigito();

  @IntegerFormat(length = 10)
  abstract int contaNumero();

  @IntegerFormat(length = 1)
  abstract int contaDigito();

  TestingRemessaHeader() {
  }

  br.com.objectos.jabuticava.cnab.remessa.Agencia legacyAgencia() {
    return br.com.objectos.jabuticava.cnab.remessa.Agencia.builder()
        .codigo(agenciaNumero())
        .digito(agenciaDigito())
        .build();
  }

  br.com.objectos.jabuticava.cnab.remessa.Conta legacyConta() {
    return br.com.objectos.jabuticava.cnab.remessa.Conta.builder()
        .numero(contaNumero())
        .digito(contaDigito())
        .build();
  }

  br.com.objectos.jabuticava.cnab.remessa.Empresa legacyEmpresa() {
    return br.com.objectos.jabuticava.cnab.remessa.Empresa.builder()
        .codigo(codigo())
        .cadastroRFB(cadastroRfb())
        .razaoSocial(razaoSocial())
        .build();
  }

  Agencia toAgencia() {
    return Agencia.of(agenciaNumero(), agenciaDigito());
  }

  Conta toConta() {
    return Conta.of(contaNumero(), contaDigito());
  }

  Empresa toEmpresa() {
    return Empresa.of(codigo(), cadastroRfb(), razaoSocial());
  }

}