package br.com.usp.cursoverao.testes;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import br.com.usp.cursoverao.Dados.Calculadora;

public class TestaCalculadora {

	static Calculadora ca;
	
	@BeforeEach
	public void set() {
		ca = new Calculadora();
		
	}
	@DisplayName("Teste da função adição, subtração e multiplicação")
	@Test
	public void operacaoTest() {
	
	assertEquals(15, ca.operacao(10, 5, "+"));
	assertEquals(5, ca.operacao(10, 5, "-"));
	assertEquals(50, ca.operacao(10, 5, "*"));
	assertEquals(2, ca.operacao(10, 5, "*/"));
}
	@Disabled
	@DisplayName("Teste da função divisão recebendo um valor zero")
	@Test
	public void operacaoZeroTest() {
		
	assertEquals(0, ca.operacao(10, 0, "/"));
	}
}
