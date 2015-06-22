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
package br.com.objectos.cnab.itau;

import static br.com.objectos.cnab.Itau.header;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import br.com.objectos.cnab.CnabsFalso;
import br.com.objectos.cnab.Header;
import br.com.objectos.cnab.WayCnab;

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeHeaderItau {

  private Header header;

  @BeforeClass
  public void preparar_registro() {
    File file = CnabsFalso.RETORNO_341_01.getFile();
    header = WayCnab.retornoDe(file).getHeader();
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

  public void agencia() {
    assertThat(header.get(header().agencia()), equalTo(123));
  }

  public void conta() {
    assertThat(header.get(header().conta()), equalTo(12345));
  }

  public void dac() {
    assertThat(header.get(header().dacConta()), equalTo(2));
  }

  public void nome_da_empresa() {
    assertThat(header.get(header().nomeDaEmpresa()), equalTo("OBJECTOS FABRICA SOFTWARE LTDA"));
  }

  public void numero_do_banco() {
    assertThat(header.get(header().numeroDoBanco()), equalTo(341));
  }

  public void nome_do_banco() {
    assertThat(header.get(header().nomeDoBanco()), equalTo("BANCO ITAU S.A."));
  }

  public void data_de_gravacao_do_arquivo() {
    assertThat(header.get(header().dataDeGeracaoDoArquivo()), equalTo(new LocalDate(2012, 8, 1)));
  }

  public void densidade() {
    assertThat(header.get(header().densidade()), equalTo(1600));
  }

  public void unidade_densidade() {
    assertThat(header.get(header().unidadeDeDensidade()), equalTo("BPI"));
  }

  public void numero_sequencial_do_arquivo_retorno() {
    assertThat(header.get(header().numeroSequencialDoArquivo()), equalTo(4253));
  }

  public void data_de_credito() {
    assertThat(header.get(header().dataDeCredito()), equalTo(new LocalDate(2012, 8, 2)));
  }

  public void numero_sequencial_de_registro() {
    assertThat(header.get(header().numeroSeqRegistro()), equalTo(1));
  }

}