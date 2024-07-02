package week2.day4Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FindIntersectionUsingList {
	public static void main(String[] args) {
		//Declare two arrays
		int array1[] = { 3, 2, 11, 4, 6, 7 };
		int array2[] = { 1, 2, 8, 4, 9, 7 };
		//Create two ArrayList to get values of array
		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();
		for (Integer ls1 : array1) {
			arr1.add(ls1);
		}
		for (Integer ls2 : array2) {
			arr2.add(ls2);
		}
		Collections.sort(arr1);
		System.out.println("Array 1 :" + arr1);
		Collections.sort(arr2);
		System.out.println("Array 2 :" + arr2);
		System.out.println("-------Intersection of two arrays-------");
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				if (arr1.get(i).equals(arr2.get(j))) {
					System.out.println(arr1.get(i) + " equals to " + arr2.get(j));
				}
			}

		}
	}
}
