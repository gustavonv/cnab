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
package br.com.objectos.cnab;

import static br.com.objectos.testing.MoreMatchers.equalTo;
import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeLoteExtBradesco extends TesteDeLoteExtAbstrato {

  @Override
  MiniCnab cnab() {
    return CnabsFalso.RETORNO_237_01;
  }

  public void ocorrencias() {
    List<String> prova = ImmutableList.<String> builder()
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("06:Liquidação normal")
        .add("10:Baixado conforme instruções da Agência")
        .add("10:Baixado conforme instruções da Agência")
        .add("14:Vencimento Alterado")
        .add("14:Vencimento Alterado")
        .add("33:Confirmação Pedido Alteração Outros Dados")
        .add("33:Confirmação Pedido Alteração Outros Dados")
        .add("02:Entrada Confirmada")
        .add("30:Alteração de Outros Dados Rejeitados")
        .build();

    List<Ocorrencia> ocorrencias = lotesTo(LoteExtToOcorrencia.INSTANCE);
    List<String> res = transform(ocorrencias, new ToCodigo());

    assertThat(res.size(), equalTo(33));
    assertThat(res, equalTo(prova));
  }

  private static class ToCodigo implements Function<Ocorrencia, String> {
    @Override
    public String apply(Ocorrencia input) {
      OcorrenciaCodigo codigo = input.getCodigo();
      String descricao = input.getDescricao();
      return String.format("%s:%s", codigo, descricao);
    }
  }

}