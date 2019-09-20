package pet06_09;

import java.sql.*;

public class Klasa {
	String connectionString;
	Connection con;

	public Klasa(String str) {
		connectionString = str;
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
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ispisSvihFudbalera() {
		try {
			PreparedStatement pstm = con.prepareStatement(
					"SELECT Fudbaler.Ime, Tim.Naziv FROM Fudbaler, Tim WHERE Fudbaler.IdtIM = Tim.IdTim");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String ime = rs.getString(1);
				String tim = rs.getString(2);

				System.out.println(ime + " " + tim);
			}
			pstm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void igraciMU() {
		try {
			String upit = " SELECT Fudbaler.Ime" + " FROM Fudbaler, Tim"
					+ " WHERE Fudbaler.IdTim = Tim.IdTim AND Tim.Mesto = 'Manchester'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);

			while (rs.next()) {
				String ime = rs.getString(1);

				System.out.println(ime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void igracGolovi() {
		try {
			String upit = " SELECT f.Ime, Count(*) as \"Broj golova\"" + " FROM Gol g, Fudbaler f"
					+ " WHERE f.IdFud = g.IdFud" + " GROUP BY g.IdFud";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);

			while (rs.next()) {
				String ime = rs.getString(1);
				int brGol = rs.getInt(2);

				System.out.println(ime + " " + brGol);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void igracNajviseGolova() {
		try {
			String upit = "SELECT Fudbaler.Ime, Max(x.num)"
					+ " FROM (SELECT Count(*) AS \"num\" FROM Fudbaler, Gol WHERE Fudbaler.IdFud = Gol.IdFud GROUP BY Gol.IdFud) x, Fudbaler, Gol"
					+ " WHERE Fudbaler.IdFud = Gol.IdFud";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);

			while (rs.next()) {
				String ime = rs.getString(1);
				int brGol = rs.getInt(2);

				System.out.println(ime + " " + brGol);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void kartoni() {
		try {
			PreparedStatement pstm = con.prepareStatement(
					"SELECT Ime, COUNT(case when Karton.Tip = \"crveni karton\" then 1 else null end), COUNT(case when Karton.Tip = \"zuti karton\" then 1 else null end) FROM Fudbaler, Karton WHERE Fudbaler.IdFud = Karton.IdFud GROUP BY Karton.IdFud\r\n");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + "  Crveni:" + rs.getInt(2) + "  Zuti:" + rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gradovi(int id) {
		try {
			PreparedStatement pstm = con.prepareStatement("SELECT Tim.Mesto" + " FROM Fudbaler, Tim"
					+ " WHERE Fudbaler.IdTim = Tim.IdTim AND IdFud = ?" + " UNION" + " SELECT Tim.Mesto" + " FROM Tim"
					+ " WHERE IdTim in (SELECT Utakmica.IdDomacin FROM Fudbaler, Tim, Utakmica WHERE Fudbaler.IdTim = Tim.IdTim AND Tim.IdTim = Utakmica.IdGost AND IdFud = ? GROUP BY Utakmica.IdDomacin)");
			pstm.setInt(1, id);
			pstm.setInt(2, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.println("Gradovi u kojim je igrao: " + rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ubaciFudbalera(String ime, int IdTim) {
		try {
			PreparedStatement max = con.prepareStatement("SELECT MAX(Fudbaler.IdFud) FROM Fudbaler");
			ResultSet rs = max.executeQuery();
			int idFud = (rs.getInt(1) + 1);

			PreparedStatement pstm = con
					.prepareStatement("INSERT INTO Fudbaler (IdFud, Ime, IdTim)" + " VALUES (?, ?, ?)");
			pstm.setInt(1, idFud);
			pstm.setString(2, ime);
			pstm.setInt(3, IdTim);
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gradoviGdeJeFudbalerIgrao(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT DISTINCT Tim.mesto AS \"Gradovi u kojim je igrao\""
					+ " FROM  Fudbaler JOIN Tim  using(IdTim) JOIN Utakmica on (IdTim = IdDomacin)" + " where IdFud = ?"
					+ " UNION" + " SELECT Tim.Mesto" + " From Tim" + " WHERE IdTim in(SELECT IdDomacin"
					+ " FROM  Fudbaler JOIN Tim  using(IdTim) JOIN Utakmica on (IdGost = IdTim)" + " where IdFud = ?)");
			ps.setInt(1, id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Gradovi u kojim je igrao: " + rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ubaciTim(String naziv, String mesto) {
		try {
			PreparedStatement maxpstm = con.prepareStatement("SELECT MAX(IdTim) FROM Tim");
			ResultSet rs = maxpstm.executeQuery();
			int id = (rs.getInt(1) + 1);

			PreparedStatement pstm = con
					.prepareStatement("INSERT INTO Tim (IdTim, Naziv, Mesto)" + " VALUES (?, ?, ?)");
			pstm.setInt(1, id);
			pstm.setString(2, naziv);
			pstm.setString(3, mesto);
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ubaciUtakmicu(String imeD, String imeG, String kolo, String ishod, int godina) {
		try {
			// Dobijanje IDa
			PreparedStatement idpstm = con.prepareStatement("SELECT MAX(IdUta) FROM Utakmica");
			ResultSet rs1 = idpstm.executeQuery();
			int id = rs1.getInt(1) + 1;

			// Dobijanje IDa Domacina
			PreparedStatement dompstm = con.prepareStatement(
					"SELECT Utakmica.IdDomacin FROM Utakmica, Tim WHERE Tim.IdTim = Utakmica.IdDomacin AND Tim.Naziv = ?");
			dompstm.setString(1, imeD);
			ResultSet rs2 = dompstm.executeQuery();
			int domacinId = rs2.getInt(1);

			// Dobijanje IDa Gosta
			PreparedStatement gostpstm = con.prepareStatement(
					"SELECT Utakmica.IdDomacin FROM Utakmica, Tim WHERE Tim.IdTim = Utakmica.IdDomacin AND Tim.Naziv = ?");
			gostpstm.setString(1, imeG);
			ResultSet rs3 = gostpstm.executeQuery();
			int gostId = rs3.getInt(1);

			// Dodavanje Utakmice
			PreparedStatement pstm1 = con
					.prepareStatement("INSERT INTO Utakmica(IdUta, IdDomacin, IdGost, Kolo, Ishod, Godina)"
							+ " VALUES (?, ?, ?, ?, ?, ?)");
			pstm1.setInt(1, id);
			pstm1.setInt(2, domacinId);
			pstm1.setInt(3, gostId);
			pstm1.setString(4, kolo);
			pstm1.setString(5, ishod);
			pstm1.setInt(6, godina);
			pstm1.executeUpdate();

			// potrebno je izvrsiti i ubacivanja u Tabelu igrao za sva igrace koji su igrali
			// na utakmici
			// (poziciju igraca mozete ostaviti kao NULL)
			String r = "";
			/////////////////////////////////////////////////////////////////////////////
			PreparedStatement pstm2 = con.prepareStatement("INSERT INTO Igrao(IdFud, IdUta, PozicijaIgraca)"
					+ " VALUES ((SELECT Fudbaler.IdFud FROM Fudbaler, Utakmica, Igrao WHERE Fudbaler.IdFud = Igrao.IdFud AND Igrao.IdUta = Utakmica.IdUta AND Utakmica.IdUta = ?), ?, null)");
			pstm2.setInt(1, id);
			pstm2.setInt(2, id);
			pstm2.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * -metodu koja iz baze brise tim(parametar je ime tima), da bi se mogao
	 * obrisati tim, 
	 * -moraju se prvo obrisati svi igraci koji igraju u tom timu, da
	 * bi se obrisali svi igraci, 
	 * 
	 * -moraju se prvo obrisati svi golovi i kartoni i
	 * igrao za svakog igraca,
	 * -a da bi se oni obrisali moraju se prvo obrisati sve utakmice u kojima je
	 * svaki igrac igrao
	 */
	public void izbrisiTim(String naziv) {
		PreparedStatement ps;
		ResultSet rs;
		int idTima = 0;
		// Nalazenje ID Tima
		try {
			ps = con.prepareStatement("SELECT IdTim FROM Tim WHERE Naziv = ? ");
			ps.setString(1, naziv);
			rs = ps.executeQuery();
			idTima = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Brisanje Utakmica
		try {
			ps = con.prepareStatement("DELETE FROM Utakmica WHERE IdDomacin = ? OR IdGost = ?");
			ps.setInt(1, idTima);
			ps.setInt(2, idTima);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// Brisanje Igrao
		try {
			ps = con.prepareStatement("DELETE FROM Igrao" 
			+ " WHERE IdFud IN (SELECT IdFud FROM Fudbaler WHERE IdTim = ?)");
			ps.setInt(1, idTima);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// Brisanje Gol
		try {
			ps = con.prepareStatement("DELETE FROM Gol" 
			+ " WHERE IdFud IN (SELECT IdFud FROM Fudbaler WHERE IdTim = ?)");
			ps.setInt(1, idTima);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// Brisanje Karton
		try {
			ps = con.prepareStatement("DELETE FROM Karton" 
		+ " WHERE IdFud IN (SELECT IdFud FROM Fudbaler WHERE IdTim = ?)");
			ps.setInt(1, idTima);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// Brisanje Igraca
		try {
			ps = con.prepareStatement("DELETE FROM Fudbaler" 
		+ " WHERE IdTim = ?");
			ps.setInt(1, idTima);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// Brisanje Igraca
		try {
			ps = con.prepareStatement("DELETE FROM Tim" 
		+ " WHERE Naziv = ?");
			//ps.setInt(1, idTima);
			ps.setString(1, naziv);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}