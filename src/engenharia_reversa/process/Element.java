package engenharia_reversa.process;

import java.util.regex.Matcher;

public class Element {

private Matcher matcher;

public Element(Matcher matcher){
	  this.matcher = matcher ;
}

public  String getname(){
	return matcher.group("name");
}

public boolean find(){
	return matcher.find();
}
}


