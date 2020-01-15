package br.com.usp.cursoverao.Dados;

public class Calculadora {

	int resultado;
	public int operacao(int i, int j, String string){
		if (string == "+") {
		resultado = (i + j);
		return resultado;}
		else if (string == "-"){
			resultado = (i - j);
					return resultado;}
		else if (string == "*") {
			resultado = (i*j);}
		else if (j != 0){
			resultado = (i / j); }
			else return 0;
		return resultado;
			
		}
		
		
	}

