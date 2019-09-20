package pet06_09;

public class Test {

	public static void main(String[] args) {
		Klasa k = new Klasa("jdbc:sqlite:C:\\Users\\david\\OneDrive\\Desktop\\SQL\\FudbalskiSavez.db");
		
		k.connect();
		//k.ispisSvihFudbalera();
		//k.igraciMU();
		//k.igracGolovi();
		//k.igracNajviseGolova();
		//k.kartoni();
		//k.gradovi(12);
		//k.gradoviGdeJeFudbalerIgrao(12);
		//k.ubaciFudbalera("Marko Jovic", 5);
		//k.ubaciTim("Valjevo", "Valjevo");
		//k.ubaciUtakmicu("Arsenal", "Inter", "1", "1", 2010);
		k.izbrisiTim("Milano");
		k.disconnect();
	}

}
