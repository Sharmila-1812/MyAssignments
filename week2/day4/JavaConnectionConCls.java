package week2.day4Assignments;

public class JavaConnectionConCls extends MySqlConnectionAbsCls{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("DB connected to Java Connection Class");
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("DB disconnected from Java Connection Class");
	}

	@Override
	public void executeUpdate() {
		// TODO Auto-generated method stub
		System.out.println("DB executed and updated the Java Connection Class");
	}
	
	public static void main(String[] args) {
		MySqlConnectionAbsCls ab = new JavaConnectionConCls();
		ab.connect();
		ab.executeQuery();
		ab.executeUpdate();
		ab.disconnect();
	
	}
}
