package week1.day2Assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Fibonacci Series");
		int a = 0, b = 1, temp, range = 8;
		System.out.print(a + " " + b);

		for (int i = 0; i < range; i++) {
			temp = a + b;
			System.out.print(" " + temp);
			a = b;
			b = temp;

		}

	}
}
