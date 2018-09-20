package codingPractice.gfg;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gfg.arrays.SearchElementInSortedAndRotatedArray;

public class TestingSearchElementClass {

	@Test
	public void test() {
		SearchElementInSortedAndRotatedArray obj	=	new SearchElementInSortedAndRotatedArray();
		int arr[]	=	{1,2,3,4,5,6,7,8};
		int x	=	5;
		
		int output	=	obj.binarySearchGfg(arr, x, 0, 7);
		assertEquals(4,output);
		System.out.println("Test Case 1 Over");
		
		x=9;
		output	=	obj.binarySearchGfg(arr, x, 0, 7);
		assertEquals(-1, output);
		System.out.println("Test Case 2 Over");
	}

}
