import java.io.*;

public class KomponendiParser {
	public static void main(String args[]) {
		Komponent komp;
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("part.cfg");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
				  if (strLine.length()>= 2) {
					  if (!strLine.substring(0,2).equals("//")) {
						  System.out.println (strLine);
						  if (strLine.substring(0,6).equals("name = ")) {
							  komp = new Komponent();
							  komp.nimi = strLine.substring(7,0);
						  }
					  }
				  }
				  
			  
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
			  
	}
}
