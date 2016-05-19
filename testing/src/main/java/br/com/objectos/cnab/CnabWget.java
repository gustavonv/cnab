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
import java.util.Map;
import java.util.stream.Collectors;

import br.com.objectos.core.io.Directory;
import br.com.objectos.core.io.File;
import br.com.objectos.core.net.Wget;
import br.com.objectos.core.util.ImmutableList;
import br.com.objectos.core.util.zip.Unzip;
import br.com.objectos.core.util.zip.UnzipException;
import br.com.objectos.jabuticava.cnab.Banco;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CnabWget {

  private final Banco banco;

  private CnabWget(Banco banco) {
    this.banco = banco;
  }

  public static List<CnabAssert> of(Banco banco) {
    try {
      return new CnabWget(banco).get();
    } catch (UnzipException e) {
      return ImmutableList.of();
    }
  }

  private List<CnabAssert> get() throws UnzipException {
    File file = Wget.url("http://rio.objectos.com.br/test/cnab/" + banco.name() + ".zip")
        .timeoutAfterTenSeconds()
        .dateTimeNaming("zip")
        .build()
        .downloadTo(Directory.JAVA_IO_TMPDIR)
        .file();

    Map<String, List<CnabEntry>> map = Unzip.file(file.toFile())
        .orderedEntryStream()
        .map(CnabEntry::of)
        .collect(Collectors.groupingBy(CnabEntry::id));

    return map.entrySet()
        .stream()
        .map(e -> CnabAssert.of(banco, e))
        .collect(Collectors.toList());
  }

}