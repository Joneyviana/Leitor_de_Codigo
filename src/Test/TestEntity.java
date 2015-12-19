package Test;

import engenharia_reversa.process.Element;
import engenharia_reversa.process.Entity;
import engenharia_reversa.process.Ler_codigo;
import engenharia_reversa.process.Operation;
import engenharia_reversa.process.Attribute;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEntity {

	private Entity entity;
	private Operation operation;
	private Attribute attribute;

	@Before
	public void setUp() throws Exception {
	 Ler_codigo code  = new Ler_codigo("/home/joney/workspace/codereader/src/sample/open.java");
	 entity = new Entity(code) ;
	 operation = entity.getOperation();
	 attribute = entity.getAtribute();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNameEntity() {
		assertEquals(entity.getName() , "open");
	}

	@Test
	public void testOperation() {
		
		operation.find();
		assertEquals(operation.getname() , "read");
		assertEquals(operation.getvisibility() , "+");
		operation.find();
		assertEquals(operation.getType() , "void");
		operation.find();
		assertEquals(operation.getname() , "ajuda");
		
		
	}
	@Test
	public void testparameter() {
		
		operation.find();
		Attribute parameter1 = operation.getParameter();
	    assertNull(parameter1);
		operation.find();
		operation.find();
		Attribute parameter2 = operation.getParameter();
		parameter2.find();
		assertEquals(parameter2.getname() , "text");
		assertEquals(parameter2.gettype() , "String");
	}
	@Test
	public void testmultiploparameter() {	
    for(int index = 0 ; index<4; index++){
       operation.find();	
    }
    
    Attribute parameter = operation.getParameter();
    //assertEquals(operation.rest , "String text  String text2 ");
    parameter.find();
	assertEquals(parameter.getname() , "text");
	assertEquals(parameter.gettype() , "String");
    assertTrue(parameter.find());
	assertEquals(parameter.getname() , "text2");
	assertEquals(parameter.gettype() , "String");
	}
	
	
	@Test
	public void testAttribute() {
        attribute.find();
        assertEquals("bw", attribute.getname());
	
}

	@Test
	public void testinherit() {
		assertEquals("heranca" , entity.getSuperclasse());
	}

	
}
	