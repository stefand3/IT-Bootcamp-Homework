package auto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;

public class Prodavnica {
	private String conString;
	private Connection con;
	
	private boolean uspesnoLog;
	private ArrayList<Integer> dostupniAutomobili;
	private int kupljenAutomobil;
	private String vlasinikAutomobila;
	java.sql.Date danDatum; 
	private ArrayList<Integer> kupljeniAutomobili;
	private int uplacenIznos;

	public Prodavnica(String str) {
		conString = str;
		
		uspesnoLog = false;
		dostupniAutomobili = new ArrayList<Integer>();
		kupljenAutomobil = 0;
		vlasinikAutomobila = "";
		danDatum = new java.sql.Date(System.currentTimeMillis());
		kupljeniAutomobili = new ArrayList<Integer>();
		uplacenIznos = 0;
	}

	public void connect() {
		try {
			con = DriverManager.getConnection(conString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean uspesnoLog() {
		return uspesnoLog;
	}
	
	public boolean login(String username, String password) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT Count(*)" + " FROM Korisnik k" + " WHERE k.Username = ? AND k.Password = ?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) == 1) {
					uspesnoLog = true;
					return true;
				} else {
					System.err.println("Username or Password doesn't match.");
					return false;
				}
					
			}

			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean register(String username, String password) {
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps;
		try {
			// Provera da li vec postoji username
			ps = con.prepareStatement("SELECT Count(*)" + " FROM Korisnik" + " WHERE Username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) == 1) {
					System.err.println("Korisnicko ime vec postoji");
					return false;
				}
			}
			disconnect();
			connect();
			// Proverava da li username ima razmak
			for (int i = 0; i < username.length(); i++) {
				if (username.charAt(i) == ' ') {
					System.err.println("Username ne sme imati razmak.");
					return false;
				}
			}
			// Provera duzine passworda
			if (password.length() < 6) {
				System.err.println("Lozinka mora imati najmanje 5 karaktera.");
				return false;
			}
			// Proverava da li password ima razmak
			for (int i = 0; i < password.length(); i++) {
				if (password.charAt(i) == ' ') {
					System.err.println("Password ne sme imati razmak.");
					return false;
				}
			}  
			// Ponavljanje sifre
			System.out.println("Ponovite lozinku: ");
			String ponSifr = sc.next();
			if(!ponSifr.equals(password)) {
				System.err.println("Niste dobro ponovili sifru.");
				return false;
			}
//			if(!password.equals(sc.nextLine())) {
//				System.err.println("Niste dobro ponovili sifru.");
//			}
			
			// Ako je sve dobro, dodati korisnika
			PreparedStatement ps2 = con.prepareStatement("INSERT INTO Korisnik (Username, Password, DatumRodjenja)" + 
					" VALUES (?, ?, ?)");
			ps2.setString(1, username);
			ps2.setString(2, password);
			ps2.setString(3, null);
			ps2.executeUpdate();
			ps2.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	public void prikaziAutomobile() {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Automobil.IdAuto, Model.Naziv, Automobil.Cena" + 
					" FROM Prodaja, Automobil, Model" + 
					" WHERE Automobil.IdAuto != Prodaja.IdAuto AND Automobil.IdModel = Model.IdModel AND Automobil.Status = 'n'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idA = rs.getInt(1);
				dostupniAutomobili.add(idA);
				String model = rs.getString(2);
				int cena = rs.getInt(3);
				System.out.println("Id Automobila: " + idA + " -- Model: " + model + "  -- Cena: " + cena);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean kupiAutomobil(String username, int idA) {
		PreparedStatement ps;
		try {
			// Da li je moguce kupiti
			if(!dostupniAutomobili.contains(idA)) {
				System.err.println("Izabrani automobil nije dostupan.");
				return false;
			}
			else {
				kupljenAutomobil = idA;
				vlasinikAutomobila = username;
			}
			
			// Update Model, br prodatih
			ps = con.prepareStatement("UPDATE Model" + 
					" SET BrProdatih = BrProdatih + 1" + 
					" WHERE IdModel IN(SELECT Model.IdModel FROM Model, Automobil, Prodaja WHERE Automobil.IdAuto != Prodaja.IdAuto AND Automobil.IdModel = Model.IdModel AND Automobil.Status = 'n')");
			ps.executeUpdate();
			ps.close();
			
			// Update Automobil
			ps = con.prepareStatement("UPDATE Automobil" + 
					" SET Status = 'p'" + 
					" WHERE Automobil.IdAuto = ?");
			ps.setInt(1, idA);
			ps.executeUpdate();
			ps.close();
			
			// Insert Prodaja
			ps = con.prepareStatement("INSERT INTO Prodaja(IdAuto, Username, Datum)" + 
					" VALUES (?, ?, ?)");
			ps.setInt(1, idA);
			ps.setString(2, username);
			//ps2.setDate(3, null); -----
			ps.setDate(3, danDatum);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public void prikaziKupljeneAutomobile() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		try {
			PreparedStatement ps = con.prepareStatement("SELECT *" + 
					" FROM Prodaja");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				kupljeniAutomobili.add(rs.getInt(1));
				System.out.println("Id Automobila: " + rs.getInt(1) + " -- Vlasnik: " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Napomena: Voditi racuna o tome da korisnik ne plati vise nego sto je potrebno. 
	// Cena po kojoj je automobil kupljen nalazi se u tabeli Automobil.
	public boolean uplatiNovac(int idA, int iznos) {
		int cenaAuta = 0;
		PreparedStatement ps;
		try {
			if(!kupljeniAutomobili.contains(idA)) {
				System.err.println("Izabrani automobil nije dostupan.");
				return false;
			}
			else {
				uplacenIznos = iznos;
			}
			ps = con.prepareStatement("SELECT Cena FROM Automobil WHERE IdAuto = ?");
			ps.setInt(1, idA);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cenaAuta = rs.getInt(1);
			}
			ps.close();
			
			if(iznos > cenaAuta) {
				System.err.println("Uneli ste vise novca nego sto treba.");
				return false;
			}
			else {
				ps = con.prepareStatement("INSERT INTO Uplata (IdAuto, Iznos, Datum)" + 
						" VALUES (?, ?, ?)");
				ps.setInt(1, idA);
				ps.setInt(2, iznos);
				ps.setDate(3, danDatum);
				ps.executeUpdate();
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
