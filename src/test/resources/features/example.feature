#language:pt
#coding: utf-8

@CUSTOMER-STATUS-CONTROLLER
Funcionalidade: Validar alguns endpoints
  Como um usuário
  Eu quero validar alguns endpoints a fim de aprender melhor as ferramentas

 Contexto: Deve iniciar as massas
   Dado que todas as massas estão iniciadas

  @validado
  Cenário: Deve a lista de usuários
    Dado que acesso a rota "/users"
    Quando busco a lista de usuários na rota
    Então é retornado para a requisição o status code "200"

  @validado
  Cenário: Deve inserir usuário
    Dado que acesso a rota "/users"
    Quando insiro um usuário
    Então é retornado para a requisição o status code "201"