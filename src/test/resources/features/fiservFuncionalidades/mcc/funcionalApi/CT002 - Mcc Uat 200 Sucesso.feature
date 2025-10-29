Feature: Mcc com sucesso utilizando a base uat

  Scenario: CT002 - Mcc com sucesso utilizando a base uat

    Given que seja iniciada a chamada da url base uat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint reference mcc utilizando o ambiente uat
    Then a Api do endpoint mcc devera retornar status code 200 com os dados esperados no corpo da resposta