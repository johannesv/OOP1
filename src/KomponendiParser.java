import java.io.*;
import java.util.Scanner;


public class KomponendiParser {
	public static void main(String args[]) {
		osadeKontroll();
		KomponendiParser.KomponentNimega("fuelTank");
			  
	}
	
	
	
	// Loob ja tagastab antud nimega Komponent objekti (väärtused antakse kui on selle nimega objekt olemas)
	
	public static Komponent KomponentNimega(String nimi) {
		Komponent komp = new Komponent(nimi);
		try{
			  // Avada fail
			  FileInputStream fstream = new FileInputStream("Parts/" + nimi + "/part.cfg");
			  
			  //  DataInputStream objekt
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  
			  //Lugeda reakaupa
			  while ((strLine = br.readLine()) != null)   {
				  
			  // Komponendile õiged väärtused
				  if (strLine.length()>= 2) {
					  if (!strLine.substring(0,2).equals("//")) {
						  System.out.println (strLine);
						  if (strLine.length()>= 6 && strLine.substring(0,6).equals("name =") && komp.nimi.equals("")) {
							  komp.setNimi(strLine.substring(7));
						  } else if (strLine.length()>= 6 && strLine.substring(0,6).equals("mass =") && komp.tyhiMass == 0.0) {
							  float m = Float.parseFloat(strLine.substring(7));
							  komp.setTyhiMass(m);
							  komp.setTaisMass(m);
						  } else if (strLine.length()>= 12 && strLine.substring(0,12).equals("\tmaxThrust =" ) && komp.toukejoud == 0.0) {
							  komp.setToukejoud(Float.parseFloat(strLine.substring(12)));
						  } else if (strLine.length()>= 14 && strLine.substring(0,14).equals("maximum_drag =" ) && komp.minohutakistus == 0.0) {
							  komp.setMinohutakistus(Float.parseFloat(strLine.substring(14)));
						  } else if (strLine.length()>= 14 && strLine.substring(0,14).equals("minimum_drag =" ) && komp.maxohutakistus == 0.0) {
							  komp.setMaxohutakistus(Float.parseFloat(strLine.substring(14)));
						  } else if (strLine.length()== 16 && strLine.substring(0,16).equals(" name = Oxidizer" )) {
							  strLine = br.readLine();
							  float m = komp.getTaisMass() + (Float.parseFloat(strLine.substring(9))/200);
							  komp.setTaisMass(m);
							  
							  
							  System.out.println("LIQUIDNITROGEN TIME"+m);
						  } else if (strLine.length()== 18 && strLine.substring(0,18).equals(" name = LiquidFuel" )) {
							  strLine = br.readLine();
							  float m = komp.getTaisMass() + (Float.parseFloat(strLine.substring(9))/200);
							  komp.setTaisMass(m);
							  
							  
							  System.out.println("LIQUIDNITROGEN TIME"+m);
						  }
					  }
				  }
			  }
			  System.out.println(komp);
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		return komp;
	}
	
	
	// On eeldatud et programm käivitatakse kaustast kuhu on paigaldatud Kerbal Space Program.
	// Kui KSP-osade faile ei leitud, siis küsida KSP kataloogi asukohta ja sealt osade failid programmi kausta kopeeritakse
	public static void osadeKontroll() {
		File osad = new File("Parts");
		if (osad.isDirectory()) return;
		
		 Scanner scan = new Scanner(System.in);

		  System.out.println("Sisesta KSP baaskausta aukoht:");

		  String asukoht1 = scan.next();
		  
		  osad = new File(asukoht1 + "/Parts");
			//osad = new File("D:/KSP_win/Parts");
			
		  if (osad.isDirectory()) {
			  String asukoht = "Parts";
			  File uuedOsad = new File(asukoht);
			  uuedOsad.mkdir();
			  
			  for (File kaust : osad.listFiles()) {
				  
				  File uusOsa = new File(asukoht + "/" + kaust.getName());
				  uusOsa.mkdir();
				  
				  File uusFail = new File(uusOsa.getPath()+"/part.cfg");
				  
				  File partFail = new File(kaust.getPath()+"/part.cfg");

				  
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
	}
}
