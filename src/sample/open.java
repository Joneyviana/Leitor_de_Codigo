package sample;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;




public  class  open extends heranca {
	private static BufferedWriter bw ;
	private String text ;
	 private String write ;
	 private Simplefile simple = new Simplefile();
	private BufferedReader buf ;
	private File file;	
	 public open(String str) throws IOException	{
	    file = new File(str);
		 
		 buf = new BufferedReader(new FileReader(file));
		
		 //FileWriter fw = new FileWriter(file);
			//bw = new BufferedWriter(fw);
		 
		
			
			
		}
	 
	 public open(String str,String Mode) throws IOException	{
		 File file = new File(str);
		
		 if (Mode.contains("-w")) {
		     file.createNewFile();
			 FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);  
		  
		 }
		 if (Mode.contains("-r")) {
			buf =  new BufferedReader(new FileReader(file));
		 }
	 }

	 public open(URI uri) throws IOException	{
		 File file = new File(uri);
		 buf = new BufferedReader(new FileReader(file));
	 }

	 public open(InputStreamReader str) throws IOException	{
		 buf = new BufferedReader(str);
	 }
public String read() throws IOException {
  String linha ; 
  ;
  //System.out.print(buf.readLine())	 ;
  while ((linha = buf.readLine())!=null) {
		 text = text + linha +"\n";
	    
  } 
	text+=write;
	
	return text;
	}
public void write(String content) throws IOException{
	//bw.write(content);
    //write +=write;
}
public void ajuda(String text){
	

}
public void metodo4(String text , String text2){
	

}

public String readline() throws IOException {
	// TODO Auto-generated method stub

	
	return buf.readLine();
}
public void reset() throws IOException{
	buf.close();
	buf = new BufferedReader(new FileReader(file));
}
}