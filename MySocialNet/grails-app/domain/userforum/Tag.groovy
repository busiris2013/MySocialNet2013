package userforum

class Tag {
	static belongsTo = [forum:Forum]
	static hasMany = [posts: Post]
    static constraints = {
    }
}
