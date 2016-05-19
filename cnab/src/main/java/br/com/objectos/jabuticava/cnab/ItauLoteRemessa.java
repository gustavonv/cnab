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

import java.time.LocalDate;

import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cep;
import br.com.objectos.jabuticava.cnab.remessa.Comando;
import br.com.objectos.jabuticava.cnab.remessa.EspecieDeTitulo;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
interface ItauLoteRemessa extends BancoKey {

  CnabKey<ItauLoteRemessa, String> idDoRegistro();
  CnabKey<ItauLoteRemessa, Integer> codigoDeInscricao();
  CnabKey<ItauLoteRemessa, CadastroRFB> numeroDeInscricao();
  CnabKey<ItauLoteRemessa, Integer> agencia();
  CnabKey<ItauLoteRemessa, String> zeros();
  CnabKey<ItauLoteRemessa, Integer> conta();
  CnabKey<ItauLoteRemessa, Integer> dac();
  CnabKey<ItauLoteRemessa, String> brancos();
  CnabKey<ItauLoteRemessa, Integer> instrucaoCancelada();
  CnabKey<ItauLoteRemessa, String> usoDaEmpresa();
  CnabKey<ItauLoteRemessa, Long> nossoNumero();
  CnabKey<ItauLoteRemessa, Double> quantidadeMoeda();
  CnabKey<ItauLoteRemessa, Integer> carteiraNumero();
  CnabKey<ItauLoteRemessa, String> usoDoBanco();
  CnabKey<ItauLoteRemessa, String> carteiraCodigo();
  CnabKey<ItauLoteRemessa, Comando> comando();
  CnabKey<ItauLoteRemessa, String> numeroDocumento();
  CnabKey<ItauLoteRemessa, LocalDate> vencimento();
  CnabKey<ItauLoteRemessa, Double> valorTitulo();
  CnabKey<ItauLoteRemessa, String> codigoBanco();
  CnabKey<ItauLoteRemessa, String> agenciaCobradora();
  CnabKey<ItauLoteRemessa, EspecieDeTitulo> especie();
  CnabKey<ItauLoteRemessa, Boolean> aceite();
  CnabKey<ItauLoteRemessa, LocalDate> emissao();
  CnabKey<ItauLoteRemessa, Integer> instrucao1();
  CnabKey<ItauLoteRemessa, Integer> instrucao2();
  CnabKey<ItauLoteRemessa, Double> moraDia();
  CnabKey<ItauLoteRemessa, LocalDate> descontoAte();
  CnabKey<ItauLoteRemessa, Double> valorDesconto();
  CnabKey<ItauLoteRemessa, Double> valorIOF();
  CnabKey<ItauLoteRemessa, Double> valorAbatimento();
  CnabKey<ItauLoteRemessa, Integer> sacadoInscricaoTipo();
  CnabKey<ItauLoteRemessa, CadastroRFB> sacadoInscricaoNumero();
  CnabKey<ItauLoteRemessa, String> sacadoNome();
  CnabKey<ItauLoteRemessa, String> brancos2();
  CnabKey<ItauLoteRemessa, String> sacadoLogradouro();
  CnabKey<ItauLoteRemessa, String> sacadoBairro();
  CnabKey<ItauLoteRemessa, Cep> sacadoCep();
  CnabKey<ItauLoteRemessa, String> sacadoCidade();
  CnabKey<ItauLoteRemessa, String> sacadoEstado();
  CnabKey<ItauLoteRemessa, String> sacadorAvalista();
  CnabKey<ItauLoteRemessa, String> brancos3();
  CnabKey<ItauLoteRemessa, LocalDate> dataMora();
  CnabKey<ItauLoteRemessa, Integer> prazo();
  CnabKey<ItauLoteRemessa, String> brancos4();
  CnabKey<ItauLoteRemessa, Integer> seqRegistro();

}