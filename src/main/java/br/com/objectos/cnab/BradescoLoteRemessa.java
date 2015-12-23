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

import java.time.LocalDate;

import br.com.objectos.br.CadastroRFB;
import br.com.objectos.br.Cep;
import br.com.objectos.cnab.bradesco.TipoDeIncricaoDoSacado;
import br.com.objectos.cnab.remessa.EnderecamentoDebitoAutomatico;
import br.com.objectos.cnab.remessa.EspecieDeTitulo;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
interface BradescoLoteRemessa extends BancoKey {

  CnabKey<BradescoLoteRemessa, String> idDoRegistro();

  CnabKey<BradescoLoteRemessa, Integer> agenciaDeDebito();

  CnabKey<BradescoLoteRemessa, String> digitoDaAgenciaDeDebito();

  CnabKey<BradescoLoteRemessa, Integer> razaoDaContaCorrente();

  CnabKey<BradescoLoteRemessa, Integer> contaCorrente();

  CnabKey<BradescoLoteRemessa, String> digitoDaContaCorrente();

  CnabKey<BradescoLoteRemessa, String> idDoCedenteNoBanco();

  CnabKey<BradescoLoteRemessa, String> numeroDeControleDoParticipante();

  CnabKey<BradescoLoteRemessa, Integer> codigoDoBanco();

  CnabKey<BradescoLoteRemessa, String> zeros();

  CnabKey<BradescoLoteRemessa, Long> idDoTituloNoBanco();

  // CnabKey<BradescoLoteRemessa, String> digitoDeAutoConferencia();

  CnabKey<BradescoLoteRemessa, Double> descontoBonificacaoPorDia();

  CnabKey<BradescoLoteRemessa, Integer> condicaoParaEmissaoDeCobranca();

  CnabKey<BradescoLoteRemessa, String> idParaEmissaoDeDebito();

  CnabKey<BradescoLoteRemessa, Boolean> indicadorRateioCredito();

  CnabKey<BradescoLoteRemessa, String> idDaOperacaoNoBanco();

  CnabKey<BradescoLoteRemessa, EnderecamentoDebitoAutomatico> enderecamentoParaAvisoDeDebito();

  CnabKey<BradescoLoteRemessa, String> brancos();

  CnabKey<BradescoLoteRemessa, br.com.objectos.cnab.remessa.Comando> comando();

  CnabKey<BradescoLoteRemessa, String> numeroDoDocumento();

  CnabKey<BradescoLoteRemessa, LocalDate> vencimentoDoTitulo();

  CnabKey<BradescoLoteRemessa, Double> valorDoTitulo();

  CnabKey<BradescoLoteRemessa, String> bancoEncarregadoDaCobranca();

  CnabKey<BradescoLoteRemessa, String> agenciaDepositaria();

  CnabKey<BradescoLoteRemessa, EspecieDeTitulo> especieDeTitulo();

  CnabKey<BradescoLoteRemessa, Boolean> aceite();

  CnabKey<BradescoLoteRemessa, LocalDate> emissaoDoTitulo();

  CnabKey<BradescoLoteRemessa, Integer> primeiraInstrucao();

  CnabKey<BradescoLoteRemessa, Integer> segundaInstrucao();

  CnabKey<BradescoLoteRemessa, Double> valorCobradoPorAtraso();

  CnabKey<BradescoLoteRemessa, LocalDate> limiteParaConcessaoDeDesconto();

  CnabKey<BradescoLoteRemessa, Double> valorDesconto();

  CnabKey<BradescoLoteRemessa, Double> valorIOF();

  CnabKey<BradescoLoteRemessa, Double> valorAbatimento();

  CnabKey<BradescoLoteRemessa, TipoDeIncricaoDoSacado> tipoDeInscricaoDoSacado();

  CnabKey<BradescoLoteRemessa, CadastroRFB> numeroDeInscricaoDoSacado();

  CnabKey<BradescoLoteRemessa, String> nomeDoSacado();

  CnabKey<BradescoLoteRemessa, String> enderecoDoSacado();

  CnabKey<BradescoLoteRemessa, String> primeiraMensagem();

  CnabKey<BradescoLoteRemessa, Cep> cep();

  CnabKey<BradescoLoteRemessa, String> sacadoAvalista();

  CnabKey<BradescoLoteRemessa, Integer> numeroSequencialDoRegistro();

}