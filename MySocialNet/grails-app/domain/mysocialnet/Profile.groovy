package mysocialnet
import tastes.*
import mysocialnet.User
class Profile {
	 //byte[] photo
	 String name
	 String surname
	 String email
	 String bio
	static hasMany = [movies:Movie, tvSeries: TvSeries, novels: Novel, 
		musicAlbums: MusicAlbum] 
	static belongsTo = [user: User]
    static constraints = {
			name blank:false,maxSize:30
			surname blank:false, maxSize:70
			email blank:false, email:true
			bio size:10..80
	 }
	def Profile(CreateProfileCommand createProfileCommand) {
		name = createProfileCommand.getName()
		surname = createProfileCommand.getSurname()
		email = createProfileCommand.getEmail()
		bio = createProfileCommand.getBio()
	}
}
