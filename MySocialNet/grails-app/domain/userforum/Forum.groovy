package userforum
import userprivacy.*
import mysocialnet.User
class Forum {
    PrivacyPolicy  privacyPolicy = new PublicPrivacyPolicy()
	
	static belongsTo = [User]
	static hasMany = [posts: Post]
	static constraints = {
    }
}
