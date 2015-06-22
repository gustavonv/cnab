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
package br.com.objectos.jabuticava.cnab.remessa;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.Cpf;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeEmpresaFalso implements Empresa.Construtor {

  private long codigo;

  private CadastroRFB cadastroRFB;

  private String razaoSocial;

  ConstrutorDeEmpresaFalso() {
  }

  @Override
  public Empresa novaInstancia() {
    return new EmpresaCnab(this);
  }

  public ConstrutorDeEmpresaFalso codigo(long codigo) {
    this.codigo = codigo;
    return this;
  }

  public ConstrutorDeEmpresaFalso cpf(long cpf) {
    this.cadastroRFB = Cpf.valueOf(cpf);
    return this;
  }
  public ConstrutorDeEmpresaFalso cnpj(long cnpj) {
    this.cadastroRFB = Cnpj.valueOf(cnpj);
    return this;
  }

  public ConstrutorDeEmpresaFalso razaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
    return this;
  }

  @Override
  public long getCodigo() {
    return codigo;
  }

  @Override
  public CadastroRFB getCadastroRFB() {
    return cadastroRFB;
  }

  @Override
  public String getRazaoSocial() {
    return razaoSocial;
  }

}