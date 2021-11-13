public class User {
	int id;
	String name;
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			return this.getId() == ((User)obj).getId();
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return getId();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1 = new User(1001,"πÊ≈∫¿Ã ");
		User user2 = new User(1001, "πÊ≈∫¿Ã");
		
		System.out.println("user1.equals(user2):" + user1.equals(user2));
		System.out.println("user1.hashCode()):" + user1.hashCode());
		System.out.println("user2.hashCode():" + user2.hashCode());
		System.out.println("System.identityHashCode(user1):" + System.identityHashCode(user1));
		System.out.println("System.identityHashCode(user2):" + System.identityHashCode(user2));
		
	}

}
