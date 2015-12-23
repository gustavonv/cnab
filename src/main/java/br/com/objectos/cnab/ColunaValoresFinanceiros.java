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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;

import br.com.objectos.core.Preconditions;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class ColunaValoresFinanceiros extends Coluna<Double> {

  private final double valor;

  public ColunaValoresFinanceiros(int inicio, int fim) {
    super(inicio, fim);
    valor = 0;
  }

  private ColunaValoresFinanceiros(int inicio, int fim, double valor) {
    super(inicio, fim);

    Preconditions.checkArgument(valor >= 0, "Valor deve ser maior ou igual a zero");

    this.valor = valor;
  }

  @Override
  public String get() {
    return format(inicio, fim, valor);
  }

  @Override
  public Class<Double> getType() {
    return Double.class;
  }

  @Override
  public ColunaWriter<Double> set(Object valor) {
    Double val = Double.class.cast(valor);
    return new ColunaValoresFinanceiros(inicio, fim, val);
  }

  private String format(int inicio, int fim, double valor) {
    String res = blankString();

    if (!isOptional()) {
      char[] reais = new char[tamanho + 1];
      Arrays.fill(reais, '0');
      reais[tamanho - 2] = '.';
      String format = new String(reais);
      DecimalFormatSymbols symbols = new DecimalFormatSymbols();
      symbols.setDecimalSeparator('X');
      DecimalFormat formatador = new DecimalFormat(format, symbols);
      res = formatador.format(valor).replaceAll("X", "");
    }

    if (res.length() > tamanho) {
      char[] error = new char[tamanho];
      Arrays.fill(error, 'x');
      res = new String(error);
    }

    return res;
  }

}