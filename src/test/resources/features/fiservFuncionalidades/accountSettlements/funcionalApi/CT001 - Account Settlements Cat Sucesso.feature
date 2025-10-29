Feature: Account Settlements com sucesso utilizando a base cat

  Scenario: CT001 - Account settlements com sucesso utilizando a base cat

    Given que seja iniciada a chamada da url base cat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint account settlements utilizando o ambiente cat
    Then a Api do endpoint account settlements devera retornar status code 200 com os dados esperados no corpo da resposta