import java.io.*;
import java.util.Scanner;
import static java.nio.file.StandardCopyOption.*;


public class KomponendiParser {
	public static void main(String args[]) {
		//failiteed();
		osadeKontroll();
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
						  //System.out.println (strLine);
						  if (strLine.substring(0,6).equals("name = ")) {
							  //komp = new Komponent();
							  //komp.nimi = strLine.substring(7,0);
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
	
	public static String[] failiteed() {
		File[] failid = new File("D:/KSP_win/Parts").listFiles();
	    //showFiles(files);
		String[] osad = new String[2];
		for (File fail : failid) {
			//System.out.println(fail);
			
		}
		return osad;
	}
	
	
	// On eeldatud et programm käivitatakse kaustast kuhu on paigaldatud Kerbal Space Program.
	// Kui KSP-osade faile ei leitud, siis küsida KSP kataloogi asukohta ja sealt osade failid programmi kausta kopeerida
	public static void osadeKontroll() {
		File osad = new File("Parts");
		if (osad.isDirectory()) return;
		
		 //Scanner scan = new Scanner(System.in);

		  //System.out.println("Sisesta KSP baaskausta aukoht(D:/KSP_win):");

		  //String asukoht = scan.next();
		  
		  //osad = new File(asukoht + "/Parts");
			osad = new File("D:/KSP_win/Parts");
			
		  if (osad.isDirectory()) {
			  String asukoht = "Parts";
			  File uuedOsad = new File(asukoht);
			  uuedOsad.mkdir();
			  
			  for (File kaust : osad.listFiles()) {
				  
				  File uusOsa = new File(asukoht + "/" + kaust.getName());
				  uusOsa.mkdir();
				  
				  File uusFail = new File(uusOsa.getPath()+"/part.cfg");
				  
				  File partFail = new File(kaust.getPath()+"/part.cfg");
				  
				  
				  //System.out.println(partFail);
				  
				  
				  //copyFileToDirectory(partFail, uusOsa);
				  
				  //FileUtils.copyFile();
				  
				  try {
					InputStream sisse = new FileInputStream(partFail);
					OutputStream valja = new FileOutputStream(uusFail);
					
					byte[] buf = new byte[1024];
					  int len;
					  while ((len = sisse.read(buf)) > 0){
					  valja.write(buf, 0, len);
					  }
					  sisse.close();
					  valja.close();
					
				} catch(FileNotFoundException ex){
					  System.out.println(ex.getMessage() + " in the specified directory.");
					  System.exit(0);
					  }
					  catch(IOException e){
					  System.out.println(e.getMessage());  
				} 
				  
			  }
			  
		  }
		//System.out.println("Exists " + osad.isDirectory());
	}
}
