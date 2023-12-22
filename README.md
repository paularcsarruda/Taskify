# Descrição do Projeto

O Taskify é uma API REST desenvolvida com Spring Boot para servir como backend de uma aplicação de gerenciamento de tarefas. Ele oferece recursos para manipulação de usuários, tarefas e projetos, proporcionando uma interface para interação com o banco de dados MySQL.

## Configuração do Ambiente

### Requisitos

Certifique-se de ter as seguintes dependências instaladas em seu ambiente de desenvolvimento:

Java 11+
Maven
MySQL
Instalação

### Clone o repositório:

```git clone https://github.com/alexandresjunior/taskify-api.git```

No terminal, navegue até o diretório do projeto:

```cd taskify-api```


Configure o banco de dados: Certifique-se de que um servidor MySQL esteja em execução e crie um banco de dados chamado "taskify".

```CREATE DATABASE taskify;```


Configure as propriedades do banco de dados: Se for o caso, edite o arquivo src/main/resources/application.properties e ajuste as configurações de conexão com o servidor MySQL:

```spring.datasource.url=jdbc:mysql://localhost:3306/taskify```.
```spring.datasource.username=seu-usuario```.
```spring.datasource.password=sua-senha```.

Execute a aplicação:

```mvn spring-boot:run```

O servidor estará acessível em ```http://localhost:8080``` por padrão.

## Estrutura do Projeto

O projeto é estruturado da seguinte forma:

```com.taskify.api.constants```: Constantes utilizadas na aplicação.
```com.taskify.api.controller```: Controladores para manipular as requisições HTTP.
```com.taskify.api.model```: Modelos de dados para representar Usuários, Tarefas e Projetos.
```com.taskify.api.repository```: Repositórios para interação com o banco de dados.

## Uso da API

A API possui os seguintes **endpoints**:

### Usuários:

POST /usuarios: Cria um novo usuário.
GET /usuarios: Lista todos os usuários.
GET /usuarios/{id}: Obtém informações de um usuário específico.
PUT /usuarios/{id}: Atualiza as informações de um usuário.
DELETE /usuarios/{id}: Exclui um usuário.

### Tarefas:

POST /tarefas: Cria uma nova tarefa.
GET /tarefas: Lista todos as tarefas.
GET /tarefas/{id}: Obtém informações de uma tarefa específica.
PUT /tarefas/{id}: Atualiza as informações de uma tarefa.
DELETE /tarefas/{id}: Exclui uma tarefa.

### Projetos:

POST /projetos: Cria um novo projeto.
GET /projetos: Lista todos os projetos.
GET /projetos/{id}: Obtém informações de um projeto específico.
PUT /projetos/{id}: Atualiza as informações de um projeto.
DELETE /projetos/{id}: Exclui um projeto.

## Colaboração

O projeto foi desenvolvido durante o curso de Java Web com SpringBoot sob a orientação do professor Alexandre Junior da Treina Recife.

Github: ```https://github.com/alexandresjunior```
