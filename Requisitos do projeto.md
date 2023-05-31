01 - Primeiro projeto com Quarkus
- Implementar um webservice Rest Java com Quarkus com as seguintes funcionalidades:
    1) Fazer a abstração dados de um tema qualquer; 
    2) conter 5 atributos;
    3) Permitir a consulta de todos os itens;
    4) Permitir incluir dados;   
    5) Utilizar o banco de dados PostgreSQL;
    6) Utilizar o docker para rodar o banco de dados PostgreSQL;
    7) Adicionar o Swagger para permitir testar o Webservice.

02 - Implementar um CRUD REST com banco de dados PosgreSQL e Quarkus
- Implementar um CRUD (Inserir, Atualizar, Deletar e Ler) através de um Web Service Rest, com as seguintes funcionalidades:
    1) Utilizar o tema do trabalho anterior;
    2) Permitir Incluir (@Post);
    3) Permitir Alterar (@Put);
    4) Permitir Deletar(@Delete);
    5) Permitir Consultar todos (@Get);
    6) Perfmitir Consultar por id (@Get).

03 - Implementar um CRUD com Padrão Repository
Descrição
- Implementar um CRUD (Inserir, Atualizar, Deletar e Ler) através de um Web Service Rest, com as seguintes funcionalidades:
    1) Utilizar o tema do trabalho anterior;
    2) Permitir Incluir (@Post);
    3) Permitir Alterar (@Put);
    4) Permitir Deletar(@Delete);
    5) Permitir Consultar todos (@Get);
    6) Perfmitir Consultar por id (@Get).
    7) Perfmitir Consultar por nome utilizando o LIKE e retornando uma Lista (@Get).
* Utilizar o banco de dados postgreSql em conjunto com o Docker (conforme realizado em sala de aula).
* DEVE UTILIZAR O PADRÃO REPOSITORY

04 - Implementar um CRUD com DTO e Relacionamento @ManyToOne
Descrição
- Implementar um CRUD (Inserir, Atualizar, Deletar e Ler) através de um Web Service Rest, com as seguintes funcionalidades:
    1) Utilizar o tema do trabalho anterior com um relacionamento @ManyToOne;
    2) Permitir Incluir (@Post);
    3) Permitir Alterar (@Put);
    4) Permitir Deletar(@Delete);
    5) Permitir Consultar todos (@Get);
    6) Perfmitir Consultar por id (@Get).
    7) Perfmitir Consultar por nome utilizando o LIKE e retornando uma Lista (@Get).
* Utilizar o banco de dados postgreSql em conjunto com o Docker (conforme realizado em sala de aula).
* DEVE UTILIZAR O PADRÃO REPOSITORY
* DEVE UTILIZAR O PADRÃO DTO

05 - Implemente um CRUD com a camada Service e Validação com Bean Validation
Descrição
    1) Adicionar a camada Serviçe e Bean validation no trabalho 04.
    2) Utilizar ao menos 3 tipos de validações (Bean Validation).
    3) Nos endpoints Post e Put, retornar os respectivos status code: 201(Created) e 204(No_Content).

# PROVA
A1 - Parte 01 (Diagrama de Classes e Lista de Classes que serão implementadas)
- Enviar o diagrama de classes e a lista de classes que foi definida com o professor em sala de aula.

A1 - Parte 02 - Implementação das Classes listadas na Parte 01.
Implementar uma API Rest referente às classes informadas na Parte 01.
A API deve:
    1) Seguir a estrutura de classes e padrões definidas em sala de aula (Model, Repository, Service, DTO com record e Resource);
    2) Utilizar as seguintes tecnologias: JPA, PostgreSQL, Bean Validation;
    3) Possuir classes endpoints (Resource) com os seguintes recursos:
        GET
        - findById;
        - findAll;
        - count;
        - findByAlgumAtributo (AlgumAtributo referente à sua classe);
        POST
        - insert;
        PUT
        - update;
        DELETE
        - delete.
    4) Possuir um arquivo de inicialização dos dados para todos os recursos (ex. import.sql).

A1 - Parte 03 - Testes Unitários
O objetivo dos testes é tentar assegurar o funcionamento correto de um sistema.
Sendo assim, essa atividade deve: 
    1) Utilizar os frameworks JUnit e Rest Assured para criar os testes;
    2) Criar ao menos 1 teste para cada endpoint das classes Resources (caso necessário, criar outros testes);
    3) Caso encotre erros, deve corrigir o código e relatar a correção em um documento .txt;
    4) Enviar todo o código fonte.

06 - - Implementar o Perfil do Usuário
Implementar um endpoint (resource) que permita obter e alterar as informações do usuário logado.
    1) Dados pessoais (cpf, nome, login - não podem ser alterados);
    2) Senha (o usuário deve informar a senha antiga e a nova);
    3) telefone(s);
    4) endereço(s).

Façam em conformidade ao trabalho de vocês.
* Cada um dos itens acima será um recurso do endpoint.
* Cada recurso deve utilizar o método @PATCH.

07 - Implementar Compras e Imagens do Produto
- Implementar o endpoint das compras e permitir o envio de imagens no endpoint de produtos.

08 - Implementar o Pagamento e os Logs da aplicação.
- Implementar o pagamento de uma compra. (Pensem como vcs vão enviar essa informação, se é pelo endpoint da compra ou do pagamento).
- Implementar os logs de todos os arquivos Resources (lembrando que o ideal é aplicar em todo o projeto).
- Adicione diferentes tipos de logs (INFO, WARN, ERRO, DEBUB).

# PROVA
A2 - Entrega final da API
Descrição
Enviar todo o codigo fonte do projeto.