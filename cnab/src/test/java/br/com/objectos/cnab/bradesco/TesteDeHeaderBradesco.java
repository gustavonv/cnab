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
package br.com.objectos.cnab.bradesco;

import static br.com.objectos.cnab.Bradesco.header;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.time.LocalDate;

import br.com.objectos.cnab.CnabsFalso;
import br.com.objectos.cnab.Header;
import br.com.objectos.cnab.WayCnab;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeHeaderBradesco {

  private Header header;

  @BeforeClass
  public void prepararRegistro() {
    File file = CnabsFalso.RETORNO_237_01.getFile();

    header = WayCnab.retornoDe(file).getHeader();
  }

  public void identificacao_do_arquivo_retorno() {
    assertThat(header.get(header().codigoDoRetorno()), equalTo(2));
  }

  public void literal_retorno() {
    assertThat(header.get(header().literalRetorno()), equalTo("RETORNO"));
  }

  public void codigo_do_servico() {
    assertThat(header.get(header().codigoDoServico()), equalTo(1));
  }

  public void literal_servico() {
    assertThat(header.get(header().literalServico()), equalTo("COBRANCA"));
  }

  public void codigo_da_empresa() {
    assertThat(header.get(header().codigoDaEmpresa()), equalTo(4097654l));
  }

  public void nome_da_empresa() {
    assertThat(header.get(header().nomeDaEmpresa()), equalTo("OBJECTOS FABRICA DE SOFTWARE L"));
  }

  public void numero_do_bradesco() {
    assertThat(header.get(header().numeroDoBanco()), equalTo(237));
  }

  public void nome_do_banco() {
    assertThat(header.get(header().nomeDoBanco()), equalTo("BRADESCO"));
  }

  public void data_de_gravacao_do_arquivo() {
    assertThat(header.get(header().dataDeGeracaoDoArquivo()), equalTo(LocalDate.of(2012, 4, 30)));
  }

  public void numero_do_aviso_bancario() {
    assertThat(header.get(header().numeroSeqDoArquivoRetorno()), equalTo(1129));
  }

  public void data_de_credito() {
    assertThat(header.get(header().dataDeCredito()), equalTo(LocalDate.of(2012, 5, 2)));
  }

  public void numero_sequencial_de_registro() {
    assertThat(header.get(header().numeroSeqRegistro()), equalTo(1));
  }

}