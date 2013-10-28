package tastes

class MusicAlbum extends Taste {
	String artist
	String genre
    static constraints = {		
		artist blank:false, size:4..20
		genre inList: ValidGenres.validMusicAlbumGenres
  }
}
