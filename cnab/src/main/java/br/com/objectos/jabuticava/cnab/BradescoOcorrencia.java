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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class BradescoOcorrencia extends OcorrenciaCodigoPadrao {

  public BradescoOcorrencia(int codigo, String descricao, MotivoParser motivoParser) {
    super(codigo, descricao, motivoParser);
  }

  @Override
  Banco getBanco() {
    return Banco.BRADESCO;
  }

  @Override
  public final OcorrenciaTipo getTipo() {
    // 02..Entrada Confirmada
    // 03..Entrada Rejeitada
    // 06..Liquidação normal
    // 09..Baixado Automat. via Arquivo
    // 10..Baixado conforme instruções da Agência
    // 11..Em Ser - Arquivo de Títulos pendentes
    // 12..Abatimento Concedido
    // 13..Abatimento Cancelado
    // 14..Vencimento Alterado
    // 15..Liquidação em Cartório
    // 16..Título Pago em Cheque – Vinculado
    // 17..Liquidação após baixa ou Título não registrado
    // 18..Acerto de Depositária
    // 19..Confirmação Receb. Inst. de Protesto
    // 20..Confirmação Recebimento Instrução Sustação de Protesto
    // 22..Título Com Pagamento Cancelado
    // 21..Acerto do Controle do Participante
    // 23..Entrada do Título em Cartório
    // 24..Entrada rejeitada por CEP Irregular
    // 27..Baixa Rejeitada
    // 28..Débito de tarifas/custas
    // 30..Alteração de Outros Dados Rejeitados
    // 32..Instrução Rejeitada
    // 33..Confirmação Pedido Alteração Outros Dados
    // 34..Retirado de Cartório e Manutenção Carteira
    // 35..Desagendamento do débito automático
    // 68..Acerto dos dados do rateio de Crédito
    // 69..Cancelamento dos dados do rateio
    switch (codigo) {
    case 2:
      return OcorrenciaTipo.ENTRADA_CONFIRMADA;
    case 3:
      return OcorrenciaTipo.ENTRADA_REJEITADA;
    case 6:
      return OcorrenciaTipo.LIQUIDACAO_NORMAL;
    case 12:
      return OcorrenciaTipo.ABATIMENTO_CONCEDIDO;
    case 13:
      return OcorrenciaTipo.ABATIMENTO_CANCELADO;
    case 14:
      return OcorrenciaTipo.VENCIMENTO_ALTERADO;
    case 15:
      return OcorrenciaTipo.LIQUIDACAO_CARTORIO;
    case 19:
      return OcorrenciaTipo.PROTESTO_CONFIRMADO;
    case 33:
      return OcorrenciaTipo.ALTERACAO_OUTROS_DADOS;
    default:
      return OcorrenciaTipo.DESCONHECIDA;
    }
  }

}