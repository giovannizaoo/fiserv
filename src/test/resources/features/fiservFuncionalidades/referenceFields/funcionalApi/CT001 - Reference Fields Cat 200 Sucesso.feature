Feature: Reference Fields com sucesso utilizando a base cat

  Scenario: CT001 - Reference Fields com sucesso utilizando a base cat

    Given que seja iniciada a chamada da url base cat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint reference fields utilizando o ambiente cat
    Then a Api do endpoint optional reference fields devera retornar status code 200 com os dados esperados no corpo da resposta