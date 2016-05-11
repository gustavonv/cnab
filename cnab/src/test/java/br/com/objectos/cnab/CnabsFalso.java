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

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.common.base.Throwables;
import com.google.common.io.Resources;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CnabsFalso {

  public static final MiniCnab HEADER_01 = cnabAt("/HEADER-01.txt");

  public static final MiniCnab RETORNO_237_01 = cnabAt("/237-01.txt");

  public static final MiniCnab RETORNO_341_01 = cnabAt("/341-01.txt");

  public static final MiniCnab RETORNO_341_02 = cnabAt("/341-02.txt");

  private CnabsFalso() {
  }

  private static MiniCnab cnabAt(String filename) {
    try {
      URL url = Resources.getResource(CnabsFalso.class, filename);
      File file = new File(url.toURI());
      return new MiniCnab(file);
    } catch (URISyntaxException e) {
      throw Throwables.propagate(e);
    }
  }

}