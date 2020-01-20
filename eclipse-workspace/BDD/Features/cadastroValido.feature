Feature: Cadastro de um novo usuário
Deve realizar o cadastro de um novo usuário

	Scenario: Cadastro de um novo usuario com sucesso
		Given que esteja na pagina inicial da aplicacao
		When clicar sobre minha conta
		And selecionar a opcao criar nova conta
		And inserir um nome de usuario, email, senha e contra senha valido
		And inserir o primeiro e ultimo nome, e o numero de telefone
		And selecionar o pais, informar a cidade, o endereço o estado e o CEP
		And aceitar os termos de aceitacao e clicar no registro 
		Then o novo usuario deve ser logado e direcionado a homepage com nome de usuario sendo exibido
		