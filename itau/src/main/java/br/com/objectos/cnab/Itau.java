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

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import br.com.objectos.cnab.itau.RemessaItau;
import br.com.objectos.cnab.itau.RemessaItauHeader;
import br.com.objectos.cnab.itau.RemessaItauTrailer;
import br.com.objectos.cnab.itau.RemessaItauTrx;
import br.com.objectos.flat.FlatWriter;
import br.com.objectos.jabuticava.CadastroRFB;
import br.com.objectos.jabuticava.cnab.remessa.EnderecamentoDebitoAutomatico;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Itau implements Banco {

  private static final Itau INSTANCE = new Itau();

  private Itau() {
  }

  public static Itau instance() {
    return INSTANCE;
  }

  @Override
  public String toString(Remessa remessa) {
    StringBuilder str = new StringBuilder();
    try (FlatWriter writer = FlatWriter.of(str)) {
      RemessaItau remessaItau = RemessaItau.builder()
          .header(header(remessa))
          .trxList(trxList(remessa))
          .trailer(trailer(remessa))
          .build();
      remessaItau.writeTo(writer);
    }
    return str.toString();
  }

  private RemessaItauHeader header(Remessa remessa) {
    Agencia agencia = remessa.agencia();
    Conta conta = remessa.conta();
    Empresa empresa = remessa.empresa();
    return RemessaItauHeader.builder()
        .agencia(agencia.numero())
        .conta(conta.numero())
        .contaDigito(conta.digito())
        .nomeEmpresa(empresa.razaoSocial())
        .dataGeracao(remessa.data())
        .build();
  }

  private List<RemessaItauTrx> trxList(Remessa remessa) {
    AtomicInteger autoInc = new AtomicInteger(2);
    Empresa empresa = remessa.empresa();
    return remessa.cobrancaList()
        .stream()
        .map(c -> toTrx(autoInc.getAndIncrement(), empresa, c))
        .collect(Collectors.toList());
  }

  private RemessaItauTrailer trailer(Remessa remessa) {
    return RemessaItauTrailer.builder()
        .seq(remessa.cobrancaList().size() + 2)
        .build();
  }

  private RemessaItauTrx toTrx(int seq, Empresa empresa, Cobranca cobranca) {
    Titulo titulo = cobranca.titulo();
    InscricaoItau inscricao = InscricaoItau.of(empresa, titulo);

    Agencia agencia = cobranca.agencia();
    Conta conta = cobranca.conta();

    CarteiraItau carteira = CarteiraItau.of(cobranca.carteira());

    return RemessaItauTrx.builder()
        .tipoInscricaoEmpresa(inscricao.tipo)
        .numeroInscricaoEmpresa(inscricao.cadastroRfb)
        .agencia(agencia.numero())
        .conta(conta.numero())
        .contaDigito(conta.digito())
        .instrucaoCancelada(0)
        .usoEmpresa(titulo.usoEmpresa())
        .nossoNumero(titulo.nossoNumero())
        .quantidadeMoeda(0)
        .carteiraNumero(carteira)
        .usoBanco("")
        .carteiraCodigo(carteira)
        .ocorrencia(ocorrencia)
  }

}