package week2.day4Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingNumberUsingList {
	public static void main(String[] args) {
		//Declare array
		int[] arr = { 1, 2, 3, 4, 10, 6, 8, 11, 18, 100 };
		//Create ArrayList to add all values from array
		List<Integer> numbers = new ArrayList<Integer>();
		for (Integer ls : arr) {
			numbers.add(ls);
		}
		//Find Missing Elements in ArrayList
		for (int i = 0; i < numbers.size() - 1; i++) {
			int num1 = numbers.get(i);
			int num2 = numbers.get(i + 1);
			int diff = num2 - num1;
			while (diff > 1) {
				int missingElement = ++num1;
				System.out.println("\n" + "Missing Element in given ArrayList: " + missingElement);
				numbers.add(missingElement);
				Collections.sort(numbers);
				break;
			}
		}

	}

}
