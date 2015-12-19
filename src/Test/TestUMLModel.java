package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.After;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import UML.UMlModel;

import engenharia_reversa.process.Entity;
import engenharia_reversa.process.Ler_codigo;


public class TestUMLModel {

	
	

	private static Document doc;
	
	
	
	private static Entity openentity;
	private static Entity herancaentity;



	private static UMlModel uml;



	private static Entity simpleentity;


	@BeforeClass
	public static void setUPBeforeClass() throws IOException{
		String arquivo_uml = "/home/joney/workspace/codereader/src/sample/teste.uml";
	   
		uml = new UMlModel(arquivo_uml , null);
		 File input = new File(arquivo_uml);
		 openentity = new Entity(new Ler_codigo("/home/joney/workspace/codereader/src/sample/open.java"));
		herancaentity = new Entity(new Ler_codigo("/home/joney/workspace/codereader/src/sample/heranca.java"));
		simpleentity = new Entity(new Ler_codigo("/home/joney/workspace/codereader/src/sample/Simplefile.java"));
		uml.addEntity(openentity);
		uml.addEntity(herancaentity);
		uml.addEntity(simpleentity);
		uml.create_Attributes();
		doc = Jsoup.parse(input , "UTF-8"); 
	}
		
	

	@AfterClass
	public static void tearDown() throws Exception {
		RandomAccessFile arquivo = 
		        new RandomAccessFile("/home/joney/workspace/codereader/src/sample/teste.uml", "rw");
	            arquivo.setLength(0);
	}

	@Test
	public void testEntity() throws IOException{
		
		
		assertEquals(3 , doc.select("packagedElement[xsi:type=\"uml:Class\"]").size());
	     assertEquals("open" , doc.select("packagedElement[xsi:type=\"uml:Class\"]").get(0).attr("name")); 
	}
	@Test
	public void testOperation() {
		 Elements operations = doc.select("ownedOperation");
	     assertEquals(6 , operations.size());
	     assertEquals("read" , operations.get(0).attr("name")); 
	     assertEquals("String" , operations.get(2).select("ownedParameter").get(0).attr("type")); 
	}
	@Test
	public void testAttribute() {
		 Elements attribute = doc.select("ownedAttribute");
	     assertEquals(6 ,attribute.size());
	     assertEquals("bw" , attribute.get(0).attr("name")); 
	     assertEquals("String" , attribute.get(2).attr("type")); 
	}
	@Test
	public void testinherit() {
		 Elements generation  = doc.select("generalization");
	     assertEquals(1 ,generation.size());
	     assertEquals("heranca" , generation.get(0).attr("general")); 
	    
	}
	@Test
	public void testAssociation() {
		
		
		
		assertEquals(1 , doc.select("packagedElement[xsi:type=\"uml:Association\"]").size());
	}
} 
