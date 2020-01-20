Feature: Busca por clique
Realiza um teste dos resultados obtidos a partir de buscas por clique

	Scenario: Busca por clique com sucesso
		Given que a aplicacao tenha sido inicializada
		When eu clicar sobre uma categoria de produtos
		And selecionar um dos produtos
		And adicionar ao carrinho
		And clicar no checkout
		Then o produto adicionado ao carrinho deve ser igual ao produto selecionado	
