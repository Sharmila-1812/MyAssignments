package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 97;
		int count = 0;

		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				count++;
		}

		if (count == 0)
			System.out.println("The number " + n + " is prime");

		else
			System.out.println("The number " + n + " is not prime");
	}

}
