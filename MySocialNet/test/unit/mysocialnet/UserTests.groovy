package mysocialnet



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

    void testCreateUser() {
		def profile = mockFor(Profile)
		def parameters = [userName:"Jacinto", password:"kacinto", profile:profile]
        def user = new User(parameters)
		mockForConstraintsTests(User, [ user])
		assertNotNull user
		assertEquals user.userName, "Jacinto"
		assertEquals user.password, "kacinto"
		assertTrue user.validate()
		def invalidParameters = [userName:"Julian", password:"Julian", profile:profile]
		def invalidUser = new User(invalidParameters)
		mockForConstraintsTests(User, [ invalidUser])
		assertFalse invalidUser.validate()
		user.save()
 		def duplicateUser = new User(parameters)
 		mockForConstraintsTests(User, [ duplicateUser])
		assertFalse duplicateUser.validate()
		user.delete()
		assertTrue duplicateUser.validate()
    }
}
