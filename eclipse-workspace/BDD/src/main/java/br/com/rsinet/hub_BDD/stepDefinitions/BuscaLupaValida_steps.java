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


public class BuscaLupaValida_steps {
	static Logger Log = Logger.getLogger("Teste de busca por lupa [válido]");
	WebDriver driver;

	HomePage_POF HomePage;
	PaginaBusca_POF BuscaPage;
	
	@Given("^que esteja na pagina inicial$")
	public void inicializa_Aplicacao() throws Throwable {
		driver = Driver_Factory.configDriver();
		Log.info("Faz a configuração do driver");
		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		Driver_Factory.configExcelBusca();

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");
		
		BuscaPage = PageFactory.initElements(driver, PaginaBusca_POF.class);
		
	}
	@When("^clicar sobre lupa$")
	public void clicar_sobre_a_lupa() throws Throwable {

//		Reporter.log(" A aplicação foi iniciada com sucesso |");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");
		HomePage.clickOn_busca();
	}
	@And("^enviar o texto de busca$")
	public void enviar_um_texto_de_busca() throws Throwable {
		HomePage.sendText_busca();
		
		Log.info("O módulo de busca foi executado com sucesso");
	}

	@And("^selecionar um dos produtos obtidos como resultado$")
	public void seleciona() {
	WebElement result = driver.findElement(By.xpath("//*[@id=\"16\"]"));
	result.click();
	Log.info("Clica no elemento que foi buscado");
	}
	
	@Then("^o produto aberto deve ser correspondente ao que recebeu o clique$")
	public void compara() throws Exception{
	Assert.assertTrue("Busca realizada com sucesso",
			driver.getPageSource().contains("HP ELITEPAD 1000 G2 TABLET"));
	Log.info("Realiza a comparação através do método Assert");
	
//	Reporter.log("A aplicação retornou o produto pesquisado |");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

	Print.takeSnapShot("TesteBuscaLupaSucesso", driver);
	Log.info("Tira um PrintScreen");
//	Reporter.log("A busca pela lupa foi realizada com sucesso");
	Driver_Factory.encerra(driver);
}
}
