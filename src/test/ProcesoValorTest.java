package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import app.controlador.ProcesoValor;
import app.model.UnidadValor;

public class ProcesoValorTest {
	
	
	
	/**
	 * se envian 6 registro, uno va repetido
	 * solo deberia guardar 4
	 */
	@Test
	public void guardaValoresRepetidos() {
		HashMap<String,UnidadValor> hm = new HashMap<>();
		ProcesoValor pv = new ProcesoValor(hm);
		String entrada [] = {"glob is I","glob is V","prok is V","pish is X","tegj is L","tegj is L"};		
		for(String ent : entrada) {
			pv.guardarUnicoValor(ent);
		}		
		assertEquals(4, hm.size());	
		assertEquals("I", hm.get("glob").getValorRomano());
	}
	
	/**
	 * Se envian entradas invalidas solo uno es corecto
	 */
	@Test
	public void Entradasinvalidos() {
		HashMap<String,UnidadValor> hm = new HashMap<>();
		ProcesoValor pv = new ProcesoValor(hm);
		String entrada [] = {"glob is IP","prokhow is V4","pish is Xh","tegj is iiiL","tegj is L"};		
		for(String ent : entrada) {
			pv.guardarUnicoValor(ent);
		}		
		assertEquals(1, hm.size());		
	}
	
	/**
	 * se ingresan creditos sin haber ingresado las variables base
	 */
	@Test
	public void SalidasInvalidas() {
		HashMap<String,UnidadValor> hm = new HashMap<>();
		ProcesoValor pv = new ProcesoValor(hm);
		String entrada [] = {"glob glob Silver is 34 Credits"};		
		for(String ent : entrada) {
			pv.guardarUnicoValor(ent);
		}		
		assertEquals(0, hm.size());		
	}
	
	

}
