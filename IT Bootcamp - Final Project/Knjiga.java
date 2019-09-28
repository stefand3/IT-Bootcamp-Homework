package ZavrsniRad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class Knjiga {
	private LinkedList<String> noveReci;
	private Recnik recnik;
	private LinkedList<String> spojeneReci;	
	
	
	public Knjiga() {
		noveReci = new LinkedList<String>();
		recnik = new Recnik();
		nadjiNoveReci();
		ubaciNoveReci();
		spojeneReci = noveReci;
		upisiSveReci();
	}
	
	public void nadjiNoveReci() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\dsrZavrsni\\knjiga"));
			String linija;
			
			while((linija = br.readLine()) != null) {
				String[] reci = linija.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
				for (int i = 0; i < reci.length; i++) {
					if(!recnik.postojiRec(reci[i]) && !noveReci.contains(reci[i]) && !reci[i].equals(null)) {
						noveReci.add(reci[i]);
					}
					
					if(!reci[i].equals(null) && recnik.postojiRec(reci[i])) {
						recnik.setSveReci(reci[i]);
					}
				}
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ubaciNoveReci() {
		recnik.connect();
		for(String rec : noveReci) {
			if(rec != null) {
				recnik.ubaciNoveReci(rec);
			}
		}
		recnik.disconnect();
	}
	
	public LinkedList<String> getNoveReci(){
		return noveReci;
	}

	
	public Recnik getRecnik() {
		return recnik;
	}
	
	public void upisiSveReci() {
		for(String s : recnik.getSveReci().keySet()) {
			spojeneReci.add(s);
		}
		Collections.sort(spojeneReci);
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("Upis", true);
			for(String s : spojeneReci) {
				s = s.replace(",", "");
				s = s.replace(".", "");
				s = s.replace("'", "");
				s = s.replace("\\", "");
				s = s.replace("-", "");
				//s = s.substring(0, 1).toUpperCase() + s.substring(1);
				fw.write(s + "\n");
			}
			fw.flush();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
