package app.controlador;

import java.util.HashMap;

import app.constantes.ExprReg;
import app.model.UnidadValor;
import app.utilidades.Util;

public class ProcesoPregunta {
	
	private HashMap<String,UnidadValor> hm;
	private final String is ="is ";
	private final String credits =" Credits";
	
	public ProcesoPregunta(HashMap<String,UnidadValor> hm) {
		this.hm = hm;
	}
	
	/**
	 * recibe la entrada para luego procesar la pregunta
	 * @param entrada
	 */
	public  void obtieneValor(String entrada) {
		entrada = Util.remplazaPorRegExp(ExprReg.REG_EXP_PREG_BUSCA_FRASE.getRegExp(), entrada, "");		
		String llaves[] = entrada.trim().split(" ");
		boolean validaCredits = false;
		UnidadValor uvCredits = null;
		StringBuilder sb = new StringBuilder();
		StringBuilder resultadoTxt = new StringBuilder();
		for(String llave : llaves) {
			if(!hm.containsKey(llave) || validaCredits) {
				Util.printError();
    			return;
    		}else {
    			UnidadValor uv = hm.get(llave);
    			if(!uv.getIsCredit()) {
    				sb.append(uv.getValorRomano());
    			}else {    			
    				validaCredits = true;
    				uvCredits = uv;
    			}
    			resultadoTxt.append(llave).append(" ");
    		}
		}
		if(Util.validaExpresionRegular(ExprReg.REG_EXP_NUMERO_ROMANO.getRegExp(), sb.toString())) {
			resultadoTxt.append(is);
			Integer resultado = Util.calculoRomanoDecimal(Util.romanoDecimal(sb.toString()));
			if(validaCredits) {
				Integer resultadoCre =  (int) (resultado * uvCredits.getValorCredito());
				resultadoTxt.append(resultadoCre).append(credits);
			}else {
				resultadoTxt.append(resultado);
			}
			Util.print(resultadoTxt.toString());
		}else {
			Util.printError();
		}
	}
}
