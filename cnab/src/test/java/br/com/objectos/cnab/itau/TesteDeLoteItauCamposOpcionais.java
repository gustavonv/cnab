/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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

import static br.com.objectos.cnab.Itau.lote;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.List;

import br.com.objectos.cnab.CnabsFalso;
import br.com.objectos.cnab.Lote;
import br.com.objectos.cnab.WayCnab;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeLoteItauCamposOpcionais {

  private Lote lote;

  @BeforeClass
  public void prepararRegistro() {
    File file = CnabsFalso.RETORNO_341_02.getFile();
    List<Lote> lotes = WayCnab.retornoDe(file).getLotes();
    lote = lotes.get(0);
  }

  public void alguns_campos_sao_opcionais_na_pratica_diferente_do_manual() {
    assertThat(lote.get(lote().usoDaEmpresa()), equalTo(""));
    assertThat(lote.get(lote().especie()), equalTo(0));
  }

  public void nome_sacado() {
    assertThat(lote.get(lote().nomeDoSacado()), equalTo(null));
  }

}