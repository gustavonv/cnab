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

import java.util.Map;

import br.com.objectos.jabuticava.cnab.bradesco.TipoDeIncricaoDoSacado;
import br.com.objectos.jabuticava.cnab.remessa.Comando;
import br.com.objectos.jabuticava.cnab.remessa.EspecieDeTitulo;
import br.com.objectos.jabuticava.cnab.remessa.TipoDeIdentificacao;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cep;

import org.joda.time.LocalDate;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Deprecated
public class LoteRemessaBradesco extends LoteRemessa {

  private int idDoRegistro;
  private int agenciaDeDebito;
  private String digitoDaAgenciaDeDebito;
  private int razaoDaContaCorrente;
  private int contaCorrente;
  private String digitoDaContaCorrente;
  private String idDaEmpresaCedenteNoBanco;
  private String numeroDeControleDoParticipante;
  private int codigoDoBanco;
  private long idDoTituloNoBanco;
  private String digitoDeAutoConferencia;
  private int descontoDeBonificacaoPorDia;
  private int condicaoParaEmissaoDePapelada;
  private String idParaEmissaoDeDebitoAutomatico;
  private String indicadorDeRateioDeCredito;
  private int enderecamentoParaAtivo;
  private Comando ocorrencia;
  private String numeroDoDocumento;
  private int numeroSequencialDoRegistro;
  private String sacadorAvalista;
  private Cep cep;
  private String primeiraMensagem;
  private String enderecoCompleto;
  private String nomeDoSacado;
  private CadastroRFB cadastroRFBDoSacado;
  private TipoDeIncricaoDoSacado tipoDeIncricaoDoSacado;
  private double valorDeAbatimento;
  private double valorIOF;
  private double valorDoDesconto;
  private LocalDate dataLimiteParaDesconto;
  private double valorCobradoPorAtraso;
  private int segundaInstrucao;
  private int primeiraInstrucao;
  private LocalDate dataDeEmissaoDoTitulo;
  private TipoDeIdentificacao tipoDeIdentificacao;
  private EspecieDeTitulo especieDeTitulo;
  private int agenciaDepositaria;
  private int bancoEncarregadoDaCobranca;
  private double valorDoTitulo;
  private LocalDate dataDeVencimentoDoTitulo;

  public LoteRemessaBradesco(Banco banco, Map<CnabKey<?, ?>, Object> map) {
    super(banco, map);
  }

  @Override
  RemessaSpec getSpec(Modelo modelo) {
    return modelo.getLoteRemessaSpec();
  }

  public LoteRemessaBradesco idDoRegistro(int idDoRegistro) {
    this.idDoRegistro = idDoRegistro;
    return this;
  }

  public LoteRemessaBradesco agenciaDeDebito(int agenciaDeDebito) {
    this.agenciaDeDebito = agenciaDeDebito;
    return this;
  }

  public LoteRemessaBradesco digitoDaAgenciaDeDebito(
      String digitoDaAgenciaDeDebito) {
    this.digitoDaAgenciaDeDebito = digitoDaAgenciaDeDebito;
    return this;
  }

  public LoteRemessaBradesco razaoDaContaCorrente(int razaoDaContaCorrente) {
    this.razaoDaContaCorrente = razaoDaContaCorrente;
    return this;
  }

  public LoteRemessaBradesco contaCorrente(int contaCorrente) {
    this.contaCorrente = contaCorrente;
    return this;
  }

  public LoteRemessaBradesco digitoDaContaCorrente(
      String digitoDaContaCorrente) {
    this.digitoDaContaCorrente = digitoDaContaCorrente;
    return this;
  }

  public LoteRemessaBradesco idDaEmpresaCedenteNoBanco(
      String idDaEmpresaCedenteNoBanco) {
    this.idDaEmpresaCedenteNoBanco = idDaEmpresaCedenteNoBanco;
    return this;
  }

  public LoteRemessaBradesco numeroDeControleDoParticipante(
      String numeroDeControleDoParticipante) {
    this.numeroDeControleDoParticipante = numeroDeControleDoParticipante;
    return this;
  }

  public LoteRemessaBradesco codigoDoBanco(int codigoDoBanco) {
    this.codigoDoBanco = codigoDoBanco;
    return this;
  }

  public LoteRemessaBradesco idDoTituloNoBanco(long idDoTituloNoBanco) {
    this.idDoTituloNoBanco = idDoTituloNoBanco;
    return this;
  }

  public LoteRemessaBradesco digitoDeAutoConferencia(String digitoDeAutoConferencia) {
    this.digitoDeAutoConferencia = digitoDeAutoConferencia;
    return this;
  }

