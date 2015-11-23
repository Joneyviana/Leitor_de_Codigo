package Test;

import  static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;

import org.junit.Before;
import org.junit.Test;

import engenharia_reversa.process.Ler_codigo;


public class Ler_codigoTest {

	private Ler_codigo code;
	private Matcher classe;
	private HashMap<String, Matcher> resultado;
	private Matcher metodo;
	private Matcher inherit;
	private Matcher attribute;

	 @Before 
	 public void setUp(){
		 try {
			code = new Ler_codigo("/home/joney/workspace/codereader/src/sample/open.java");
			code.inicio();
		    resultado = code.getResults();
		    classe = resultado.get("class");
		    metodo = resultado.get("method");   
		    inherit = resultado.get("inherit");
		    attribute = resultado.get("attribute");
		    
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	

	@Test
	public void testfindClass() {
		
			
		    //System.out.println(code.code_font);
			assertEquals("classe encontrada",classe.find(),true );
			assertEquals("classe encontrada", classe.group("name"),"open");
			
	}
	@Test
	public void testfindMethod() {
		
			
			assertEquals(metodo.find(),true);
			assertEquals(metodo.group(0),"public String read()");
			assertEquals(metodo.group("name"),"read");
			assertEquals(metodo.group("type"),"String");
	 		assertEquals(metodo.group("visibility"),"public");
	 		assertEquals(metodo.find(),true);
	 		
			assertEquals(metodo.group("name"),"write");
			assertEquals(metodo.find(),true);
			assertEquals(metodo.group(0),"public void ajuda(String text)");
			assertEquals(metodo.group("rest"),"String text");
	}	 
	


  @Test
  public void testfindinherit() {
	  assertEquals(inherit.find(),true);
	  assertEquals(inherit.group("name") ,"heranca");
  }
  @Test
	public void testfindattribute() {  
	  
	  assertEquals(attribute.find(),true);
	  assertEquals(attribute.group("name"),"bw");
	  
	  
  }

}