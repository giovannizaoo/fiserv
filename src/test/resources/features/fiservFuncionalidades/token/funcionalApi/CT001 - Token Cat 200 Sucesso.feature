Feature: Token com sucesso utilizando a base cat

  Scenario: CT001 - Token com sucesso utilizando a base cat

    Given que seja iniciada a chamada da url base cat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint token cat
    Then a Api do endpoint token devera retornar status code 200 com os dados esperados no corpo da resposta