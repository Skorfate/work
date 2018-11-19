package app.controlador;

import java.util.HashMap;

import app.constantes.ExprReg;
import app.model.UnidadValor;
import app.utilidades.Util;

/**
 *
 * 
 */
public  class  ProcesoValor {
    
    private HashMap<String,UnidadValor> hm;
    
    public ProcesoValor(HashMap<String,UnidadValor> hm) {
    	this.hm = hm;
    }
    
    
    
    /**
     * guarda los valores unico
     * @param entrada
     */
    public void guardarUnicoValor(String entrada) {
    	String llaveValor[] = Util.remplazaPorRegExp(ExprReg.REG_EXP_REPLACE_NO_CREDITS.getRegExp(), entrada, ",").split(",");
    	UnidadValor uv = new UnidadValor(llaveValor[0], llaveValor[1], false, null);
    	if(!hm.containsKey(llaveValor[0]) && Util.validaExpresionRegular(ExprReg.REG_EXP_NUMERO_ROMANO.getRegExp(), llaveValor[1])) {
    		hm.put(llaveValor[0], uv);
    	}else {
    		Util.printError();
    	}
    }
    
    /**
     * Obtiene valor de los creditos
     * @return
     */
    public  void valorCredits(String entrada){
    	entrada = Util.remplazaPorRegExp(ExprReg.REG_EXP_REPLACE_IS_CREDITS.getRegExp(), entrada, ",");
    	String [] keyValue = entrada.split(",");
    	String keys[] = keyValue[0].split("\\s");
    	Double valor = new Double (keyValue[1].trim());    	
    	StringBuilder sb = new StringBuilder();   	
    	
    	for(int i = 0 ;i<keys.length-1;i++) {
    		if(!hm.containsKey(keys[i])) {
    			Util.printError();
    			return;
    		}else {
    			UnidadValor uv = hm.get(keys[i]);
    			sb.append(uv.getValorRomano());    			
    		}
    	}
    	
    	if(Util.validaExpresionRegular(ExprReg.REG_EXP_NUMERO_ROMANO.getRegExp(), sb.toString())) {    		
    		Integer factor = Util.calculoRomanoDecimal(Util.romanoDecimal(sb.toString()));
    		String llave = keys[keys.length-1];		
    		valor = valor / factor;
    		UnidadValor uvCredit = new UnidadValor(llave,null,true,valor);
    		hm.put(llave,uvCredit);
    		
    	}else {
    		Util.printError();
			return;
    	}
    }
    
}