  public LoteRemessaBradesco descontoDeBonificacaoPorDia(int descontoDeBonificacaoPorDia) {
    this.descontoDeBonificacaoPorDia = descontoDeBonificacaoPorDia;
    return this;
  }

  public LoteRemessaBradesco condicaoParaEmissaoDePapelada(int condicaoParaEmissaoDePapelada) {
    this.condicaoParaEmissaoDePapelada = condicaoParaEmissaoDePapelada;
    return this;
  }

  public LoteRemessaBradesco idParaEmissaoDeDebitoAutomatico(String idParaEmissaoDeDebitoAutomatico) {
    this.idParaEmissaoDeDebitoAutomatico = idParaEmissaoDeDebitoAutomatico;
    return this;
  }

  public LoteRemessaBradesco indicadorDeRateioDeCredito(String indicadorDeRateioDeCredito) {
    this.indicadorDeRateioDeCredito = indicadorDeRateioDeCredito;
    return this;
  }

  public LoteRemessaBradesco enderecamentoParaAvivo(int enderecamentoParaAtivo) {
    this.enderecamentoParaAtivo = enderecamentoParaAtivo;
    return this;
  }

  public LoteRemessaBradesco identificacaoDeOcorrencia(Comando ocorrencia) {
    this.ocorrencia = ocorrencia;
    return this;
  }

  public LoteRemessaBradesco numeroDoDocumento(String numeroDoDocumento) {
    this.numeroDoDocumento = numeroDoDocumento;
    return this;
  }

  public LoteRemessaBradesco numeroSequencialDoRegistro(int numeroSequencialDoRegistro) {
    this.numeroSequencialDoRegistro = numeroSequencialDoRegistro;
    return this;
  }

  public LoteRemessaBradesco sacadorAvalista(String sacadorAvalista) {
    this.sacadorAvalista = sacadorAvalista;
    return this;
  }

  public LoteRemessaBradesco cep(Cep cep) {
    this.cep = cep;
    return this;
  }

  public LoteRemessaBradesco primeiraMensagem(String primeiraMensagem) {
    this.primeiraMensagem = primeiraMensagem;
    return this;
  }

  public LoteRemessaBradesco enderecoCompleto(String enderecoCompleto) {
    this.enderecoCompleto = enderecoCompleto;
    return this;
  }

  public LoteRemessaBradesco nomeDoSacado(String nomeDoSacado) {
    this.nomeDoSacado = nomeDoSacado;
    return this;
  }

  public LoteRemessaBradesco cadastroRFBDoSacado(CadastroRFB cadastroRFBDoSacado) {
    this.cadastroRFBDoSacado = cadastroRFBDoSacado;
    return this;
  }

  public LoteRemessaBradesco tipoDeIncricaoDoSacado(TipoDeIncricaoDoSacado tipoDeIncricaoDoSacado) {
    this.tipoDeIncricaoDoSacado = tipoDeIncricaoDoSacado;
    return this;
  }

  public LoteRemessaBradesco valorDeAbatimento(double valorDeAbatimento) {
    this.valorDeAbatimento = valorDeAbatimento;
    return this;
  }

  public LoteRemessaBradesco valorIOF(double valorIOF) {
    this.valorIOF = valorIOF;
    return this;
  }

  public LoteRemessaBradesco valorDoDesconto(double valorDoDesconto) {
    this.valorDoDesconto = valorDoDesconto;
    return this;
  }

  public LoteRemessaBradesco dataLimiteParaDesconto(LocalDate dataLimiteParaDesconto) {
    this.dataLimiteParaDesconto = dataLimiteParaDesconto;
    return this;
  }

  public LoteRemessaBradesco valorCobradoPorAtraso(double valorCobradoPorAtraso) {
    this.valorCobradoPorAtraso = valorCobradoPorAtraso;
    return this;
  }

  public LoteRemessaBradesco segundaInstrucao(int segundaInstrucao) {
    this.segundaInstrucao = segundaInstrucao;
    return this;
  }

  public LoteRemessaBradesco primeiraInstrucao(int primeiraInstrucao) {
    this.primeiraInstrucao = primeiraInstrucao;
    return this;
  }

  public LoteRemessaBradesco dataDeEmissaoDoTitulo(LocalDate dataDeEmissaoDoTitulo) {
    this.dataDeEmissaoDoTitulo = dataDeEmissaoDoTitulo;
    return this;
  }

  public LoteRemessaBradesco tipoDeIdentificacao(TipoDeIdentificacao tipoDeIdentificacao) {
    this.tipoDeIdentificacao = tipoDeIdentificacao;
    return this;
  }

  public LoteRemessaBradesco especieDeTitulo(EspecieDeTitulo especieDeTitulo) {
    this.especieDeTitulo = especieDeTitulo;
    return this;
  }

