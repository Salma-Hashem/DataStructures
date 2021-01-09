

public class ExerciseTwo {
	public static void shortString(String string1) {
		//method that takes a string and splits it into an array with STRINGs that must be larger than three and multiples of 3 so evenly divided
		// split string and put in array of strings. Split at whitespace so it is every word
		// in case of bad input with extra spaces between words or at end or beginning, remove white space
		String[] string = string1.trim().split("\\s+",-1); 
		//new array
		String[] last= new String[string.length/3];
		// check if array length is greater than 3 and divisible by 3 if not send error message and do not proceed
		if(string.length<=3 || string.length%3!=0) {
			System.out.println("ERROR: Number of strings in sentence must be greater than 3 and must be a multiple of 3");
		}
		else {
			//iterate through every 3 elements then compare length of each element and see which is shortest or if equal use first occurrence and add it to new array 
			for (int i=0; i<string.length; i=i+3) {
				int j=i/3;
				if(string[i].length()<=string[i+1].length() && string[i].length()<=string[i+2].length()) {
					last[j]=string[i];
				}
				else if(string[i+1].length()<string[i].length() && string[i+1].length()<=string[i+2].length()){
					last[j]=string[i+1];
				}
				else if(string[i+2].length()<string[i].length() && string[i+2].length()<string[i+1].length()){
					last[j]=string[i+2];
				}
			}
			//print array!
			for (int i=0; i<last.length; i++) {
				System.out.print(last[i]+" ");
			}
		}
	}
	public static void main(String[] args) {
		
		String string1= "Other entrie include a historic district in Charlottesville Virginia cut-flower greenhouse";
		
		shortString(string1);
	}

}
