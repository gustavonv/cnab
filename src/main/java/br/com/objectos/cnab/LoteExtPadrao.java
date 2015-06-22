/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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

import static br.com.objectos.cnab.WayCnab.lote;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class LoteExtPadrao implements LoteExt {

  final Lote lote;

  final Banco banco;

  final OcorrenciaCodigo ocorrencia;

  final Motivo motivo;

  LoteExtPadrao(Lote lote, OcorrenciaEvento evento) {
    this.lote = lote;
    this.banco = lote.getBanco();
    this.ocorrencia = evento.getOcorrencia();
    this.motivo = evento.getMotivo();
  }

  public static List<LoteExt> transform(List<Lote> lotes) {
    List<List<LoteExt>> lists = Lists.transform(lotes, new ToLoteExt());
    Iterable<LoteExt> exts = Iterables.concat(lists);
    return ImmutableList.copyOf(exts);
  }

  private static class ToLoteExt implements Function<Lote, List<LoteExt>> {
    @Override
    public List<LoteExt> apply(Lote lote) {
      Ocorrencia ocorrencia = lote.get(WayCnab.lote().ocorrencia());
      List<OcorrenciaEvento> eventos = ocorrencia.asEventos();
      return Lists.transform(eventos, new FromEvento(lote));
    }
  }

  private static class FromEvento implements Function<OcorrenciaEvento, LoteExt> {

    private final Lote lote;

    public FromEvento(Lote lote) {
      this.lote = lote;
    }

    @Override
    public LoteExt apply(OcorrenciaEvento input) {
      return new LoteExtPadrao(lote, input);
    }

  }

  @Override
  public <K extends BancoKey & LoteKey, V> V get(CnabKey<K, V> key) {
    return lote.get(key);
  }

  @Override
  public Banco getBanco() {
    return banco;
  }

  @Override
  public RegistroTipo getTipo() {
    return lote.getTipo();
  }

  @Override
  public OcorrenciaCodigo getOcorrencia() {
    return ocorrencia;
  }

  @Override
  public Motivo getMotivo() {
    return motivo;
  }

  @Override
  public String getUsoDaEmpresa() {
    return lote.get(lote().usoDaEmpresa());
  }

  @Override
  public String getNumeroCobranca() {
    return banco.getNumeroCobranca(lote);
  }

  @Override
  public String getNumeroTitulo() {
    return lote.get(lote().numeroDoDocumento());
  }

  @Override
  public LocalDate getDataVencimento() {
    return lote.get(lote().dataDeVencimento());
  }

  @Override
  public LocalDate getDataOcorrencia() {
    return lote.get(lote().dataDeOcorrencia());
  }

  @Override
  public LocalDate getDataCredito() {
    return lote.get(lote().dataDeCredito());
  }

  @Override
  public double getValorNominal() {
    Double val = lote.get(lote().valorTitulo());
    return val.doubleValue();
  }

  @Override
  public double getValorRecebido() {
    return motivo.recebidoDe(lote);
  }

  @Override
  public double getValorJuros() {
    return motivo.jurosDe(lote);
  }

  @Override
  public double getValorDesconto() {
    Double val = lote.get(lote().valorDesconto());
    return val.doubleValue();
  }

  @Override
  public double getValorTarifa() {
    return motivo.tarifaDe(lote);
  }

  @Override
  public int getSeq() {
    Integer val = lote.get(lote().numeroSeqRegistro());
    return val.intValue();
  }

}