package tastes

class TvSeries extends Taste{
	String director	
	String genre
	static constraints = {
		director nullable:false
		genre inList: ValidGenres.validTvSeriesGenres
		
    }
}
