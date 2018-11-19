package app.utilidades;

import java.util.ArrayList;
import java.util.List;

import app.constantes.NroRomano;

/**
 * clase que posee una serie de funcion que son utiles para varias clases
 * @author theph
 *
 */
public final class Util {
	
	/**
	 * valida una expresion regular segun parametro de entrada
	 * @param regExp expresion regular
	 * @param texto a validar
	 * @return
	 */
	public static boolean validaExpresionRegular(String regExp,String texto) {
		return texto.matches(regExp);
	}
	
	/**
	 * obtiene el valor decimal de un numero romano
	 * @param key
	 * @return
	 */
	public static int llamaValorEnum(String key) {
		return NroRomano.valueOf(key).getValor();
	}
	
	/**
	 * recibe una lista la cual tiene orden de numero romano y lo traduce el sistema decimal
	 * @param lista
	 * @return  int que lleva el calculo de los numeros romanos
	 */
	public static int calculoRomanoDecimal(List<Integer> lista) {
		int contador = 0;
		int resta = 0;
		int aux = 0;
		boolean menor = false;
		for(int i = lista.size()-1;i >= 0;i--) {
			if(i == lista.size()-1) {
				contador += lista.get(i);
				aux = lista.get(i);
			}else {
				if(lista.get(i)>=aux) {
					contador += lista.get(i);
					
				}else {
					contador += -lista.get(i);
				}
				aux = lista.get(i);
			}			
		}
		return contador;
	}
	
	/**
	 * imprime por consola el valor de entrada
	 * @param texto 
	 */
	public static void print(String texto) {
		System.out.println(texto);
	}
	/**
	 * limpia una cadena de texto segun una expresion regular y remplaza aquellos caracteres
	 * @param regex
	 * @param entrada
	 * @param remplazo
	 * @return entrada con valores remplazados
	 */
	public static String remplazaPorRegExp(String regex,String entrada,String remplazo) {
		return entrada.replaceAll(regex, remplazo);
	}
	
	/**
	 * Obtiene el valor de cada numero romano
	 * @param romano
	 * @return lista que contiene los valores de numeros romanos
	 */
	public static List<Integer> romanoDecimal(String romano){
		List<Integer> numero = new ArrayList<>();
		for(char c: romano.toCharArray()) {
			numero.add(llamaValorEnum(Character.toString(c)));
		}
		return numero;
	}
	
	public static void printError() {
		print("I have no idea what you are talking about");
	}
	
}
