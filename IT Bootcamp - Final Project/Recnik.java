package ZavrsniRad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class Recnik {
	private HashMap<String, Integer> sveReci;
	private String connectionString;
	private Connection con;
		
	public Recnik() {
		connectionString = "jdbc:sqlite:C:\\Users\\User\\Desktop\\dsrZavrsni\\Dictionary.db";
		sveReci = new HashMap<String, Integer>();
		popuniRecnik();
		kreirajTabelu();
		dvadesetNajviseKoriscenih();
	}
	
	public void popuniRecnik() {
		try {
			connect();
			PreparedStatement ps = con.prepareStatement("SELECT word FROM entries");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sveReci.put(rs.getString(1).toLowerCase(), 0);
			}
			ps.close();
			disconnect();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean postojiRec(String rec) {
		if(sveReci.containsKey(rec.toLowerCase()))
			return true;
		else
			return false;
	}
	
	public void kreirajTabelu() {
		try {
			connect();
			PreparedStatement ps = con.prepareStatement("CREATE TABLE \"NoveReci\" ( \"word\"	TEXT NOT NULL, PRIMARY KEY(\"word\") );");
			ps.executeUpdate();
			ps.close();
			disconnect();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ubaciNoveReci(String rec) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO NoveReci VALUES (?)");
			ps.setString(1, rec);
			ps.executeUpdate();
			ps.close();
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
				if(con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public HashMap<String, Integer> getSveReci() {
		return sveReci;
	}
	
	public void setSveReci(String key) {
		int newValue = sveReci.get(key) + 1;
		sveReci.replace(key, newValue);
	}
	
	public void dvadesetNajviseKoriscenih() {
		Map<String, Integer> sorted = sveReci.entrySet().stream().sorted(comparingByValue())
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

		sorted = sveReci.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.limit(20).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		for (String s : sorted.keySet()) {
			System.out.println(s + " " + sorted.get(s));
		}
	}
}
