package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.controlador.ProcesoPregunta;
import app.model.UnidadValor;

public class ProcesoPreguntaTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();	
	private final PrintStream originalOut = System.out;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));	  
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);	   
	}
	
	/**
	 * solo funciona si el system es sin salto de linea
	 */
	@Test
	public void preguntasSinMatch() {
		HashMap<String,UnidadValor> hm = new HashMap<>();
		ProcesoPregunta pp = new ProcesoPregunta(hm);
		String entrada [] = {"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"};		
		for(String ent : entrada) {
			pp.obtieneValor(ent);
		}
		String salidaTest = "I have no idea what you are talking about\n";
		String salida = outContent.toString();
		System.out.println(salidaTest.equals(salida));
		assertEquals(salidaTest,salida);
	}

}
