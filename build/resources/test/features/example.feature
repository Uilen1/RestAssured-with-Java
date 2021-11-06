#language:pt
#coding: utf-8

@CUSTOMER-STATUS-CONTROLLER
Funcionalidade: Validar as funcionalidades para status "BLOCKED", "SINCE" e "ALL"
  Como um usuário
  Eu quero validar que somente usuários permitidos solicitem a carta, de acordo com os status

  Contexto:
    Dado que todas as massas estão iniciadas

  @CUSTOMER_STATUS_SELLER_CT_01 @customerStatus @validado
  Cenário: Deve validar que no response o usuário esta enableToLetter = 'true'
    Dado que acesso a rota "/status" para o projeto "validator"
    Quando realizo a requisição pelo "seller" informando mes e ano o status deve ser "true"
    Então é retornado para a requisição o status code "200"