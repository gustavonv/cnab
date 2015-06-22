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

import static com.google.common.collect.Maps.newLinkedHashMap;

import java.util.Map;
import java.util.Set;

import br.com.objectos.jabuticava.cnab.remessa.Caixa;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cep;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class AbstractRemessaSpec<K extends BancoKey> implements RemessaSpec {

  final Map<CnabKey<?, ?>, ColunaWriter<?>> spec = newLinkedHashMap();

  @Override
  public Set<CnabKey<?, ?>> keySet() {
    return spec.keySet();
  }

  @Override
  public ColunaWriter<?> colunaOf(CnabKey<?, ?> key) {
    return spec.get(key);
  }

  abstract Class<K> getBancoKeyClass();

  AtBuilder at(int pos0, int pos1) {
    return new AtBuilder(pos0, pos1);
  }

  SpecBuilder id(String id) {
    return new SpecBuilder(id);
  }

  class AtBuilder {

    private final int pos0;
    private final int pos1;

    public AtBuilder(int pos0, int pos1) {
      this.pos0 = pos0;
      this.pos1 = pos1;
    }

    public IdBuilder id(String key) {
      return new IdBuilder(pos0, pos1, key);
    }

  }

  class SpecBuilder {

    private final String id;

    public SpecBuilder(String id) {
      this.id = id;
    }

    IdBuilder at(int pos0, int pos1) {
      return new IdBuilder(pos0, pos1, id);
    }

  }

  class IdBuilder {

    private final String id;

    private final int pos0;
    private final int pos1;

    public IdBuilder(int pos0, int pos1, String id) {
      this.pos0 = pos0;
      this.pos1 = pos1;
      this.id = id;
    }

    public ColBuilder<Cep> colunaCep() {
      return put(new ColunaCep(pos0, pos1));
    }

    public ColBuilder<String> colunaAlfanumerica() {
      return put(new ColunaAlfanumerica(pos0, pos1));
    }
    public ColBuilder<String> colunaAlfanumerica(Caixa caixa) {
      return put(new ColunaAlfanumerica(pos0, pos1, caixa));
    }

    public ColBuilder<Boolean> colunaBoolean(String trueText, String falseText) {
      return put(new ColunaBoolean(pos0, pos1, trueText, falseText));
    }

    public ColBuilder<String> colunaBranco() {
      return put(new ColunaBranco(pos0, pos1));
    }

    public ColBuilder<CadastroRFB> colunaCadastroDaEmpresa() {
      return put(new ColunaCadastroDaEmpresa(pos0, pos1));
    }

    public <E extends Enum<E> & RemessaEnum> ColBuilder<E> colunaEnum(Class<E> enumType) {
      return put(new ColunaEnum<E>(pos0, pos1, enumType));
    }
    public <E extends Enum<E> & RemessaEnum> ColBuilder<E> colunaEnum(
        Class<E> enumType, E defaultValue) {
      return put(new ColunaEnum<E>(pos0, pos1, enumType, defaultValue));
    }

    public ColBuilder<String> colunaFixa(Object value) {
      return put(new ColunaFixa(pos0, pos1, value));
    }

    public ColBuilder<Integer> colunaInteger() {
      return put(new ColunaInteger(pos0, pos1));
    }

    public ColBuilder<LocalDate> colunaLocalDate() {
      return put(new ColunaLocalDate(pos0, pos1));
    }

    public ColBuilder<LocalDate> colunaLocalDateVencimentoTitulo() {
      return put(new ColunaLocalDateVencimentoDeTitulo(pos0, pos1));
    }

    public ColBuilder<Long> colunaLong() {
      return put(new ColunaLong(pos0, pos1));
    }

    public ColBuilder<Double> colunaValorFinanceiro() {
      return put(new ColunaValoresFinanceiros(pos0, pos1));
    }

    public ColBuilder<String> colunaVazia() {
      return put(new ColunaVazia(pos0, pos1));
    }

    private <T> ColBuilder<T> put(ColunaWriter<T> coluna) {
      coluna = coluna.withId(id);

      Class<T> type = coluna.getType();

      CnabKey<K, T> key = CnabKey
          .of(getBancoKeyClass())
          .at(pos0 - 1, pos1) // ARGH!
          .id(id)
          .get(type);

      spec.put(key, coluna);

      return new ColBuilder<T>(key);
    }

  }

  class ColBuilder<T> {

    private CnabKey<K, T> key;

    public ColBuilder(CnabKey<K, T> key) {
      this.key = key;
    }

    public ColBuilder<T> opcional() {
      ColunaWriter<?> coluna = spec.remove(key);

      key = key.optional();
      coluna = coluna.optional();

      spec.put(key, coluna);

      return this;
    }

    public CnabKey<K, T> toKey() {
      return key;
    }

  }

}