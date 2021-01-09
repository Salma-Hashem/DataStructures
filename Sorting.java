
public class Sorting {
	//BUBBLE SORT NON-RECURSIVE
	public static void bubbleSort(int a[]) {
		int length= a.length;
		//int tmp=0;// null number until it gets replaced in the loop
		//for loop to swap elements
		for(int i=0; i<length-1; i++) {
			for(int j=0; j<length-(i+1); j++) {
				//if lower element is greater than element at greater index then swap
				if(a[j]> a[j+1]) {
					//swap elements
					int tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}
			}
		}	
	}//end bubbleSort algorithm
	
	//BUBBLE SORT RECURSIVE
	public static void bubbleSortR(int a[], int n) {
		//base case
		if (n==0) {return;}
		//n is length, which is inputed 
		for(int i=0; i<n; i++) {
			if(a[i]> a[i+1]) {
				int tmp=a[i];
				a[i]=a[i+1];
				a[i+1]=tmp;
			}
			bubbleSortR(a, n-1);
		}
		
	}
	
	//SELECTION SORT NON-RECURSIVE
	public static void selectionSort(int[] a) {
		int tmp;
		int length = a.length;
		for (int i = 0; i < length; i++){
			int min_index = i;
			for (int j = i + 1; j < length; j++){
				if (a[j] < a[min_index])
					min_index = j;
			}
			tmp = a[min_index];
			a[min_index] = a[i]; //swap
			a[i] = tmp;
		}
	}
	//INSERTION SORT NON-RECURSIVE
	public static void insertionSort(int a[]){
		//divide into two parts: Sorted and Unsorted
		for (int i=1; i<a.length;i++) {
			int j=i;
			int tmp= a[i];
			while(j>0 && a[j-1]>tmp) {
				a[j]=a[j-1];
				j--;
			}
			a[j]=tmp;
		}
	}
	
	//MERGE SORT RECURSIVE
	//merge sort for the merge sort recursive 
	public static void merge( int[ ] a, int left1, int l1, int[ ] b, int left2, int l2, int[] sorted, int left3){
		//declare and initialize index to index of first element in each array
		int i_index= left1;
		int j_index=left2;
		int k_index=left3;
		//sort and merge two arrays
		while(i_index <= l1 && j_index <= l2) {
			if( a[i_index] <= b[j_index] ) {
				sorted[k_index]=a[i_index]; i_index++;
			}
			else {
				sorted[k_index]= b[j_index];j_index++;
			}
			k_index++;
		}
		//checks which array has leftovers and copies it over
			while (i_index <= l1) {sorted[k_index]=a[i_index]; i_index++; k_index++;}
			while (j_index<= l2) {sorted[k_index]=b[j_index]; j_index++; k_index++;}
	}
	//mergesort algorithm RECURSIVE
	public static void mergesort(int [ ] a, int[ ] b, int left, int right){
		if (left==right) {b[left] = a[left]; return ;}
		else {
			int mid = (left+right)/2;
			int [] Z = new int[right+1]; //declare and intialize array Z with size right+1
			mergesort(a,Z,left,mid);// sort left half of b and place in left half of Z
			mergesort(a,Z,mid+1,right);// sort right half of b and place in right half of Z
			merge(Z,left,mid, Z,mid+1,right, b,left);// sort right and left sides of Z and placing them in b
		}
	}
	//QUICK SORT RECURSIVE
	//assume pivot is a number. thus assume array is an int 
		public static int partition(int[] data, int pivot, int low, int high) {
			//find index of pivot since it can be located anywhere in the array
			int p_index;// declare index of pivot
			// for loop to find index of pivot and swap it with number at lowest index
			for(int i=low; i<high; i++) {
		         if(data[i] == pivot) {
		        	 	p_index = i;
		        	 	int temp= data[low];
		        		data[low]= data[p_index];
		        		data[p_index]= temp;	
		         }	
			}
			//set pivot index to low which is 0 since we just swapped the pivot with value at index 0
			p_index=low;
			
			//set at index after pivot therefore, low+1
			int i_index= low+1 ; //added 1 
			
			//set at end of array 
			int j_index= high ;
			
			// while loop to sort elements 
			while (j_index >= i_index) {
				
				while (data[i_index]< data[p_index])
					++i_index;
				while (data[j_index]> data[p_index])
					--j_index;
				if (i_index < j_index){
					int temp= data[i_index];
					data[i_index]= data[j_index];
					data[j_index]= temp;
				}
			}
			
			//swap pivot with element at data[j_index] 
			int temp=data[p_index];
			data[p_index]= data[j_index];
			data[j_index]= temp;
			temp=p_index;
			p_index=j_index;
			j_index=temp;
			
			//return p_index
			return p_index;
		}
		
		// recursive QuickSort Algorithm 
		static void Quicksort(int [] data, int low, int high){
		
			if (low< high) {			
				//set pivotlocation by calling partition;
				int pivotlocation = partition(data,30, low, high);
				Quicksort(data,low, pivotlocation-1);
				Quicksort(data, pivotlocation+1, high);
			}		
		}
		public static void display(int[] array) {
			for (int i=0; i<array.length; i++) {
				System.out.print(array[i]+" ");
			}
		}
		
		public static void main(String[] args) {
			//bubble sort non-recursive 
			System.out.println("bubble sort non-recursive: ");
			int[] array0= {4,77,98,30,20,50,77,22,49,2};
			bubbleSort(array0);
			display(array0);
			System.out.println();
			//bubble sort recursive
			System.out.println("bubble sort recursive");
			int[] array={4,77,98,30,20,50,77,22,49,2};
			bubbleSortR(array, array.length-1);
			display(array);
			System.out.println();
			//selection
			System.out.println("Selection sort non-recursive: ");
			int[] array1= {4,77,98,30,20,50,77,22,49,2};
			selectionSort(array1);
			display(array1);
			System.out.println();
			//Insertion
			System.out.println("Insertion sort non-recursive: ");
			int[] array2= {4,77,98,30,20,50,77,22,49,2};
			insertionSort(array2);
			display(array2);
			System.out.println();
			//merge
			System.out.println("Merge sort Recursive: ");
			int[] array3= {4,77,98,30,20,50,77,22,49,2};
			int[ ] b= new int[array3.length];
			mergesort(array3,b,0,array3.length-1 );
			display(b);
			System.out.println();
			//Quick
			System.out.println("Quick sort Recursive: ");
			int[] array4= {4,77,98,30,20,50,77,22,49,2};
			Quicksort(array4, 30, array4.length-1);
			display(array4);
			
		}
}
