package mysocialnet
import userprivacy.*

class UserCommand {
	String userName
	String password
		
	static constraints = {
	userName blank:false,unique:true,minSize:4
	password validator:{pswd, user -> pswd != user.userName}
	}
}

class ProfileCommand {
	String name
	String surname
	String email
	String bio
	static constraints = {
	name blank:false,maxSize:30
	surname blank:false, maxSize:70
	email blank:false, email:true
	bio size:10..80
	}
}



class UserController {

	
	
    def index() { render view:"register" }
	
	def register() {
		def userCommand = new UserCommand([userName:params.userName,password:
			 params.password])
		def profileCommand = new ProfileCommand([name: params.name, surname: 
			params.surname, email: params.email,bio: params.bio]) 
		
		servletContext["userCommand"] = userCommand
		servletContext["profileCommand"] = profileCommand
		render view:"selectPrivacyPolicy"
		
		
		
	}
	
	def list(Integer max) {params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]}
	def show(){flash.message = "succesfully created user"}

	def selectPrivacyPolicy() {
		servletContext["userCommand"] = servletContext.userCommand
		servletContext["profileCommand"] = servletContext.profileCommand
		servletContext["privacyPolicy"] = params.privacyPolicy
		redirect action:'createUser'
	}
		
	def createUser() {
		def userService = new CreateUserService()
		def user = userService.createUser(servletContext.userCommand,
			servletContext.profileCommand,
			servletContext.privacyPolicy)
		if (user.validate()) {
			user.save()
			render view:"home" 
		}
		else {
			flash.message = "Error registering User"
			render view: 'error'
		}
	}
	
	def home() {
		 
	}
//		def userFullName = servletContext.user.getProfile().getName() +
//		" " + servletContext.user.getProfile().getSurname()
	
}