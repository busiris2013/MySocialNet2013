package mysocialnet
import userforum.Forum
import userprivacy.*

@Mixin(Friend)
class User extends Sociable {
	String  userName
	String  password
	Profile profile
	PrivacyPolicy privacyPolicy = new PublicPrivacyPolicy()
	Forum   forum = new Forum()
	
	
	static hasMany= [friends: Friend]
	
	public receiveFriendShipRequest(User user) {}
	
	def User(CreateUserCommand createUserCommand) {
		userName = createUserCommand.getUserName()
		password = createUserCommand.getPassword()
	}
	
	def setPrivacyPolicy(PrivacyPolicy privacyPolicy) {
		this.privacyPolicy = privacyPolicy
		forum.setPrivacyPolicy(privacyPolicy)
	}
	
	
	static constraints = {		
		userName(blank:false,unique:true,minSize:4)
		password(validator:{pswd, user -> pswd != user.userName})
		profile(nullable:true)
		privacyPolicy(nullable:true)
		forum(nullable:true)
	 }
}

