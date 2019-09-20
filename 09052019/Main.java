package cet05_09;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Studentska st = new Studentska("jdbc:sqlite:C:\\Users\\david\\OneDrive\\Desktop\\SQL\\studentskabaza.db");
		
		st.connect();
		//st.dodajStudenta(20140038, "Milos", "Peric", "06.07.2014.", "20.01.1995.", "Beograd");
		//st.izbrisiIspite();
		st.promenaDatumaRodjenja(20140026, "08.08.1999");
		//st.izdvojPodatke();
		//st.studentiIzBeograda("Beograd");
		//st.izdvojMesta();
		//st.bodovi();
		//st.izmedjuOIPbodova();
		//st.tacanBrojBodova();
		//st.tacanBrojBodova2();
		//st.cenaPredmeta();
		st.disconnect();
	}

}
