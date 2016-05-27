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

import br.com.objectos.flat.FlatWriter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Itau extends Banco {

  private static final Itau INSTANCE = new Itau();

  private Itau() {
  }

  public static Itau instance() {
    return INSTANCE;
  }

  @Override
  public Retorno read(String txt) {
    throw new UnsupportedOperationException();
  }

  @Override
  void writeRemessaTo(Remessa remessa, FlatWriter writer) {
    RemessaItau remessaItau = RemessaItau.builder()
        .header(header(remessa))
        .trxList(trxList(remessa))
        .trailer(trailer(remessa))
        .build();
    remessaItau.writeTo(writer);
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
    ComandoItau comando = ComandoItau.of(cobranca.comando());

    Instrucao instrucao1 = cobranca.instrucao1();
    Instrucao instrucao2 = cobranca.instrucao2();

    int prazo = prazoDe(instrucao1, 0);
    prazo = prazoDe(instrucao2, prazo);

    Sacado sacado = titulo.sacado();
    Endereco endereco = sacado.endereco();

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
        .comando(comando)
        .numero(titulo.numero())
        .vencimento(titulo.vencimento())
        .valor(titulo.valor())
        .especie(titulo.especie())
        .aceite(cobranca.aceite())
        .emissao(titulo.emissao())
        .instrucao1(instrucao1.codigo())
        .instrucao2(instrucao2.codigo())
        .moraDia(cobranca.moraDia())
        .descontoAte()
        .valorDesconto(titulo.valorDesconto())
        .valorIof(titulo.valorIof())
        .valorAbatimento(titulo.valorAbatimento())
        .sacadoInscricao(sacado.cadastroRfb())
        .sacadoNome(sacado.nome())
        .sacadoLogradouro(endereco.logradouro())
        .sacadoBairro(endereco.bairro())
        .sacadoCep(endereco.cep())
        .sacadoCidade(endereco.cidade())
        .sacadoEstado(endereco.estado())
        .sacadorAvalista(titulo.cedente().nome())
        .dataMora()
        .prazo(prazo)
        .seq(seq)
        .build();
  }

  private int prazoDe(Instrucao instrucao, int prazo) {
    int codigo = instrucao.codigo();
    switch (codigo) {
    case 9:
    case 34:
    case 35:
    case 42:
    case 81:
    case 82:
    case 91:
    case 92:
      return instrucao.valor();

    default:
      return prazo;
    }
  }

}