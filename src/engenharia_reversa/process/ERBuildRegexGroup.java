package engenharia_reversa.process;
import java.util.regex.Matcher;


public class ERBuildRegexGroup {

	public BuildRegexGroup parser;

	public ERBuildRegexGroup(String str , String inicio){
		parser = new BuildRegexGroup(str.substring(str.indexOf(inicio)+1));
		parser.BuildGroupName("visibility", "(?:public|private|protected)");
		parser.BuildGroupName("type" , "\\\\w+");
		parser.BuildGroupName("name", "\\\\w+");
		parser.BuildGroupName("rest", ".*");
		
	    parser.string = parser.string.replaceAll(" ", "\\\\s+");
	    
	}

  public Matcher matcher(String str){	

  return parser.matcher(str);
  }
}