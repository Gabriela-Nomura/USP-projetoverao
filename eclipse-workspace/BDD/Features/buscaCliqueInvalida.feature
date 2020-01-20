Feature: Busca por clique
Realiza um teste dos resultados obtidos a partir de buscas por clique	
		
	Scenario: Busca por clique com falha
		
		Given que eu esteja na tela inicial do site
		When eu clicar sobre o link de produto populares
		And tirar um print
		And  selecionar o produto 
		And adicionar ao carrinho
		Then o produto aberto sera diferente do produto selecionado
