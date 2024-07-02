package week2.day4Assignments;

public class DBConcreteCls implements DatabaseConnection {

	@Override
	public void connect() {
		System.out.println("DB Connected");

	}

	@Override
	public void disconnect() {
		System.out.println("DB Disconnected");

	}

	@Override
	public void executeUpdate() {
		System.out.println("Execute & Update DB");

	}

	public static void main(String[] args) {

		DBConcreteCls db = new DBConcreteCls();
		db.connect();
		db.executeUpdate();
		db.disconnect();
	}

}
