package engenharia_reversa.process;

import java.util.regex.Matcher;

import UML.VisibilidadeService;

public class Attribute  extends Element{

	
	public Matcher attribute;


	public Attribute(Matcher attribute) {
		super(attribute);
		this.attribute = attribute ;
	    
	    
	   
	}

	public String gettype(){
		 return  attribute.group("type").replace("<","").replace(">", "");
}
	public String getvisibility(){
		String str = attribute.group("visibility"); 
		return VisibilidadeService.ConverterParaPadraoDiagrama(str);
	}
}

