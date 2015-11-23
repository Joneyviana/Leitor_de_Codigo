package engenharia_reversa.process;
import java.util.regex.Matcher;

import UML.VisibilidadeService;


public class Operation  extends Element{


private Matcher metodo;
private BuildRegexGroup regexparameter;
public Matcher parameter;
public String rest;

public Operation (Matcher metodo){
	
    super(metodo);
	this.metodo = metodo ;
    regexparameter = new BuildRegexGroup("type name"); 
	regexparameter.BuildGroupName("type" , "\\\\S+");
	regexparameter.BuildGroupName("name", "\\\\S+");
	

}

public String getvisibility(){
	String str = metodo.group("visibility"); 
	return VisibilidadeService.ConverterParaPadraoDiagrama(str);
}
public String getType(){
	 return metodo.group("type");
}
public Attribute getParameter(){
	rest = this.metodo.group("rest").replace(",", "");
	parameter = regexparameter.matcher(rest) ;
	if ((boolean) rest.isEmpty()){
	   return null ;
	
	}
	else {
	   return new Attribute(parameter); 
	}
}

}
