Feature: Optional details com sucesso utilizando a base cat

  Scenario: CT001 - Optional details com sucesso utilizando a base cat

    Given que seja iniciada a chamada da url base cat da funcionalidade fiserv funcionalidades
    When prencho todos os campos obrigatorios do endpoint optional details utilizando o ambiente cat
    Then a Api do endpoint optional details devera retornar status code 200 com os dados esperados no corpo da resposta