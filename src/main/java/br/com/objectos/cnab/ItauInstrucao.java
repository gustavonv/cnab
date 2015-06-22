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

import static com.google.common.collect.Maps.newLinkedHashMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.com.objectos.cnab.remessa.Instrucao;
import br.com.objectos.cnab.remessa.InstrucaoCnab;
import br.com.objectos.cnab.remessa.InstrucaoTipo;
import br.com.objectos.cnab.remessa.InstrucaoTipoVazio;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ItauInstrucao implements InstrucaoTipo {

  private static final Map<Integer, InstrucaoTipo> values = newLinkedHashMap();

  static {
    put(2, "DEVOLVER APÓS 05 DIAS DO VENCIMENTO");
    put(3, "DEVOLVER APÓS 30 DIAS DO VENCIMENTO");
    put(5, "RECEBER CONFORME INSTRUÇÕES NO PRÓPRIO TÍTULO");
    put(6, "DEVOLVER APÓS 10 DIAS DO VENCIMENTO");
    put(7, "DEVOLVER APÓS 15 DIAS DO VENCIMENTO");
    put(8, "DEVOLVER APÓS 20 DIAS DO VENCIMENTO");
    put(9, "PROTESTAR");
    put(10, "NÃO PROTESTAR");
    put(11, "DEVOLVER APÓS 25 DIAS DO VENCIMENTO");
    put(12, "DEVOLVER APÓS 35 DIAS DO VENCIMENTO");
    put(13, "DEVOLVER APÓS 40 DIAS DO VENCIMENTO");
    put(14, "DEVOLVER APÓS 45 DIAS DO VENCIMENTO");
    put(15, "DEVOLVER APÓS 50 DIAS DO VENCIMENTO");
    put(16, "DEVOLVER APÓS 55 DIAS DO VENCIMENTO");
    put(17, "DEVOLVER APÓS 60 DIAS DO VENCIMENTO");
    put(18, "DEVOLVER APÓS 90 DIAS DO VENCIMENTO");
    put(19, "NÃO RECEBER APÓS 05 DIAS DO VENCIMENTO");
    put(20, "NÃO RECEBER APÓS 10 DIAS DO VENCIMENTO");
    put(21, "NÃO RECEBER APÓS 15 DIAS DO VENCIMENTO");
    put(22, "NÃO RECEBER APÓS 20 DIAS DO VENCIMENTO");
    put(23, "NÃO RECEBER APÓS 25 DIAS DO VENCIMENTO");
    put(24, "NÃO RECEBER APÓS 30 DIAS DO VENCIMENTO");
    put(25, "NÃO RECEBER APÓS 35 DIAS DO VENCIMENTO");
    put(26, "NÃO RECEBER APÓS 40 DIAS DO VENCIMENTO");
    put(27, "NÃO RECEBER APÓS 45 DIAS DO VENCIMENTO");
    put(28, "NÃO RECEBER APÓS 50 DIAS DO VENCIMENTO");
    put(29, "NÃO RECEBER APÓS 55 DIAS DO VENCIMENTO");
    put(30, "IMPORTÂNCIA DE DESCONTO POR DIA");
    put(31, "NÃO RECEBER APÓS 60 DIAS DO VENCIMENTO");
    put(32, "NÃO RECEBER APÓS 90 DIAS DO VENCIMENTO");
    put(33, "CONCEDER ABATIMENTO REF. À PIS-PASEP/COFIN/CSSL, MESMO APÓS VENCIMENTO");
    put(34, "PROTESTAR APÓS XX DIAS CORRIDOS DO VENCIMENTO");
    put(35, "PROTESTAR APÓS XX DIAS ÚTEIS DO VENCIMENTO");
    put(37, "RECEBER ATÉ O ÚLTIMO DIA DO MÊS DE VENCIMENTO");
    put(38, "CONCEDER DESCONTO MESMO APÓS VENCIMENTO");
    put(39, "NÃO RECEBER APÓS O VENCIMENTO");
    put(40, "CONCEDER DESCONTO CONFORME NOTA DE CRÉDITO");
    put(42, "PROTESTO PARA FINS FALIMENTARES");
    put(43, "SUJEITO A PROTESTO SE NÃO FOR PAGO NO VENCIMENTO");
    put(44, "IMPORTÂNCIA POR DIA DE ATRASO A PARTIR DE DDMMAA");
    put(45, "TEM DIA DA GRAÇA");
    put(47, "DISPENSAR JUROS/COMISSÃO DE PERMANÊNCIA");
    put(51, "RECEBER SOMENTE COM A PARCELA ANTERIOR QUITADA");
    put(52, "EFETUAR O PAGAMENTO SOMENTE ATRAVÉS DESTE BOLETO E NA REDE BANCÁRIA");
    put(54, "APÓS VENCIMENTO PAGÁVEL SOMENTE NA EMPRESA");
    put(57, "SOMAR VALOR DO TÍTULO AO VALOR DO CAMPO MORA/MULTA CASO EXISTA");
    put(58, "DEVOLVER APÓS 365 DIAS DE VENCIDO");
    put(59, "COBRANÇA NEGOCIADA. PAGÁVEL SOMENTE POR ESTE BOLETO NA REDE BANCÁRIA");
    put(61, "TÍTULO ENTREGUE EM PENHOR EM FAVOR DO CEDENTE ACIMA");
    put(62, "TÍTULO TRANSFERIDO A FAVOR DO CEDENTE");
    put(78, "VALOR DA IDA ENGLOBA MULTA DE 10% PRO RATA");
    put(79, "COBRAR JUROS APÓS 15 DIAS DA EMISSÃO (para títulos com vencimento à vista)");
    put(80, "PAGAMENTO EM CHEQUE: SOMENTE RECEBER COM CHEQUE DE EMISSÃO DO SACADO");
    put(81, "PROTESTAR APÓS XX DIAS CORRIDOS DO VENCIMENTO");
    put(82, "PROTESTAR APÓS XX DIAS ÚTEIS DO VENCIMENTO");
    put(83, "OPERAÇÃO REF A VENDOR");
    put(84, "APÓS VENCIMENTO CONSULTAR A AGÊNCIA CEDENTE");
    put(86, "ANTES DO VENCIMENTO OU APÓS 15 DIAS, PAGÁVEL SOMENTE EM NOSSA SEDE");
    put(87, "USO DO BANCO");
    put(88, "NÃO RECEBER ANTES DO VENCIMENTO");
    put(89, "USO DO BANCO");
    put(90, "NO VENCIMENTO PAGÁVEL EM QUALQUER AGÊNCIA BANCÁRIA");
    put(91, "NÃO RECEBER APÓS XX DIAS DO VENCIMENTO");
    put(92, "DEVOLVER APÓS XX DIAS DO VENCIMENTO");
    put(93, "MENSAGENS NOS BOLETOS COM 30 POSIÇÕES");
    put(94, "MENSAGENS NOS BOLETOS COM 40 POSIÇÕES");
    put(98, "DUPLICATA / FATURA No");
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
    ItauInstrucao value = new ItauInstrucao(codigo, descricao);
    values.put(codigo, value);
  }

  private final int codigo;

  private final String descricao;

  private ItauInstrucao(int codigo, String descricao) {
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
    return new InstrucaoCnab(this, 0);
  }

  @Override
  public Instrucao with(int value) {
    return new InstrucaoCnab(this, value);
  }

  @Override
  public Instrucao with(double value) {
    return new InstrucaoCnab(this, value);
  }

}