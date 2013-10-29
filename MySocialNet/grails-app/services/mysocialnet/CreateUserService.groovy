package mysocialnet

import userprivacy.*

class CreateUserService {

    def User createUser(CreateUserCommand createUserCommand, 
			 CreateProfileCommand createProfileCommand, 
			 String  privacyPolicy) {
			def user = new User(createUserCommand)
			def profile = new Profile(createProfileCommand) 
			user.setProfile(profile)
			switch(privacyPolicy) {
				case 'private': 
					user.setPrivacyPolicy(new PrivatePrivacyPolicy())
				case 'semiPrivate':
					user.setPrivacyPolicy(new SemiPrivatePrivacyPolicy())
				case 'public':
					user.setPrivacyPolicy(new PublicPrivacyPolicy()) 
			}
			user
		}
			def Boolean saveUser(User user) {
				def succesfulSave = user.validate()
				if(succesfulSave) user.save()
				succesfulSave
			}
			 
}
