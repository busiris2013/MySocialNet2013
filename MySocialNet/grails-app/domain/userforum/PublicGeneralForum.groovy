package userforum
import userprivacy.*
class PublicGeneralForum extends Forum {
	
	private PublicPrivacyPolicy publicPrivacyPolicy = 
	new PublicPrivacyPolicy()
	
	private PublicGeneralForum() {}
	
	private static  def instance = null 
	
	static getInstance() {
		if(!instance)
			instance = 
			new PublicGeneralForum()
		instance
	} 
    
	static constraints = {
    }
}
