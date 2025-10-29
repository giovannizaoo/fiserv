Feature: All Terminal Values com sucesso utilizando a base uat

  Scenario: CT002 - All Terminal Valuescom sucesso utilizando a base uat

    Given que seja iniciada a chamada da url base uat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint all terminal values utilizando o ambiente uat
    Then a Api do endpoint all terminal values devera retornar status code 200 com os dados esperados no corpo da resposta