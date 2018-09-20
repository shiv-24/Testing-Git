package codingPractice.gfg;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gfg.arrays.RotationOfAnArray;

public class TestingRotationOfAnArray {

	@Test
	public void test() {
		RotationOfAnArray obj		=	new RotationOfAnArray();
		int arr[]	=	{1,2,3,4,5,6,7};
		int outputArr[]	=	{3,4,5,6,7,1,2};
		
		obj.rotateWithoutSpace(arr, 2, 7);
		
		assertArrayEquals(outputArr, arr);
	}

}
