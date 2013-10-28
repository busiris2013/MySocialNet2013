package mysocialnet
import userprivacy.*


class CreateUserCommand {
	String  userName
	String  password
	static constraints = {
		userName(blank:false,unique:true,minSize:4)
		password(validator:{pswd, user -> pswd != user.userName})
	}
}

class CreateProfileCommand {
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
	
    def index() { def createUserCommand = new CreateUserCommand()
		def createProfileCommand = new CreateProfileCommand()
		render view: "register", model:
		[createProfileCommand:createProfileCommand,
			createUserCommand: createUserCommand] }
	
	def register(CreateUserCommand createUserCommand, 
		CreateProfileCommand createProfileCommand) {
		servletContext["createUserCommand"] = createUserCommand
		servletContext["createProfileCommand"] = createProfileCommand
		render view:"selectPrivacyPolicy"
		
	}
	def list(Integer max) {params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]}
	def show(){flash.message = "succesfully created user"}

	def selectPrivacyPolicy() {
			servletContext["createUserCommand"] = servletContext.createUserCommand
			servletContext["createProfileCommand"] = servletContext.createProfileCommand
			servletContext["privacyPolicy"] = params.privacyPolicy
			redirect action:"createUser"
		}
		
	def createUser() {
		def createUserService = new CreateUserService()
		def createUserCommand = servletContext.createUserCommand
		def createProfileCommand = servletContext.createProfileCommand
		def privacyPolicy = servletContext.privacyPolicy
		 def user = createUserService.createUser(createUserCommand, 
			 createProfileCommand, privacyPolicy)
		  if (createUserService.saveUser(user)) render view:"home", model:[user:user]
		  else flash.message = "error registering user"
	}
		
	def home(User user) {
		
	}
}