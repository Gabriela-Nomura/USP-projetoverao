package br.com.rsinet.hub_BDD.testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = {"br.com.rsinet.hub_BDD.stepDefinitions"})

public class BuscaClique_testRunner {
	
	
}
