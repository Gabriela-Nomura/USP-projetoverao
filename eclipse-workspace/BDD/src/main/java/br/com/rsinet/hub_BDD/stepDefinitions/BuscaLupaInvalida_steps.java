package br.com.rsinet.hub_BDD.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_TDD.pageFactory.PaginaBusca_POF;
import br.com.rsinet.hub_TDD.utils.Driver_Factory;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.Print;
import br.com.rsinet.hub_TDD.utils.constantes;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BuscaLupaInvalida_steps {
	static Logger Log = Logger.getLogger("Teste de busca por lupa [válido]");
	WebDriver driver;

	HomePage_POF HomePage;
	PaginaBusca_POF BuscaPage;
	
	@Given("^que esteja na pagina inicial da aplicacao$")
	public void inicializa_Aplicacao() throws Throwable {
		driver = Driver_Factory.configDriver();
		Log.info("Faz a configuração do driver");
		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		ExcelUtils.setExcelFile(constantes.Path_TestData, "TesteBusca");
		Log.info("Configurado o arquivo do excel a ser lido");

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");
		
		BuscaPage = PageFactory.initElements(driver, PaginaBusca_POF.class);
		
	}
	@When("^clicar sobre a lupa$")
	public void clicar_sobre_a_lupa() throws Throwable {

//		Reporter.log(" A aplicação foi iniciada com sucesso |");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");
		HomePage.clickOn_busca();
	}
	@And("^enviar um texto de busca$")
	public void enviar_um_texto_de_busca() throws Throwable {
		HomePage.sendText_busca();
		
		Log.info("O módulo de busca foi executado com sucesso");
	}

	
	@Then("^a busca nao retorna nenhum resultado$")
	public void compara() throws Exception{
		Assert.assertTrue("Teste com falha", driver.getPageSource().contains("No results for "));

		Log.info("A comparação com método Assert foi realizada com sucesso");
//		Reporter.log(" A busca foi realizada com sucesso |");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
//		Reporter.log(" A busca pela lupa não retornou o resultado esperado | ");
		Print.takeSnapShot("TesteBuscaLupaFalha", driver);
		Log.info("Tira um PrintScreen");
//		Reporter.log(" O teste foi finalizado ");
		Driver_Factory.encerra(driver);
}
}
