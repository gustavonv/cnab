/*
 * Copyright 2015 Objectos, Fábrica de Software LTDA.
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
import java.time.format.DateTimeFormatter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
enum LocalDateFormat {

  DD_MM_YY("ddMMyy");

  private final DateTimeFormatter formatter;

  private LocalDateFormat(String pattern) {
    formatter = DateTimeFormatter.ofPattern(pattern);
  }

  public LocalDate parse(String input) {
    try {
      return LocalDate.parse(input, formatter);
    } catch (IllegalArgumentException e) {
      return null;
    } catch (NullPointerException e) {
      return null;
    }
  }

  public String format(LocalDate date) {
    return date != null ? formatter.format(date) : "";
  }

}