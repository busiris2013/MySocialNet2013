package mysocialnet

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class UserControllerTests  extends grails.test.ControllerUnitTestCase {

    void setUp() {
        // Setup logic here
    }

    void tearDown() {
        // Tear down logic here
    }

    void testRegister() {
		def profile = mockFor(Profile)
		def parameters = [userName:"Jacinto", password:"kacinto", profile:profile]
		def invalidParameters = [userName:"Julian", password:"Julian", profile:profile]
		mockDomain(User,[new User(parameters)])
		
        
    }
}
