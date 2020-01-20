Feature: Busca pela lupa
Deve realizar a busca de um produto a partir do campo de pesquisa

	Scenario: Pesquisa e retorna os produtos relacionados
		Given que esteja na pagina inicial da aplicacao
		When clicar sobre a lupa
		And enviar um texto de busca
		And selecionar um dos produtos obtidos como resultado
		Then o produto aberto deve ser correspondente ao que recebeu o clique
	