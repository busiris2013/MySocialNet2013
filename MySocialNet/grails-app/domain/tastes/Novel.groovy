package tastes

class Novel extends Taste{
	String author
	String genre 
	
    static constraints = {
		author blank:false, size:4..20
		genre inList: ValidGenres.validNovelGenres()
   }
}
