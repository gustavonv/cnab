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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.objectos.core.util.ImmutableList;
import br.com.objectos.jabuticava.cnab.remessa.Instrucao;
import br.com.objectos.jabuticava.cnab.remessa.InstrucaoTipo;
import br.com.objectos.jabuticava.cnab.remessa.InstrucaoTipoVazio;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class BradescoInstrucao implements InstrucaoTipo {

  private static final Map<Integer, InstrucaoTipo> values = new LinkedHashMap<>();

  static {
    put(0, "N/A");

    put(6, "Protesto automático");
    put(5, "Protesto falimentar");
    put(18, "Decurso de prazo");

    put(8, "Não cobrar juros de mora");
    put(9, "Não receber após o vencimento");
    put(10, "Multa de 10% após o 4o dia do Vencimento.");
    put(11, "Não receber após o 8o dia do vencimento.");
    put(12, "Cobrar encargos após o 5o dia do vencimento.");
    put(13, "Cobrar encargos após o 10o dia do vencimento.");
    put(14, "Cobrar encargos após o 15o dia do vencimento");
    put(15, "Conceder desconto mesmo se pago após o vencimento.");
  }

  public static List<InstrucaoTipo> values() {
    Collection<InstrucaoTipo> tipos = values.values();
    return ImmutableList.copyOf(tipos);
  }

  public static InstrucaoTipo get(int codigo) {
    InstrucaoTipo tipo = values.get(Integer.valueOf(codigo));
    return tipo != null ? tipo : InstrucaoTipoVazio.get();
  }

  private static void put(int codigo, String descricao) {
    BradescoInstrucao value = new BradescoInstrucao(codigo, descricao);
    values.put(codigo, value);
  }

  private final int codigo;

  private final String descricao;

  private BradescoInstrucao(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  @Override
  public int getCodigo() {
    return codigo;
  }

  @Override
  public String getDescricao() {
    return descricao;
  }

  @Override
  public Instrucao with() {
    return instrucao(0);
  }

  @Override
  public Instrucao with(int value) {
    return instrucao(value);
  }

  @Override
  public Instrucao with(double value) {
    return instrucao(value);
  }

  private Instrucao instrucao(double value) {
    return Instrucao.builder()
        .tipo(this)
        .value(value)
        .build();
  }

}