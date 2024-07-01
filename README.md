# FórumHub - API REST com Spring

## Descrição

Este é o FórumHub, um projeto de API REST desenvolvido com Spring para gerenciar tópicos de discussão em um fórum. A API permite a criação, listagem, atualização e exclusão de tópicos, usuários, cursos e respostas, seguindo as melhores práticas do modelo REST. O FórumHub inclui validações de regras de negócio e implementa um banco de dados relacional para a persistência das informações, além de um serviço de autenticação e autorização para garantir a segurança dos dados.

## Funcionalidades

### Tópicos

- **Criar um novo tópico**: Permite aos usuários criar novos tópicos.
- **Listar todos os tópicos**: Recupera e exibe todos os tópicos criados.
- **Mostrar um tópico específico**: Exibe os detalhes de um tópico específico.
- **Atualizar um tópico**: Permite a atualização das informações de um tópico.
- **Eliminar um tópico**: Remove um tópico do sistema.

### Usuários

- **Registrar um novo usuário**: Permite o registro de novos usuários.
- **Listar todos os usuários**: Recupera e exibe todos os usuários cadastrados.
- **Mostrar um usuário específico**: Exibe os detalhes de um usuário específico.
- **Atualizar um usuário**: Permite a atualização das informações de um usuário.
- **Eliminar um usuário**: Remove um usuário do sistema.

### Cursos

- **Registrar um novo curso**: Permite o registro de novos cursos.
- **Listar todos os cursos**: Recupera e exibe todos os cursos cadastrados.
- **Mostrar um curso específico**: Exibe os detalhes de um curso específico.
- **Atualizar um curso**: Permite a atualização das informações de um curso.
- **Eliminar um curso**: Remove um curso do sistema.

### Respostas

- **Registrar uma nova resposta**: Permite aos usuários registrar novas respostas em tópicos específicos.
- **Listar todas as respostas de um tópico**: Recupera e exibe todas as respostas associadas a um tópico específico.
- **Mostrar uma resposta específica**: Exibe os detalhes de uma resposta específica.
- **Atualizar uma resposta**: Permite a atualização das informações de uma resposta.
- **Eliminar uma resposta**: Remove uma resposta do sistema.

### Tecnologias Utilizadas

- **Spring Boot Starter Data JPA**: Facilita o acesso e a persistência de dados usando o JPA (Java Persistence API).
- **Spring Boot Starter Security**: Fornece suporte para autenticação e autorização na aplicação.
- **Spring Boot Starter Validation**: Integra validações de entrada baseadas em anotações.
- **Spring Boot Starter Web**: Suporte para desenvolvimento de aplicativos web usando Spring MVC.
- **Flyway Core**: Gerencia migrações de banco de dados de forma programática.
- **Flyway MySQL**: Suporte específico para integração do Flyway com o MySQL.
- **Spring Boot DevTools**: Ferramentas de desenvolvimento que melhoram a experiência de desenvolvimento Spring Boot.
- **MySQL Connector/J**: Driver JDBC para comunicação com bancos de dados MySQL.
- **Lombok**: Biblioteca que simplifica a criação de classes Java reduzindo a verbosidade do código.
- **Spring Boot Starter Test**: Suporte para testes na aplicação Spring Boot.
- **Spring Security Test**: Suporte para testes de segurança na aplicação Spring.
- **Java JWT (com.auth0:java-jwt)**: Biblioteca para criação e validação de tokens JWT (JSON Web Token).
- **Springdoc OpenAPI Starter WebMvc UI**: Geração automática de documentação OpenAPI (anteriormente Swagger) para APIs Spring MVC.


## Configuração

 Para executar o projeto localmente, siga os passos abaixo:

1. Clone o repositório:

   `git clone https://github.com/LuisBarrichello/Challenge-API-REST-ForumHub.git`

2. Navegue até o diretório do projeto:

`cd forumhub`

3. Configure o banco de dados no arquivo application.properties:

```
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
```

4. Execute a aplicação:

`./mvnw spring-boot:run`

## Autenticação

A API utiliza autenticação baseada em tokens JWT. Para acessar as rotas protegidas, é necessário obter um token JWT através do endpoint de login `/login` e incluir o token no header de autorização das requisições subsequentes.

## Endpoints

Aqui estão alguns dos principais endpoints da API:

### Endpoint de Autenticação

- **POST /login:** Endpoint para autenticar um usuário e obter um token JWT válido.

### Tópicos

- **POST /topics:** Cria um novo tópico.
- **GET /topics:** Lista todos os tópicos.
- **GET /topics/{id}:** Mostra um tópico específico.
- **PUT /topics/{id}:** Atualiza um tópico.
- **DELETE /topics/{id}:** Deleta um tópico.

### Usuários

- **POST /users/register:** Registra um novo usuário.
- **GET /users:** Lista todos os usuários.
- **GET /users/{id}:** Mostra um usuário específico.
- **PUT /users/{id}:** Atualiza um usuário.
- **DELETE /users/{id}:** Deleta um usuário.

### Cursos

- **POST /courses:** Registra um novo curso.
- **GET /courses:** Lista todos os cursos.
- **GET /courses/{id}:** Mostra um curso específico.
- **PUT /courses/{id}:** Atualiza um curso.
- **DELETE /courses/{id}:** Deleta um curso.

### Respostas

- **POST /topics/{idTopic}/replies:** Registra uma nova resposta em um tópico.
- **GET /topics/{idTopic}/replies:** Lista todas as respostas de um tópico.
- **GET /topics/{idTopic}/replies/{id}:** Mostra uma resposta específica.
- **PUT /topics/{idTopic}/replies/{id}:** Atualiza uma resposta.
- **DELETE /topics/{idTopic}/replies/{id}:** Deleta uma resposta.

## License

This project is licensed under the Apache License, Version 2.0 - see the [LICENSE](LICENSE) file for details.

##### Desenvolvido por [Luís Gabriel Barrichello](https://www.linkedin.com/in/luisgabrielbarrichello/)
