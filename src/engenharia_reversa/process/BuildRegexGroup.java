package engenharia_reversa.process;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildRegexGroup {
	public String  string;
	private String regex;
	public BuildRegexGroup(String str){
		string = str;
		string = string.replaceAll("\\(", "\\\\\\(") ;
		string = string.replaceAll("\\)", "\\\\\\)") ;
		//System.out.print(string);
	}
	
	public void BuildGroupName(String key , String values ){
		
		string = string.replaceAll(key,"(?<"+key+">"+values+")");
		
		
	}
	public Matcher matcher(String feature) {
		
		//string.contains() ;
		Pattern pattern = Pattern.compile(string);
		 Matcher matcher = pattern.matcher(feature);
	    return matcher;
	}
	

	}






