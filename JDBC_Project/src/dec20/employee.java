package dec20;

class user{
	private int uid;
	private String uName;
	public user(int uid, String uName) {
		super();
		this.uid = uid;
		this.uName = uName;
	}
	@Override
	public String toString() {
		return "user [uid=" + uid + "]";
	}
	
	
}

public class employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  user emp1 = new user(11, "parag");
	  System.out.println(emp1);

	}

}
