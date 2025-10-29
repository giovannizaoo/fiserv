Feature: Account Type com sucesso utilizando a base cat

  Scenario: CT002 - Account Type com sucesso utilizando a base uat

    Given que seja iniciada a chamada da url base uat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint account type utilizando o ambiente uat
    Then a Api do endpoint account type devera retornar status code 200 com os dados esperados no corpo da resposta