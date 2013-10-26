package mysocialnet
import userprivacy.*
class UserController {

    def index() { redirect(action:'register') }
	
	def register() {
		def user = new User(params)
		if (user.validate()) {
		user.save()
		println("user.id = ${user.id}")
		servletContext["user"] = user
		
		redirect (action:'selectPrivacyPolicy')
		
		
		} else {
		flash.message = "Error Registering User"
		[ user: user ]
		}
	}
	
	def list(Integer max) {params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]}
	def show(){flash.message = "succesfully created user"}

	def selectPrivacyPolicy() {
		def user =(User) servletContext.user
		def privacyPolicyType = ['private','semiPrivate','public']
		switch(params.privacyPolicy) {
			case 'private':	user.setPrivacyPolicy(new PrivatePrivacyPolicy())
			break
			case 'semiPrivate': user.setPrivacyPolicy(new SemiPrivatePrivacyPolicy())
			break
			case 'public':  user.setPrivacyPolicy(new PublicPrivacyPolicy() )
			break
		}
		if (user.validate()) {			
			flash.message = "Successfully Created User"
			
		}
		else {
			flash.message = "Error Registering User"
			[user:user]
		}
	}
}