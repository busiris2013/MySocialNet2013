package mysocialnet
import userforum.Forum
import userprivacy.*

@Mixin(Friend)
class User extends Sociable {
	private String  userName
	private String  password
	Profile profile
	PrivacyPolicy privacyPolicy = new PublicPrivacyPolicy()
	Forum   forum = new Forum()
	
	
	static hasMany= [friends: Friend]
	
	public receiveFriendShipRequest(User user) {}
	
	def setPrivacyPolicy(PrivacyPolicy privacyPolicy) {
			this.privacyPolicy = privacyPolicy
			forum.setPrivacyPolicy(privacyPolicy)
		}
	
	def User(UserCommand userCommand) {
		userName = userCommand.getUserName()
		password = userCommand.getPassword()
	}
	static constraints = {
		profile(nullable:true)
		privacyPolicy(nullable:true)
		forum(nullable:true)
	 }
}

