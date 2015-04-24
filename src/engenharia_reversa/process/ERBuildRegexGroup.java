package engenharia_reversa.process;
import java.util.regex.Matcher;


public class ERBuildRegexGroup {

	public BuildRegexGroup parser;

	public ERBuildRegexGroup(String str , String inicio){
		parser = new BuildRegexGroup(str.substring(str.indexOf(inicio)+1));
		parser.BuildGroupName("visibility", "(?:public|private|protected)");
		parser.BuildGroupName("type" , "\\\\S*");
		parser.BuildGroupName("name", "\\\\S*");
    }

  public Matcher matcher(String str){	

  return parser.matcher(str);
  }
}