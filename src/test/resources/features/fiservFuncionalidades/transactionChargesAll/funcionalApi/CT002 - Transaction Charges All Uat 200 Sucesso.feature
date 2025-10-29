Feature: Transaction Charges all com sucesso utilizando a base uat

  Scenario: CT002 - Transaction Charges all com sucesso utilizando a base uat

    Given que seja iniciada a chamada da url base uat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint Transaction Charges all utilizando o ambiente uat
    Then a Api do endpoint Transaction Charges all devera retornar status code 200 com os dados esperados no corpo da resposta