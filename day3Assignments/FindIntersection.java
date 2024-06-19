package week1.day3Assignments;

public class FindIntersection {

	public static void main(String[] args) {
		int array1[] = { 3, 2, 11, 4, 6, 7 };
		int array2[] = { 1, 2, 8, 4, 9, 7 };
		System.out.println("Intersection of two arrays");
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					System.out.println(array1[i] + " equals to " + array2[j]);
				}

			}

		}

	}
}
