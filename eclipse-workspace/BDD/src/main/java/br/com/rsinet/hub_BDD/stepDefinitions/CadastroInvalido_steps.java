package br.com.rsinet.hub_BDD.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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


public class CadastroInvalido_steps {
	static Logger Log = Logger.getLogger("Teste de busca por clique [válido]");
	WebDriver driver;

	HomePage_POF HomePage;
	CadastraPage_POF CadastraPage;

	@Given("^que esteja na pagina inicial do site$")
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

	@When("^clicar no link minha conta$")
	public void minhaConta() {
//		Reporter.log(" A aplicação foi iniciada com sucesso |");

		HomePage.minhaConta();
	}

	@And("^selecionar a opcao criar uma nova conta$")
	public void novaConta() {
		HomePage.novaConta();

//		Reporter.log(" A página de criação de novo usuário foi acessada |");

	}
	
	@And("^inserir um nome de usuario ja cadastrado, email, senha e contra senha valido$")
	public void detalhesConta() throws Exception {

		CadastraPage.sendUserName(1);
		CadastraPage.sendUserEmail();
		CadastraPage.sendUserSenha();
		CadastraPage.sendUserSenhaConfirmacao();
	}
	
	@And("^inserir o primeiro e ultimo nome, e o numero de telefone validos$")
	public void detalhesPessoais() throws Exception {
		CadastraPage.sendUserSPrimeiroNome();
		CadastraPage.sendUserUltimoNome();
		CadastraPage.sendUserTelefone();
	}
	
	@And("^selecionar o pais, informar a cidade, o endereço o estado e o CEP do user$")
	public void endereco() throws Exception{
		CadastraPage.clickOn_pais();
		CadastraPage.seleciona_pais();
		CadastraPage.sendUserCidade();
		CadastraPage.sendUserEndereco();
		CadastraPage.sendUserEstado();
		CadastraPage.sendUserCep();
	}
	
	@And("^aceitar os termos de aceitacao e clicar sobre o registro$")
	public void aceita() {
		CadastraPage.aceitaTermos();
		CadastraPage.registaUser();

	}
	
	@Then("^o cadastro nao sera concluido e a mensagem de erro aparecera$")
public void displayErroCadastro() throws Exception {
//		Reporter.log("O usuário não foi cadastrado |");

		Assert.assertFalse(HomePage.logadoNomeUser());
		Log.info("Realiza a comparação entre as urls esperada e a obtida");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,150)", "");
		Log.info("Foi aplicado um comando de rolagem de tela, para melhoria do print obtido");

//		Reporter.log("A mensagem de usuário já cadastrado foi obtida com sucesso");
		Print.takeSnapShot("TesteCadastroInvalido", driver);
		Log.info("Tira um PrintScreen para comprovar fim do teste");
//		Reporter.log(" A aplicação foi encerrada");
		Driver_Factory.encerra(driver);
	}


}
