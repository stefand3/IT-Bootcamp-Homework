package cet05_09;

import java.sql.*;
import java.time.LocalDate;

public class Studentska {
	String connectionString;
	Connection con;
	
	public Studentska(String str) {
		connectionString = str;
	}
	
	// Treba samo da doda studenta na osnovu ovih informacija,ne mora da cini dodatne provere
	//Hint (Ovako izgleda sql upit,ako vam je lakse,umesto LocalDate koristite String)
	//insert into dosije(indeks,ime,prezime,datum_upisa,datum_rodjenja,mesto_rodjenja) 
	//values (20140021, 'Milos'   , 'Peric' , '06.07.2014', '20.01.1995', 'Beograd' )

	public void dodajStudenta(int indeks, String ime, String prezime, String datumUpisa, String datumRodjenja, String mestoRodjenja) {
			try {
				String upit = "INSERT INTO dosije(indeks,ime,prezime,datum_upisa,datum_rodjenja,mesto_rodjenja)"
						+ " VALUES ("+indeks+", '"+ime+"', '" +prezime+"', '"+datumUpisa+"', '"+datumRodjenja+"', '"+mestoRodjenja+"')";
				Statement stm = con.createStatement();
				stm.executeUpdate(upit);
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void izbrisiIspite() {
		//Из табеле избрисати испите који немају постављену валидну оцену 
		// (оцена је валидна ако је између 5 и 10,укључујући обе вредности)
		
		try {
			String upit = "DELETE FROM ispit"
//					+ " WHERE ocena < " + pet + "  ocena > " + deset;
					+ " WHERE ocena < 5 OR ocena > 10";
			Statement stm = con.createStatement();
			stm.executeUpdate(upit);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void promenaDatumaRodjenja(int brIndeksa, String datumRodjenja) {
		// Направити методу која мења датум рођења за студента са датим бројем индекса
		
		try {
			String upit = "UPDATE dosije"
					+ " SET datum_rodjenja = '" + datumRodjenja + "'"
					+ " WHERE indeks = " + brIndeksa;
			Statement stm = con.createStatement();
			stm.executeUpdate(upit);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void izdvojPodatke() {
		//1. Izdvojiti podatke o svim predmetima.
		try {
			String upis = "SELECT *"
					+ " FROM predmet";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upis);
			
			while(rs.next()) {
				int idP = rs.getInt(1);
				String sifra = rs.getString(2);
				String naziv = rs.getString(3);
				int bodovi = rs.getInt(4);
				
				System.out.println(idP + " " + sifra + " " + naziv + " " + bodovi);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void studentiIzBeograda(String mesto) {
		// Izdvojiti podatke o svim studentima rođenim u Beogradu.
		
		try {
			String upit = "SELECT *"
					+ " FROM dosije"
					+ " WHERE mesto_rodjenja = '" + mesto + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				int indeks = rs.getInt(1);
				String ime = rs.getString(2);
				String prezime = rs.getString(3);
				String datumU = rs.getString(4);
				String datumR = rs.getString(5);
				String mestoR = rs.getString(6);
				
				System.out.println(ime + " " + prezime + " " + datumU + " " + datumR + " " + mestoR);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void izdvojMesta() {
		// Izdvojiti mesta u kojima su rođeni studenti.
		
		try {
			String upit = "SELECT DISTINCT mesto_rodjenja"
					+ " FROM dosije"
					+ " WHERE mesto_rodjenja IS NOT NULL";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				String mestoR = rs.getString(1);
				
				System.out.println(mestoR);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bodovi() {
		try {
			String upit = "SELECT naziv"
					+ " FROM predmet"
					+ " WHERE bodovi > 6";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				String bodovi = rs.getString(1);
				
				System.out.println(bodovi);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void izmedjuOIPbodova() {
		//  Izdvojiti šifre i nazive predmeta koji imaju između 8 i 15 bodova.
		try {
			String upit = "SELECT sifra, naziv"
					+ " FROM predmet"
					+ " WHERE bodovi >= 8 AND bodovi <= 15";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				String sifra = rs.getString(1);
				String naziv = rs.getString(2);
				
				System.out.println(sifra + " " + naziv);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tacanBrojBodova() {
		// Izdvojiti podatke o ispitima na kojima student ima 81, 76 ili 59 bodova.
		try {
			String upit = "SELECT *"
					+ " FROM ispit"
					+ " WHERE bodovi = 81 OR bodovi = 76 OR bodovi = 59";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				int indeks = rs.getInt(1);
				int idP = rs.getInt(2);
				int godR = rs.getInt(3);
				String oznR = rs.getString(4);
				int ocena = rs.getInt(5);
				String datI = rs.getString(6);
				int bodovi = rs.getInt(7);
				
				System.out.println(indeks + " " + idP + " " + godR + " " + oznR + " " + ocena + " " + datI + " " + bodovi);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void tacanBrojBodova2() {
		// Izdvojiti podatke o ispitima na kojima student nema 81, 76 ili 59 bodova.
		try {
			String upit = "SELECT *"
					+ " FROM ispit"
					+ " WHERE bodovi != 81 OR bodovi != 76 OR bodovi != 59";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				int indeks = rs.getInt(1);
				int idP = rs.getInt(2);
				int godR = rs.getInt(3);
				String oznR = rs.getString(4);
				int ocena = rs.getInt(5);
				String datI = rs.getString(6);
				int bodovi = rs.getInt(7);
				
				System.out.println(indeks + " " + idP + " " + godR + " " + oznR + " " + ocena + " " + datI + " " + bodovi);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cenaPredmeta() {
		//Izdvojiti nazive predmeta i njihovu cenu za samofinansirajuće studente 
		//izraženu u dinarima. Jedan bod košta 1500 dinara.
		try {
			String upit = "SELECT naziv, bodovi*1500 as \"Cena predmeta\""
					+ " FROM predmet";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				String naziv = rs.getString(1);
				int cena = rs.getInt(2);
				
				System.out.println(naziv + " " + cena);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void connect() {
		try {
			con = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
