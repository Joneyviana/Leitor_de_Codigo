package engenharia_reversa.process;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.HashMap;


public class Ler_codigo {
private double n ;
public  String code_font;
private open feature;
private BuildRegexGroup parser;
private ERBuildRegexGroup parserline;
public HashMap<String , Matcher> results= new HashMap<String , Matcher>();

public Ler_codigo(String file) throws IOException{
	
code_font = new open(file).read();
System.out.print(code_font);
feature = new open("/home/joney/workspace/Engenharia Reversa/src/features.yaml");
String str = feature.read();



}
public Ler_codigo(URI uri) throws IOException{	
code_font = new open(uri).read();

feature = new open("/home/joney/workspace/Engenharia Reversa/src/features.yaml");
String str = feature.read();
}
public Ler_codigo(InputStreamReader str1) throws IOException{	
	code_font = new open(str1).read();
	
	feature = new open("/home/joney/workspace/Engenharia Reversa/src/features.yaml");
	String str = feature.read();
}
public void inicio() throws IOException{
    String line ;
	feature.reset();
   
	while ((line = feature.readline()) != null) {
	//System.out.println("linha"+line);
	parserline = new ERBuildRegexGroup(line, ":");
	
	results.put(line.substring(0,line.indexOf(":")),parserline.matcher(code_font));
	
    }
}
}
