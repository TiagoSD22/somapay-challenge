# Somapay Challenge

Este projeto foi criado para a participação no processo seletivo da Empresa Somapay. O desafio consistia em desenvolver uma aplicação em Java com Spring Boot que permitisse ciar empresas e funcionarios e utilizando PostgreSQL, modelar em banco de dados tabelas para as referidas entidades e fornecer para o usuário operações de acesso e manipulação desses dados por meio de APIs.

---

# Estrutura do projeto

O projeto está em uma arquitetura REST utilizando o framework Spring Boot para definicoes das APIs.

---

# Endpoints da API

```
/employee-api/create/{companyId} Cria um registro de funcionario e o vincula a uma empresa existente.
```
```
/employee-api/get-by-id/{id} Retorna os dados de um funcionario especificado pelo seu id.
```
```
/employee-api/get-all-employees-by-company/{companyId} Retorna todos os funcionarios de uma dada empresa.
```
```
/employee-api/get-account-balance/{id} Retorna o saldo da conta de um dado funcionario.
```
```
/company-api/transfer-money/{companyId}/{employeeId} Transfere um valor da conta de uma dada empresa para a conta de um dado funcionario
```
```
/company-api/create Cria uma empresa
```
```
/company-api/get-by-id/{id} Obtem os dados de uma empresa especificada pelo seu id.
```
```
/company-api/get-all Obtem uma lista com todas as empresas cadastradas.
```
```
/company-api/get-account-balance/{id} Obtem o saldo da conta de uma dada empresa
```
Para ver a documentação completa da API acesse a url http://localhost:8080/swagger-ui.html apos executar a aplicacao.

---

## Dependências utilizadas

Para a aplicação  foram usadas, principalmente, as dependências:

+ [Java 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
    - Uma das versões mais recentes desta linguagem.
+ [Spring Boot 2.5.2](https://spring.io/projects/spring-boot)
    - Um framework para criacao de APIs REST em Java
+ [Spring Doc penAPI](https://springdoc.org/)
    - Biblioteca para documentacao OpenAPI
Para a camada de banco de dados foi utilizada a seguinte dependência:
+ [PostgreSQL 12](https://www.postgresql.org/)
    - SGBD relacional em uma de suas versões mais atuais.
---

## Execução da aplicação

O projeto foi configurado para execução com Docker Compose.
Para executar utilizando o Docker Compose, primeiramente, é necessário fazer a instalação do [Docker](https://docs.docker.com/), siga as instruções da documentação para instalar a versão mais apropriada da sua distro. Instalado o Docker, precisamos instalar o [Docker Compose](https://docs.docker.com/compose/install/) para gerenciar os containers da aplicação. Após instalá-lo, basta executar o comando docker-compose up --build (**pode precisar de permissão de super usuário**) na pasta fonte do projeto, onde está localizado o arquivo docker-compose.yml e o processo de download/instalação de dependências se dará de forma automática. O processo de build total da aplicação pode levar em torno de 10 a 15 minutos, dependendo da máquina e conexão com a internet. Quando o Docker Compose completar o processo,a aplicação poderá ser acessada a partir de um navegador WEB acessando o endereço **http://localhost:8080**. Observação: certifique-se antes de executar o build da aplicação de que não há nenhuma processo rodando em uma das seguintes portas: **8080,5432**, pois se houver, o comando docker-compose falhará. Dica: caso o endereço do postgreSQL esteja em execução, pare-o com o comando sudo service postgresql restart, caso aconteça o erro de 'endereço 0.0.0.0:5432 already in use' procure o **pid** do processo ouvindo essa porta com o comando sudo ss -nlp | grep 5432 e execute sudo kill -9 <**pid**>