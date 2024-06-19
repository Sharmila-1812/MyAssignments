package week1.day2Assignments;

public class IsPalindrome {

	public static void main(String[] args) {
	
		int output = 0;
		int input = 12321;
		for (int i = input; i > 0;i=i/10) {
			int rem = i % 10;
			output = (output * 10) + rem;

		}

		if (input == output)
			System.out.println(input + " is Palindrome");
		else
			System.out.println(input+ " is not a Palindrome");
	}

}
