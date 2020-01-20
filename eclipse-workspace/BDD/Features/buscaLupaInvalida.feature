Feature: Busca pela lupa 
	
	Deve realizar a busca de um produto a partir do campo de pesquisa

Scenario: Pesquisa e nao retorna o produtos 
	Given que esteja na pagina inicial da aplicacao 
	When clicar sobre a lupa 
	And enviar um texto de busca 
	Then a busca nao retorna nenhum resultado 
	