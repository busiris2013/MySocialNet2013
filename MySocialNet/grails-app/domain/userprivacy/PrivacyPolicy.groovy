package userprivacy
import mysocialnet.User
import userforum.Forum

abstract class PrivacyPolicy {
	static belongsTo = [User, Forum]
	static constraints = {
    }
}
