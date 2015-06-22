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

import br.com.objectos.jabuticava.cnab.remessa.Agencia;
import br.com.objectos.jabuticava.cnab.remessa.Cobranca;
import br.com.objectos.jabuticava.cnab.remessa.Conta;
import br.com.objectos.jabuticava.cnab.remessa.Empresa;

import com.google.common.base.Joiner;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class AbstractRemessaBuilder implements RemessaBuilder {

  final Banco banco;

  Empresa empresa;

  Agencia agencia;

  Conta conta;

  LocalDate dataArquivo;

  int sequenciaArquivo;

  List<Cobranca> cobrancas = newArrayList();

  public AbstractRemessaBuilder(Banco banco) {
    this.banco = banco;
  }

  @Override
  public RemessaBuilder empresa(Empresa empresa) {
    this.empresa = empresa;
    return this;
  }

  @Override
  public AbstractRemessaBuilder agencia(Agencia agencia) {
    this.agencia = agencia;
    return this;
  }

  @Override
  public AbstractRemessaBuilder conta(Conta conta) {
    this.conta = conta;
    return this;
  }

  @Override
  public RemessaBuilder dataArquivo(LocalDate dataArquivo) {
    this.dataArquivo = dataArquivo;
    return this;
  }

  @Override
  public RemessaBuilder sequenciaArquivo(int sequenciaArquivo) {
    this.sequenciaArquivo = sequenciaArquivo;
    return this;
  }

  @Override
  public RemessaBuilder cobrancas(List<Cobranca> cobrancas) {
    this.cobrancas.addAll(cobrancas);
    return this;
  }

  @Override
  public String toString() {
    List<String> lines = build();
    return Joiner.on("\r\n").join(lines);
  }

  protected abstract List<String> build();

}