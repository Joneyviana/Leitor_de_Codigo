package engenharia_reversa.process;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.HashMap;


public class Ler_codigo {

public  String code_font;
private open feature  =  new open("/home/joney/workspace/codereader/src/features.yaml");
private ERBuildRegexGroup parserline;
private HashMap<String , Matcher> results= new HashMap<String , Matcher>();

public HashMap<String, Matcher> getResults() {
	return results;
}
public Ler_codigo(String file) throws IOException{
	
code_font = new open(file).read();






}
public Ler_codigo(URI uri) throws IOException{	
code_font = new open(uri).read();



}
public Ler_codigo(InputStreamReader str1) throws IOException{	
	code_font = new open(str1).read();
	
	

}
public void inicio() throws IOException{
    String line ;
	feature.reset();
    code_font = code_font.replaceAll("static", "");
    code_font = code_font.replaceAll("final", "");
    code_font = code_font.replaceAll("abstract", "");
	while ((line = feature.readline()) != null) {
	
	parserline = new ERBuildRegexGroup(line, ":");
	
	results.put(line.substring(0,line.indexOf(":")),parserline.matcher(code_font));
	
    }

}
}
