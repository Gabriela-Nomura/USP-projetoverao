Feature: Cadastro de um novo usuário
Deve realizar o cadastro de um novo usuário

		Scenario: Cadastro de um novo usuario com falha
		Given que esteja na pagina inicial da aplicacao
		When clicar sobre minha conta
		And  selecionar a opcao criar nova conta
		And inserir um nome de usuario ja cadastrado, email, senha e contra senha valido
		And inserir o primeiro e ultimo nome, e o numero de telefone
		And selecionar o pais, informar a cidade, o endereço o estado e o CEP
		And aceitar os termos de aceitacao e clicar no registro 
		Then o cadastro nao sera concluido e a mensagem de erro aparecera