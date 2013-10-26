package tastes

class Movie extends Taste {
	String  director
	String genre
    static constraints = {
		director blank:false
		genre blank:false, inList: ValidGenres.validMovieGenres() 	
    }
}
