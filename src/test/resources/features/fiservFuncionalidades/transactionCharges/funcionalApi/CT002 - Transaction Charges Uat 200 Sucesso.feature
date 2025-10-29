Feature: Transaction Charges com sucesso utilizando a base uat

  Scenario: CT002 - Transaction Charges com sucesso utilizando a base uat

    Given que seja iniciada a chamada da url base uat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint Transaction Charges utilizando o ambiente uat
    Then a Api do endpoint Transaction Charges devera retornar status code 200 com os dados esperados no corpo da resposta