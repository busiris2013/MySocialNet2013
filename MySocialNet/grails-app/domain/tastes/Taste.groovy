package tastes
import mysocialnet.Profile

abstract class Taste {
	String title
	String sinopsis
	def abstract  validGenreNamesList
	static belognsTo = [profile: Profile]
    static constraints = {
		title blank: false, size:3..20
		sinopsis blank:false, size:20..40	  
    }
}
