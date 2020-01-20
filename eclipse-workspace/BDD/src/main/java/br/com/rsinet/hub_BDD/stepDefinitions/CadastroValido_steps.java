package br.com.rsinet.hub_BDD.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.pageFactory.CadastraPage_POF;
import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_TDD.utils.Driver_Factory;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.Print;
import br.com.rsinet.hub_TDD.utils.constantes;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CadastroValido_steps {
	static Logger Log = Logger.getLogger("Teste de busca por clique [válido]");
	WebDriver driver;

	HomePage_POF HomePage;
	CadastraPage_POF CadastraPage;

	@Given("^que esteja na pagina inicial da aplicação$")
	public void inicializa_Aplicacao() throws Throwable {
		driver = Driver_Factory.configDriver();
		Log.info("Faz a configuração do driver");
		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		Driver_Factory.configExcelCadastra();

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");

		CadastraPage = PageFactory.initElements(driver, CadastraPage_POF.class);
		Log.info("A fabrica de objetos da página de cadastro foi instanciada");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");
	}

	@When("^clicar sobre minha conta$")
	public void minhaConta() {
//		Reporter.log(" A aplicação foi iniciada com sucesso |");

		HomePage.minhaConta();
	}

	@And("^selecionar a opcao criar nova conta$")
	public void novaConta() {
		HomePage.novaConta();

//		Reporter.log(" A página de criação de novo usuário foi acessada |");

	}
	
	@And("^inserir um nome de usuario, email, senha e contra senha valido$")
	public void detalhesConta() throws Exception {

		CadastraPage.sendUserName(1);
		CadastraPage.sendUserEmail();
		CadastraPage.sendUserSenha();
		CadastraPage.sendUserSenhaConfirmacao();
	}
	
	@And("^inserir o primeiro e ultimo nome, e o numero de telefone$")
	public void detalhesPessoais() throws Exception {
		CadastraPage.sendUserSPrimeiroNome();
		CadastraPage.sendUserUltimoNome();
		CadastraPage.sendUserTelefone();
	}
	
	@And("^selecionar o pais, informar a cidade, o endereço o estado e o CEP$")
	public void endereco() throws Exception{
		CadastraPage.clickOn_pais();
		CadastraPage.seleciona_pais();
		CadastraPage.sendUserCidade();
		CadastraPage.sendUserEndereco();
		CadastraPage.sendUserEstado();
		CadastraPage.sendUserCep();
	}
	
	@And("^aceitar os termos de aceitacao e clicar no registro$")
	public void aceita() {
		CadastraPage.aceitaTermos();
		CadastraPage.registaUser();

	}
	
	@Then("^o novo usuario deve ser logado e direcionado a homepage com nome de usuario sendo exibido$")
public void displayNomeUser() throws Exception {
//		Reporter.log("Um novo usuário foi cadastrado com sucesso |");

		Assert.assertTrue(HomePage.logadoNomeUser());

//		Reporter.log("O nome de usuário obtido é igual ao enviado a aplicação |");
		
		Print.takeSnapShot("TesteCadastroValido", driver);
		Log.info("Um PrintScreen é obtido da tela atual");
		
//		Reporter.log("O teste de cadastro válido foi concluído com sucesso |");
//		
//		Reporter.log(" A aplicação foi encerrada");
		Driver_Factory.encerra(driver);
	}


}
