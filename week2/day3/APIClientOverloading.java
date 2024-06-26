package week2.day3Assignments;

public class APIClientOverloading {

	public void sendRequest(String endpoint) {
		System.out.println("Send Req with One Argument : " + endpoint);
	}

	public void sendRequest(String endpoint, String reqBody, Boolean reqStatus) {
		System.out.println("Send Req with Multiple Argument : " + endpoint + " -- " + reqBody + " -- " + reqStatus);
	}

	public static void main(String[] args) {
		APIClientOverloading OverLoad = new APIClientOverloading();
		OverLoad.sendRequest("Endpoint(1)");
		OverLoad.sendRequest("Endpoint(3)", "File requested", true);

	}

}
