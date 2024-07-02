package week2.day4Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortUsingCollection {

	public static void main(String[] args) {
		
		//Declare array
		String[] arr = { "HCL", "Wipro", "Aspire Systems", "CTS" };
		//Declare array List to add values to List
		List<String> arr1 = new ArrayList<String>();
		/*
		 * arr1.addAll(Arrays.asList(arr)); System.out.println(arr1);
		 */
		//Using For each add array values to ArrayList
		for (String ls : arr) {
			arr1.add(ls);
		}
		//Sort the ArrayList
		Collections.sort(arr1);
		System.out.println("After Sorting ArrayList: "+arr1);
		//	Create new ArrayList to reverse the arraylist
		List<String> revlist = new ArrayList<String>();
		for (int i = arr1.size() - 1; i >= 0; i--) {

			revlist.add(arr1.get(i));

		}
		System.out.println("After Reversing ArrayList :" +revlist);

	}
}
