#language:pt
#coding: utf-8

@CUSTOMER-STATUS-CONTROLLER
Funcionalidade: Validar alguns endpoints
  Como um usuário
  Eu quero validar alguns endpoints do site de teste "https://reqres.in/" a fim de aprender melhor sobre Rest Assured

 Contexto: Deve iniciar as massas
   Dado que todas as massas estão iniciadas

  @validado @teste1
  Cenário: Deve obter a lista de usuários
    Dado que acesso a rota "/users"
    Quando busco a lista de usuários na rota
    Então é retornado para a requisição o status code "200"

  @validado @teste2
  Esquema do Cenário: Deve obter a lista de usuários com queryParam
    Dado que acesso a rota "<rota>"
    Quando busco a lista de usuários por queryParam
    E valido as informações para o usuário "<usuario>" com o id "<id>"
    Então é retornado para a requisição o status code "<status>"

    Exemplos:
    |rota   |usuario |id  |status |
    |/users |Micael  |7   |200    |
    |/users |Tobi  |9   |200    |


  @validado @teste3
  Cenário: Deve inserir usuário
    Dado que acesso a rota "/users"
    Quando insiro um usuário
    Então é retornado para a requisição o status code "202"