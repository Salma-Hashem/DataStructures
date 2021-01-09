package cs102_rec3;

public class Sum {
	public static int recursivesum(int[] array,int n){
		// if array is empty sum is 0
		if(n<0) 
			return 0;
		//check if n is even	or n is negative
		if(array[n]%2==0 || array[n]<0)
			return array[n]+recursivesum(array,n-1);
		else
			return recursivesum(array,n-1);
	}

	public static void main(String[] args) {
		int sum=0;
		int[] array= {1, -3, 10, 50, 1};
		sum=recursivesum(array, array.length-1);//call function and print result
		System.out.println(sum);
		

	}

}
