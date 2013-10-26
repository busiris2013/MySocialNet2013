package tastes



import grails.test.mixin.*
import org.junit.*
import mysocialnet.Profile

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Movie)
class MovieTests {

    void testValidation() {
		def profile = mockFor(Profile)
		def validParams = [profile: profile, title:"jjjj",sinopsis: "llllcccccccccccclllllll",
			director: "James Cameron", genre: "Science Fiction"]

		def validMovie = new Movie(validParams)
		
		assertTrue validMovie.validate()
		def invalidParams = [profile: profile, title:"jjjj",sinopsis: "llllcccccccccccclllllll",
			director: "James Cameron", genre: "Heavy Metal"]
		def invalidMovie = new Movie(invalidParams)
		assertFalse invalidMovie.validate()
    }
}
