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

import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cep;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
interface CnabLoteRemessa<K extends CnabLoteRemessa<K>> extends BancoKey {

  CnabKey<K, String> idDoRegistro();

  CnabKey<K, Integer> contaCorrente();

  CnabKey<K, RemessaEnum> tipoDeInscricaoDoSacado();

  CnabKey<K, Integer> zeros();

  CnabKey<K, String> brancos();

  CnabKey<K, String> numeroDoDocumento();

  CnabKey<K, Double> valorIOF();

  CnabKey<K, Double> valorAbatimento();

  CnabKey<K, Double> valorDoTitulo();

  CnabKey<K, Double> valorCobradoPorAtraso();

  CnabKey<K, Double> valorDoDesconto();

  CnabKey<K, LocalDate> vencimentoDoTitulo();

  CnabKey<K, LocalDate> emissaoDoTitulo();

  CnabKey<K, LocalDate> limiteParaConcessaoDeDesconto();

  CnabKey<K, String> nomeDoSacado();

  CnabKey<K, CadastroRFB> numeroDeInscricaoDoSacado();

  CnabKey<K, Cep> cep();

  CnabKey<K, String> sacadoAvalista();

  CnabKey<K, Integer> numeroSequencialDoRegistro();

}