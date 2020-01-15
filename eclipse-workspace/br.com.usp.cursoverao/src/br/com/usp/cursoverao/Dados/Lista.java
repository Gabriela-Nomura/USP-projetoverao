package br.com.usp.cursoverao.Dados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Lista {
	
	static String ListaOrdenada ;
	 static Logger Log = Logger.getLogger("br.com.usp.cursoverao.Dados.Lista");
	public static void main(String[] args) {
		
	
	// Constrói um objeto que permite inserir numeros no console
	Scanner numeros = new Scanner(System.in);
	int i = 0;
	Log.info("Criado arquivo para leitura dos números");
	
	// Constrói um Array com 5 posições
	int[] listaDeNumeros = new int[5];
	Log.info("Instancia uma lista com 5 posições");

// Preenche o Array a parti da posição 1
	
	while (i<listaDeNumeros.length){
		Log.info("Digite " + i + "° numeros: ");
		listaDeNumeros[i] = (numeros.nextInt());
		Log.info("Insere o número na lista");
		i= i+1;
	}

	// Coloca o Array em ordem crescente
	Arrays.sort(listaDeNumeros);
	Log.info("Faz a ordenação dos números inseridos na lista");
	Log.info("Lista ordenada: " );
	
	// Lista o Array em ordem crescente
	Log.info("Ordem crescente:    ");
	for(int j = 1;j<listaDeNumeros.length;j++){
		Log.info(listaDeNumeros[j] + "  ");
	}
}
}