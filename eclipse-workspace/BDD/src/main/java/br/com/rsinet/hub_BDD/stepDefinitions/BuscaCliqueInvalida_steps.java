package br.com.rsinet.hub_BDD.stepDefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_TDD.pageFactory.PaginaBusca_POF;
import br.com.rsinet.hub_TDD.utils.Driver_Factory;
import br.com.rsinet.hub_TDD.utils.Print;
import br.com.rsinet.hub_TDD.utils.constantes;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BuscaCliqueInvalida_steps {

	static Logger Log = Logger.getLogger("Teste de busca por clique [válido]");
	WebDriver driver;

	HomePage_POF HomePage;
	PaginaBusca_POF BuscaPage;

	@Given("^que eu esteja na tela inicial do Website$")
	public void inicializa_Aplicacao() throws Throwable {
		driver = Driver_Factory.configDriver();
		Log.info("Faz a configuração do driver");
		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");

		BuscaPage = PageFactory.initElements(driver, PaginaBusca_POF.class);
//		Reporter.log(" A aplicação foi iniciada com sucesso |");

	}

	@When("^eu clicar sobre o link de produto populares$")
	public void clickOn_produtosPopulares() throws InterruptedException {

		HomePage.clickOn_PopularProdutos();
		Log.info("O link de produtos populares recebeu um clique");

	}

	@And("^tirar um print$")
	public void clickOn_produto() throws Exception {
		HomePage.takePrint();
		Log.info("Uma captura de tela foi obtida");
	}

	@And("^selecionar o produto$")
	public void select_produto() {
		HomePage.clickOn_produtos();
		
		
	}

	@And("^adicionar no carrinho$")
	public void clickOn_checkOut(){
		BuscaPage.addOn_carrinho();
		BuscaPage.clickOn_checkOut();
		Log.info("O produto selecionado foi inserido no carrinho");
//		Reporter.log("Os comandos de cliques foram executados com sucesso |");
	}
	
	@Then("^o produto aberto sera diferente do produto selecionado$")
	public void compara() throws Exception {

		Assert.assertTrue(driver.getPageSource().contains("HP CHROMEBOOK 14 G1(ES)"));

		Log.info("Confirma que o item adicionado é diferente do item clicado inicialmente");
//		Reporter.log("O produto inserido no carrinho é divergente do produto selecionado na tela inicial");

		Print.takeSnapShot("TesteBuscaCliquecomfalha", driver);
		Log.info("Tira um PrintScreen");
//		Reporter.log("O teste foi concluído com sucesso");
//
//		Reporter.log(" O produto selecionado foi inserido no carrinho com sucesso |");
//		Reporter.log(" O resultado do teste indica que produto clicado foi correspondente ao aberto |");
		Driver_Factory.encerra(driver);
	}
}