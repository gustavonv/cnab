/*
 * Copyright 2016 Objectos, Fábrica de Software LTDA.
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

import br.com.objectos.flat.FlatRecord;
import br.com.objectos.flat.LocalDatePattern;
import br.com.objectos.flat.TextOption;
import br.com.objectos.flat.pojo.BooleanFormat;
import br.com.objectos.flat.pojo.CustomFormat;
import br.com.objectos.flat.pojo.DecimalFormat;
import br.com.objectos.flat.pojo.Fill;
import br.com.objectos.flat.pojo.Fixed;
import br.com.objectos.flat.pojo.FlatEnumFormat;
import br.com.objectos.flat.pojo.IntegerFormat;
import br.com.objectos.flat.pojo.LocalDateFormat;
import br.com.objectos.flat.pojo.Text;
import br.com.objectos.flat.pojo.WhenZero;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.Cep;
import br.com.objectos.pojo.Pojo;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Pojo
abstract class RemessaTransacao implements FlatRecord {

  @Fixed("1")
  abstract String id();

  @IntegerFormat(length = 5)
  @WhenZero("     ")
  abstract int agencia();

  @IntegerFormat(length = 0)
  @WhenZero(" ")
  abstract int agenciaDigito();

  @IntegerFormat(length = 5)
  @WhenZero("     ")
  abstract int razaoContaCorrente();

  @IntegerFormat(length = 7)
  @WhenZero("       ")
  abstract int contaCorrente();

  @IntegerFormat(length = 1)
  @WhenZero(" ")
  abstract int contaCorrenteDigito();

  @Text(length = 17)
  abstract String identificacaoEmpresa();

  @Text(length = 25)
  abstract String usoDaEmpresa();

  @Fixed("237")
  abstract String codigoDoBanco();

  @BooleanFormat(trueValue = "2", falseValue = "0")
  abstract boolean multa();

  @DecimalFormat(precision = 4, scale = 2)
  abstract double percentualMulta();

  @Text(length = 12)
  abstract String identificacaoTituloBanco();

  @DecimalFormat(precision = 10, scale = 2)
  abstract double descontoBonificacaoPorDia();

  @IntegerFormat(length = 1)
  abstract int condicaoParaEmissaoDeCobranca();

  @BooleanFormat(trueValue = "S", falseValue = "N")
  abstract boolean debitoAutomatico();

  @Fill(character = ' ', length = 10)
  abstract String idDaOperacaoNoBanco();

  @BooleanFormat(trueValue = "R", falseValue = " ")
  abstract boolean rateiroCredito();

  @FlatEnumFormat(length = 1)
  abstract EnderecamentoDebitoAutomatico enderecamentoParaAvisoDeDebito();

  @Fill(character = ' ', length = 2)
  abstract String brancos();

  @FlatEnumFormat(length = 2)
  abstract br.com.objectos.cnab.Comando ocorrencia();

  @Text(length = 10)
  abstract String numeroDoDocumento();

  @LocalDateFormat(LocalDatePattern.YYMMDD)
  abstract LocalDate vencimentoDoTitulo();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double valorDoTitulo();

  @Fixed("000")
  abstract String bancoEncarregadoDaCobranca();

  @Fixed("00000")
  abstract String agenciaDepositaria();

  @FlatEnumFormat(length = 2)
  abstract Especie especieDeTitulo();

  @BooleanFormat(trueValue = "A", falseValue = "N")
  abstract boolean aceite();

  @LocalDateFormat(LocalDatePattern.YYMMDD)
  abstract LocalDate emissaoDoTitulo();

  @IntegerFormat(length = 2)
  abstract int primeiraInstrucao();

  @IntegerFormat(length = 2)
  abstract int segundaInstrucao();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double moraDia();

  @LocalDateFormat(LocalDatePattern.YYMMDD)
  abstract LocalDate limiteParaConcessaoDeDesconto();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double valorDesconto();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double valorIof();

  @DecimalFormat(precision = 13, scale = 2)
  abstract double valorAbatimento();

  @FlatEnumFormat(length = 2)
  abstract TipoDeIncricaoDoSacado tipoDeInscricaoDoSacado();

  @CustomFormat(length = 14, formatter = CadastroRfbFormatter.class)
  abstract CadastroRFB numeroDeInscricaoDoSacado();

  @Text(length = 40, options = { TextOption.UPPERCASE })
  abstract String nomeDoSacado();

  @Text(length = 40)
  abstract String enderecoDoSacado();

  @Text(length = 12)
  abstract String primeiraMensagem();

  @CustomFormat(length = 8, formatter = CepFormatter.class)
  abstract Cep cep();

  @Text(length = 60)
  abstract String sacadoAvalista();

  @IntegerFormat(length = 6)
  abstract int numeroSequencialDoRegistro();

  RemessaTransacao() {
  }

}