package engenharia_reversa.process;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;

public class Entity {

private Ler_codigo code;
private HashMap<String, Matcher> resultado;
private Matcher classe;
private Matcher metodo;
private Matcher inherit;
private Matcher attribute;
private boolean HasSuperClass;
private Matcher association;
private boolean hasName;


public Entity(Ler_codigo code){
	try {
		
	    code.inicio();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	resultado = code.getResults();
	
	classe = resultado.get("class");
    hasName = classe.find();
	inherit = resultado.get("inherit");
    HasSuperClass = inherit.find();
	attribute = resultado.get("attribute");
	
}
    
   public String getName(){
	   
	   return classe.group("name");
	 

}
   public Operation getOperation(){
	   metodo = resultado.get("method"); 
       return new Operation(metodo);
}
   
   public boolean hasSuperClass(){
	   return HasSuperClass;
   }
   
   public boolean hasname(){
	   return hasName;
   }
   public Attribute getAtribute(){
	   
       return new Attribute(attribute);
}
public String getSuperclasse(){
	   
       return inherit.group("name");
}

}