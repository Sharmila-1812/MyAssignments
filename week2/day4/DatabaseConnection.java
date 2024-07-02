package week2.day4Assignments;

public interface DatabaseConnection {
	abstract void connect();
	abstract void disconnect();
	abstract void executeUpdate();

}
