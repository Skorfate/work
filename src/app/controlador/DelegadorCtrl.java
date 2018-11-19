package app.controlador;

import java.util.HashMap;
import java.util.Scanner;

import app.constantes.ExprReg;
import app.model.UnidadValor;
import app.utilidades.Util;

/**
 * Controlador responsable de delegar la tarea
 *
 */
public class DelegadorCtrl {
	/**
	 * Hashmap que tendra todo los valores entregados
	 */
	private HashMap<String,UnidadValor> hm;
	private ProcesoValor procesoValor;
	private ProcesoPregunta procesoPregunta;
	
	/**
	 * inicia toda la logica
	 */
	public void init() {
		Scanner sc = new Scanner(System.in);        
        String entrada;
        hm = new HashMap<>();
        procesoValor = new ProcesoValor(hm);
        procesoPregunta = new ProcesoPregunta(hm);
        while(true) {
        	entrada = sc.nextLine();
        	if(Util.validaExpresionRegular(ExprReg.REG_EXP_NO_CREDITS.getRegExp(), entrada)) {        		
        		procesoValor.guardarUnicoValor(entrada);
        	}else if(Util.validaExpresionRegular(ExprReg.REG_EXP_CREDITS.getRegExp(), entrada)) {
        		procesoValor.valorCredits(entrada);
        	}else if(Util.validaExpresionRegular(ExprReg.REG_EXP_PREGUNTA.getRegExp(), entrada)) {
        		procesoPregunta.obtieneValor(entrada);
        	}else {        		
        		Util.printError();
        	}        	
        }
	}
}
