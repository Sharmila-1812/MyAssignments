package week2.day4Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {

	public static void main(String[] args) {
		//Declare array
		int[] arr={3, 2, 11, 4, 6, 7,10};
		//Arrays.sort(arr);
		//Declare ArrayList to add all values
		List<Integer> ls=new ArrayList<Integer>();
		for(int arr1:arr) {
			ls.add(arr1);
		}
		//Sort the ArrayList
		Collections.sort(ls);  
		System.out.println("After Sorting : "+ls);
		//Get the Size of ArrayList
		int size=ls.size();
		int Largest = ls.get(size-2);
		System.out.println("Second Largest : "+Largest);
}
}