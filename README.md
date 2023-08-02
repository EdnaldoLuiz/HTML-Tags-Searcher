 <h1 align="center"> Nuti-desafio-tags</h1>

<h2>Observaçoes:</h2>
<p>existem algumas tags que não são muito conhecidas, mas existem e fazem um conjunto com a tag de svg, alem de outras que so são possiveis com auxilio de frameworks.</p>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/code.png">
</div>

<h2>Estrutura do Projeto:</h2>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/tree.png">
</div>

<h2>Visao geral do Projeto:</h2>
<h3>Formulario de busca</h3>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/form.png">
</div>

<h3>URL passada incorretamente</h3>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/erro.png">
</div>

<h3>Tabela de resultados</h3>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/resultado.png">
</div>

<h2>Código MySQL:</h2>
<h3>Tabelas</h3>
<p> os arquivos das tabelas SQL presentes no projeto, podem ser encontrados em src/main/resources/db/migration/</p>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/tables.png">
</div>

<h3>Consultas</h3>
<p>consulta que retorna todas as tags e suas quantidades econtradas que foram salvas na pesquisa de acordo com a url informada</p>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/select2.png">
</div>

<h2>Código Java:</h2>
<h3>Salvar no banco de dados</h3>
<p>verificar se a URL esta sendo valida, remover os espaços em branco, e caso ela não esteja presente no banco de dados, salvar</p>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/salvar.png">
</div>

<h3>Controller</h3>
<p>valida a URL passada usando o Código acima, adiciona atributos para o thymeleaft identificar e devolve o html de resultado</p>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/post.png">
</div>

<h2>Tabelas hospedadas na nuvem da Railway</h2>
<h3>Tabela de URLs</h3>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/tb_urls.png">
</div>

<h3>Tabela de Tags e suas quantidades</h3>

<div align="center">
    <img width="90%" src="src/main/resources/imgs/tb_tags.png">
</div>

<h2>Principais Bibliotecas para a Solução:</h2>

### JSoup
Bilioteca usada para extrair a quantidade de tags e seus respectivos nomes das URLs informadas

```xml
<dependency>
	<groupId>org.jsoup</groupId>
	<artifactId>jsoup</artifactId>
	<version>1.16.1</version>
</dependency>
```

### Flyway
Bilioteca usada para criar as tabelas do banco de dados dentro da pasta db/migration
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>

<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-mysql</artifactId>
</dependency>
```
### MySQL-connector
Bilioteca usada para conectar o projeto ao MySQL

```xml
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.33</version>
</dependency>
```

### JPA
Bilioteca usada para utilizar as interfaces e anotações ajudando a manipular os dados

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### Thymeleaf
Bilioteca usada para integrar as respostas do controller em páginas html

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

