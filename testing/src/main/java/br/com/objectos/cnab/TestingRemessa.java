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

import java.util.List;
import java.util.stream.Collectors;

import br.com.objectos.core.util.zip.UnzipEntry;
import br.com.objectos.flat.FlatContainer;
import br.com.objectos.flat.FlatReader;
import br.com.objectos.jabuticava.cnab.Banco;
import br.com.objectos.jabuticava.cnab.WayCnab;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
public abstract class TestingRemessa implements FlatContainer {

  abstract TestingRemessaHeader header();
  abstract List<TestingCobranca> cobrancaList();

  TestingRemessa() {
  }

  static TestingRemessa readFrom(UnzipEntry entry) {
    try (FlatReader reader = FlatReader.open(entry.open())) {
      return TestingRemessaPojo.readFrom(reader);
    }
  }

  public String legacyTxt(Banco banco) {
    return WayCnab.remessaPara(banco)
        .sequenciaArquivo(header().sequencia())
        .empresa(header().legacyEmpresa())
        .agencia(header().legacyAgencia())
        .conta(header().legacyConta())
        .dataArquivo(header().data())
        .cobrancas(cobrancaList().stream()
            .map(cob -> cob.legacyCobranca(banco))
            .collect(Collectors.toList()))
        .toString();
  }

  public Remessa toRemessa() {
    return Remessa.builder()
        .sequencia(header().sequencia())
        .data(header().data())
        .empresa(header().toEmpresa())
        .agencia(header().toAgencia())
        .conta(header().toConta())
        .cobrancaList(cobrancaList().stream()
            .map(c -> c.toCobranca())
            .collect(Collectors.toList()))
        .build();
  }

}