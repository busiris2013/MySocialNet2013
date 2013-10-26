package userforum

class Post {
	static belongsTo = [forum: Forum,tag: Tag]
    static constraints = {
    }
}
