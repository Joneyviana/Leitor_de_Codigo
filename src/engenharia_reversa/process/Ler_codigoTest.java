package engenharia_reversa.process;

import  static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class Ler_codigoTest {

	private Ler_codigo code;

	 @Before 
	 public void setUp(){
		 try {
			code = new Ler_codigo("/home/joney/workspace/Engenharia Reversa/src/engenharia_reversa/process/open.java");
			code.inicio();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	

	@Test
	public void testfindClass() {
		
			
		    //System.out.println(code.code_font);
			assertEquals(code.results.get("class").find(),true);
			assertEquals(code.results.get("class").group("name"),"open");
			assertEquals(code.results.get("class").group("name"),"open");
	}
	@Test
	public void testfindMethod() {
		
			
			assertEquals(code.results.get("method").find(),true);
			assertEquals(code.results.get("method").group(0),"public String read()");
			assertEquals(code.results.get("method").group("name"),"read");
			assertEquals(code.results.get("method").group("type"),"String");
	 		assertEquals(code.results.get("method").group("visibility"),"public");
	 		assertEquals(code.results.get("method").find(),true);
	 		
			assertEquals(code.results.get("method").group("name"),"write");
	}	 
	


  @Test
  public void testfindinherit() {
	  assertEquals(code.results.get("inherit").find(),true);
	  assertEquals(code.results.get("inherit").group("name") ,"herança");
  }
  }