  public LoteRemessaBradesco agenciaDepositaria(int agenciaDepositaria) {
    this.agenciaDepositaria = agenciaDepositaria;
    return this;
  }

  public LoteRemessaBradesco bancoEncarregadoDaCobranca(int bancoEncarregadoDaCobranca) {
    this.bancoEncarregadoDaCobranca = bancoEncarregadoDaCobranca;
    return this;
  }

  public LoteRemessaBradesco valorDoTitulo(double valorDoTitulo) {
    this.valorDoTitulo = valorDoTitulo;
    return this;
  }

  public LoteRemessaBradesco dataDeVencimentoDoTitulo(LocalDate dataDeVencimentoDoTitulo) {
    this.dataDeVencimentoDoTitulo = dataDeVencimentoDoTitulo;
    return this;
  }

  public int getIdDoRegistro() {
    return idDoRegistro;
  }

  public int getAgenciaDeDebito() {
    return agenciaDeDebito;
  }

  public String getDigitoDaAgenciaDeDebito() {
    return digitoDaAgenciaDeDebito;
  }

  public int getRazaoDaContaCorrente() {
    return razaoDaContaCorrente;
  }

  public int getContaCorrente() {
    return contaCorrente;
  }

  public String getDigitoDaContaCorrente() {
    return digitoDaContaCorrente;
  }

  public String getIdDaEmpresaCedenteNoBanco() {
    return idDaEmpresaCedenteNoBanco;
  }

  public String getNumeroDeControleDoParticipante() {
    return numeroDeControleDoParticipante;
  }

  public int getCodigoDoBanco() {
    return codigoDoBanco;
  }

  public long getIdDoTituloNoBanco() {
    return idDoTituloNoBanco;
  }

  public String getDigitoDeAutoConferencia() {
    return digitoDeAutoConferencia;
  }

  public int getDescontoDeBonificacaoPorDia() {
    return descontoDeBonificacaoPorDia;
  }

  public int getCondicaoParaEmissaoDePapelada() {
    return condicaoParaEmissaoDePapelada;
  }

  public String getIdParaEmissaoDeDebitoAutomatico() {
    return idParaEmissaoDeDebitoAutomatico;
  }

  public String getIndicadorDeRateioDeCredito() {
    return indicadorDeRateioDeCredito;
  }

  public int getEnderecamentoParaAviso() {
    return enderecamentoParaAtivo;
  }

  public Comando getOcorrencia() {
    return ocorrencia;
  }

  public String getNumeroDoDocumento() {
    return numeroDoDocumento;
  }

  public LocalDate getDataDeVencimentoDoTitulo() {
    return dataDeVencimentoDoTitulo;
  }

  public double getValorDoTitulo() {
    return valorDoTitulo;
  }

  public int getBancoEncarregadoDaCobranca() {
    return bancoEncarregadoDaCobranca;
  }

  public int getAgenciaDepositaria() {
    return agenciaDepositaria;
  }

  public EspecieDeTitulo getEspecieDeTitulo() {
    return especieDeTitulo;
  }

  public TipoDeIdentificacao getTipoDeIdentificacao() {
    return tipoDeIdentificacao;
  }

  public LocalDate getDataDeEmissaoDoTitulo() {
    return dataDeEmissaoDoTitulo;
  }

  public int getPrimeiraInstrucao() {
    return primeiraInstrucao;
  }

  public int getSegundaInstrucao() {
    return segundaInstrucao;
  }

  public double getValorCobradoPorAtraso() {
    return valorCobradoPorAtraso;
  }

  public LocalDate getDataLimiteParaDesconto() {
    return dataLimiteParaDesconto;
  }

  public double getValorDoDesconto() {
    return valorDoDesconto;
  }

  public double getValorIOF() {
    return valorIOF;
  }

  public double getValorDeAbatimento() {
    return valorDeAbatimento;
  }

  public TipoDeIncricaoDoSacado getTipoDeIncricaoDoSacado() {
    return tipoDeIncricaoDoSacado;
  }

  public CadastroRFB getCadastroRFBDoSacado() {
    return cadastroRFBDoSacado;
  }

  public String getNomeDoSacado() {
    return nomeDoSacado;
  }

  public String getEnderecoCompleto() {
    return enderecoCompleto;
  }

  public String getPrimeiraMensagem() {
    return primeiraMensagem;
  }

  public Cep getCep() {
    return cep;
  }

  public String getSacadorAvalista() {
    return sacadorAvalista;
  }

  public int getNumeroSequencialDoRegistro() {
    return numeroSequencialDoRegistro;
  }

}