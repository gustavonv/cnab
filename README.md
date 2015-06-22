# objectos :: way :: cnab

Arquivos de retorno e remessa (CNAB / Febraban) para Java (&trade;). Simples.

## Bancos

objectos way-cnab implementa o padrão CNAB 400 da Febrabran para os seguintes bancos:

- Bradesco
- Itaú

## Can Haz Code?

### Retorno

A utilização é bem simples:

```java
File file = // abrir um retorno BRADESCO, por exemplo.
Retorno retorno = WayCnab.retornoDe(file);

List<Lote> lotes = retorno.getLotes();
for (Lote lote : lotes) {
  // look ma!!! type safe!!!
  LocalDate vencimento = lote.get(Bradesco.lote().dataDeVencimento()); 
}
```

## Maven

way-cnab está na central Maven.

```xml
<dependency>
    <groupId>br.com.objectos</groupId>
    <artifactId>way-cnab</artifactId>
    <version>x.y.z</version>
</dependency>
```

## Versões

Estamos trabalhando para atender a especificação SemVer.

Até o lançamento da versão 2.0.0, a API poderá mudar bastante...

# Licença de uso

Copyright 2012 [objectos, fábrica de software LTDA](http://www.objectos.com.br)

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, 
software distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions 
and limitations under the License.