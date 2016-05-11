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

import java.util.Map;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ItauOcorrenciaParser extends OcorrenciaParser {

  private static final Map<String, OcorrenciaCodigoPadrao> codigoMap = new Wrapper()
      .codigo(2, "ENTRADA CONFIRMADA")
      // verificar motivos
      .semMotivo(MotivoItauEntradaConfirmada.INSTANCE)

      .codigo(3, "ENTRADA REJEITADA (NOTA 20 - TABELA 1)")
      // verificar motivos
      .semMotivo()

      .codigo(4, "ALTERAÇÃO DE DADOS - NOVA ENTRADA")
      // verificar motivos
      .semMotivo()

      .codigo(5, "ALTERAÇÃO DE DADOS – BAIXA")
      // verificar motivos
      .semMotivo()

      .codigo(6, "LIQUIDAÇÃO NORMAL")
      // verificar motivos
      .semMotivo()

      .codigo(7, "LIQUIDAÇÃO PARCIAL – COBRANÇA INTELIGENTE (B2B)")
      // verificar motivos
      .semMotivo()

      .codigo(8, "LIQUIDAÇÃO EM CARTÓRIO")
      // verificar motivos
      .semMotivo()

      .codigo(9, "BAIXA SIMPLES")
      // verificar motivos
      .semMotivo(MotivoItauBaixaSimples.INSTANCE)

      .codigo(10, "BAIXA POR TER SIDO LIQUIDADO")
      // verificar motivos
      .semMotivo()

      .codigo(11, "EM SER (SÓ NO RETORNO MENSAL)")
      // verificar motivos
      .semMotivo()

      .codigo(12, "ABATIMENTO CONCEDIDO")
      // verificar motivos
      .semMotivo()

      .codigo(13, "ABATIMENTO CANCELADO")
      // verificar motivos
      .semMotivo()

      .codigo(14, "VENCIMENTO ALTERADO")
      // verificar motivos
      .semMotivo()

      .codigo(15, "BAIXAS REJEITADAS (NOTA 20 - TABELA 4)")
      // verificar motivos
      .semMotivo()

      .codigo(16, "INSTRUÇÕES REJEITADAS (NOTA 20 - TABELA 3)")
      // verificar motivos
      .semMotivo()

      .codigo(17, "ALTERAÇÃO DE DADOS REJEITADOS (NOTA 20 - TABELA 2)")
      // verificar motivos
      .semMotivo()

      .codigo(18,
          "COBRANÇA CONTRATUAL - INSTRUÇÕES/ALTERAÇÕES REJEITADAS/PENDENTES (NOTA 20 - TABELA 5)")
      // verificar motivos
      .semMotivo()

      .codigo(19, "CONFIRMA RECEBIMENTO DE INSTRUÇÃO DE PROTESTO")
      // verificar motivos
      .semMotivo()

      .codigo(20, "CONFIRMA RECEBIMENTO DE INSTRUÇÃO DE SUSTAÇÃO DE PROTESTO /TARIFA")
      // verificar motivos
      .semMotivo()

      .codigo(21, "CONFIRMA RECEBIMENTO DE INSTRUÇÃO DE NÃO PROTESTAR")
      // verificar motivos
      .semMotivo()

      .codigo(23, "TÍTULO ENVIADO A CARTÓRIO/TARIFA")
      // verificar motivos
      .semMotivo()

      .codigo(24, "INSTRUÇÃO DE PROTESTO REJEITADA / SUSTADA / PENDENTE (NOTA 20 - TABELA 7)")
      // verificar motivos
      .semMotivo()

      .codigo(25, "ALEGAÇÕES DO SACADO (NOTA 20 - TABELA 6)")
      // verificar motivos
      .semMotivo()

      .codigo(26, "TARIFA DE AVISO DE COBRANÇA")
      // verificar motivos
      .semMotivo()

      .codigo(27, "TARIFA DE EXTRATO POSIÇÃO (B40X)")
      // verificar motivos
      .semMotivo()

      .codigo(28, "TARIFA DE RELAÇÃO DAS LIQUIDAÇÕES")
      // verificar motivos
      .semMotivo()

      .codigo(29, "TARIFA DE MANUTENÇÃO DE TÍTULOS VENCIDOS")
      // verificar motivos
      .semMotivo()

      .codigo(30, "DÉBITO MENSAL DE TARIFAS (PARA ENTRADAS E BAIXAS)")
      // verificar motivos
      .semMotivo()

      .codigo(32, "BAIXA POR TER SIDO PROTESTADO")
      // verificar motivos
      .semMotivo()

      .codigo(33, "CUSTAS DE PROTESTO")
      // verificar motivos
      .semMotivo()

      .codigo(34, "CUSTAS DE SUSTAÇÃO")
      // verificar motivos
      .semMotivo()

      .codigo(35, "CUSTAS DE CARTÓRIO DISTRIBUIDOR")
      // verificar motivos
      .semMotivo()

      .codigo(36, "CUSTAS DE EDITAL")
      // verificar motivos
      .semMotivo()

      .codigo(37, "TARIFA DE EMISSÃO DE BOLETO/TARIFA DE ENVIO DE DUPLICATA")
      // verificar motivos
      .semMotivo()

      .codigo(38, "TARIFA DE INSTRUÇÃO")
      // verificar motivos
      .semMotivo()

      .codigo(39, "TARIFA DE OCORRÊNCIAS")
      // verificar motivos
      .semMotivo()

      .codigo(40, "TARIFA MENSAL DE EMISSÃO DE BOLETO/TARIFA MENSAL DE ENVIO DE DUPLICATA")
      // verificar motivos
      .semMotivo()

      .codigo(41, "DÉBITO MENSAL DE TARIFAS – EXTRATO DE POSIÇÃO (B4EP/B4OX)")
      // verificar motivos
      .semMotivo()

      .codigo(42, "DÉBITO MENSAL DE TARIFAS – OUTRAS INSTRUÇÕES")
      // verificar motivos
      .semMotivo()

      .codigo(43, "DÉBITO MENSAL DE TARIFAS – MANUTENÇÃO DE TÍTULOS VENCIDOS")
      // verificar motivos
      .semMotivo()

      .codigo(44, "DÉBITO MENSAL DE TARIFAS – OUTRAS OCORRÊNCIAS")
      // verificar motivos
      .semMotivo()

      .codigo(45, "DÉBITO MENSAL DE TARIFAS – PROTESTO")
      // verificar motivos
      .semMotivo()

      .codigo(46, "DÉBITO MENSAL DE TARIFAS – SUSTAÇÃO DE PROTESTO")
      // verificar motivos
      .semMotivo()

      .codigo(47, "BAIXA COM TRANSFERÊNCIA PARA DESCONTO")
      // verificar motivos
      .semMotivo()

      .codigo(48, "CUSTAS DE SUSTAÇÃO JUDICIAL")
      // verificar motivos
      .semMotivo()

      .codigo(51, "TARIFA MENSAL REF A ENTRADAS BANCOS CORRESPONDENTES NA CARTEIRA")
      // verificar motivos
      .semMotivo()

      .codigo(52, "TARIFA MENSAL BAIXAS NA CARTEIRA")
      // verificar motivos
      .semMotivo()

      .codigo(53, "TARIFA MENSAL BAIXAS EM BANCOS CORRESPONDENTES NA CARTEIRA")
      // verificar motivos
      .semMotivo()

      .codigo(54, "TARIFA MENSAL DE LIQUIDAÇÕES NA CARTEIRA")
      // verificar motivos
      .semMotivo()

      .codigo(55, "TARIFA MENSAL DE LIQUIDAÇÕES EM BANCOS CORRESPONDENTES NA CARTEIRA")
      // verificar motivos
      .semMotivo()

      .codigo(56, "CUSTAS DE IRREGULARIDADE")
      // verificar motivos
      .semMotivo()

      .codigo(57, "INSTRUÇÃO CANCELADA (NOTA 20 – TABELA 8)")
      // verificar motivos
      .semMotivo()

      .codigo(59, "BAIXA POR CRÉDITO EM C/C ATRAVÉS DO SISPAG")
      // verificar motivos
      .semMotivo()

      .codigo(60, "ENTRADA REJEITADA CARNÊ (NOTA 20 – TABELA 1)")
      // verificar motivos
      .semMotivo()

      .codigo(61, "TARIFA EMISSÃO AVISO DE MOVIMENTAÇÃO DE TÍTULOS (2154)")
      // verificar motivos
      .semMotivo()

      .codigo(62, "DÉBITO MENSAL DE TARIFA - AVISO DE MOVIMENTAÇÃO DE TÍTULOS (2154)")
      // verificar motivos
      .semMotivo()

      .codigo(63, "TÍTULO SUSTADO JUDICIALMENTE")
      // verificar motivos
      .semMotivo()

      .codigo(64, "ENTRADA CONFIRMADA COM RATEIO DE CRÉDITO")
      // verificar motivos
      .semMotivo()

      .codigo(69, "CHEQUE DEVOLVIDO (NOTA 20 - TABELA 9)")
      // verificar motivos
      .semMotivo()

      .codigo(71, "ENTRADA REGISTRADA, AGUARDANDO AVALIAÇÃO")
      // verificar motivos
      .semMotivo()

      .codigo(72, "BAIXA POR CRÉDITO EM C/C ATRAVÉS DO SISPAG SEM TÍTULO CORRESPONDENTE")
      // verificar motivos
      .semMotivo()

      .codigo(73,
          "CONFIRMAÇÃO DE ENTRADA NA COBRANÇA SIMPLES – ENTRADA NÃO ACEITA NA COBRANÇA CONTRATUAL")
      // verificar motivos
      .semMotivo()

      .codigo(76, "CHEQUE COMPENSADO")
      // verificar motivos
      .semMotivo()

      .build();

  @Override
  Banco getBanco() {
    return Banco.ITAU;
  }

  @Override
  Map<String, OcorrenciaCodigoPadrao> getCodigoMap() {
    return codigoMap;
  }

  private static class Wrapper extends BuilderWrapper {

    @Override
    OcorrenciaCodigoPadrao newInstance(int codigo, String descricao, MotivoParser motivoParser) {
      return new ItauOcorrencia(codigo, descricao, motivoParser);
    }

  }

}