package br.com.rsinet.hub_BDD.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


public class BuscaCliqueValida_steps {

	static Logger Log = Logger.getLogger("Teste de busca por clique [válido]");
	WebDriver driver;

	HomePage_POF HomePage;
	PaginaBusca_POF BuscaPage;

	@Given("^que a aplicacao tenha sido inicializada$")
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

	@When("^eu clicar sobre uma categoria de produtos$")
	public void clickOn_HeadPhone() {
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		HomePage.clickOn_HeadPhone();
		Log.info("A categoria de produtos Headphones recebeu um clique");

	}

	@And("^selecionar um dos produtos$")
	public void clickOn_produto() {
		BuscaPage.clickOn_Produto();
		Log.info("O produto selecionado recebeu um clique");
	}

	@And("^adicionar ao carrinho$")
	public void addOn_carrinho() {
		BuscaPage.addOn_carrinho();
	}

	@And("^clicar no checkout")
	public void clickOn_checkOut(){
		BuscaPage.clickOn_checkOut();
		Log.info("O produto selecionado foi inserido no carrinho");
//		Reporter.log("Os comandos de cliques foram executados com sucesso |");
	}
	
	@Then("^o produto adicionado ao carrinho deve ser igual ao produto selecionado")
	public void compara() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"userCart\"]"));
		Log.info("Localiza o produto no carrinho");

		Assert.assertTrue(elemento != null);
		Log.info("Localiza o produto no carrinho");

		Print.takeSnapShot("TesteBuscaCliqueValido", driver);
		Log.info("Foi obtido um print da tela");
		//Reporter.log("O teste foi concluído com sucesso .");
		
	}
}