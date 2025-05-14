On this test, you will have to consume the github APIs.

The endpoints' documentation that you will use for this test are available at:
https://developer.github.com/v3/
https://developer.github.com/v3/users/
https://developer.github.com/v3/repos/

Create an API that will proxy all client requests to the appropriate GitHub endpoint.
The following endpoints must be provided:

GET - /api/users?since={number}
This endpoint must return a list of GitHub users and the link for the next page.

GET - /api/users/:username/details
This endpoint must return the details of a GitHub users

GET - /api/users/:username/repos
This endpoint must return a list with all user repositries




github.com/devsuperior/demo-openfeign
https://devsuperior.com.br/ijs-udemy-531282

-------------------------------------------------------------------------


[Usuário] → (GET /api/github/users?since=0)
    ↓
[Controller] GitHubUsersController
    ↓
[Service] GitHubUserService
    ↓
[Client] GitHubApiClient
    ↓
[API Externa] https://api.github.com/users?since=0
    ↓
[Retorna JSON de usuários] → Converte para DTO → Volta em forma de Lista
    ↓
[Retorno Final] → JSON com a lista de usuários

-------------------------------------------------------------------------

>> Controller
Controla as requisições HTTP.
* Quando alguém acessa /api/github/users?since=0, este método é chamado.
* O since é extraído da URL.
* O controller delega a chamada ao GitHubUserService.

>> Service
Contém a lógica de negócio (aqui, bem simples).
* Recebe o since.
* Chama o cliente HTTP (GitHubApiClient) para buscar os dados da API do GitHub.
* Retorna uma lista de usuários no formato GitHubUsersDTO.

>> Client 
Faz a requisição HTTP externa usando RestTemplate.
* Monta a URL: https://api.github.com/users?since=X.
* Usa RestTemplate para fazer um GET.
* Converte o array JSON em objetos Java (GitHubUsersDTO[]).
* Retorna como List.

>> DTO
É um objeto de transferência de dados que representa o que você recebe da API do GitHub.
O JSON retornado pela API é mapeado automaticamente nesses campos.
As anotações @JsonProperty servem para mapear nomes diferentes no JSON (por exemplo, avatar_url → avatarUrl).