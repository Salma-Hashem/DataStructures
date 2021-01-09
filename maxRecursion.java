
public class maxRecursion {
	
	public static int binaryMax(int[] data, int low, int high) {
		//to maintain OOP design, return once by setting a variable max that tracks return value!
		int max;
		// if there are zero elements in the array... return 0? 
		if (low>high)
			max= 0;
		//if there is one element return that one element
		else if(low==high) 
			max= data[low];
		//if there are multiple elements 
		else {
			int mid=(low+high)/2;
			max=binaryMax(data,low,mid); // default to initialize max not true 
			if(binaryMax(data,low,mid)< binaryMax(data,mid+1,high)) 
				max=binaryMax(data,mid+1,high);
		}
		return max;
	}
	
	public static void main(String[] args) {
		//find max of first half then max of second half of array and compare the two to find the max of whole array!
		int[] array= {20,87,30,53,44};
		System.out.println("Max value in array: " + binaryMax(array,0,array.length-1));
		

	}

}
