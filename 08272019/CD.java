package uto27_08;

public final class CD extends AlbumArtikal{

	public CD(Album album, String izdavac, double cena, int kolicina) {
		super(album, izdavac, cena, kolicina);
	}

	@Override
	public String ime() {
		return getAlbum().getIzvodjac() + " - " + getAlbum().getNaziv() + "(CD)";
	}

}
