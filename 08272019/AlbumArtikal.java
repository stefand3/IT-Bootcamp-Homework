package uto27_08;

public abstract class AlbumArtikal extends Artikal{
	private String izvdavac;
	private Album album;
	
	public AlbumArtikal(Album album, String izdavac, double cena, int kolicina) {
		super(cena, kolicina);
		this.album = album;
		this.izvdavac = izdavac;
	}
	
	public abstract String ime();

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}
