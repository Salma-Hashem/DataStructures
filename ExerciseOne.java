import java.util.Arrays;

public class ExerciseOne {
	//method that checks if one string is just the other string but reversed.  
	public static int reversed(String string1, String string2) {
		string1= string1.toLowerCase();
		string2= string2.toLowerCase();
		// in case of bad input with extra spaces, remove them with trim!
		string1=string1.trim().replaceAll("\\s+","");
		string2=string2.trim().replaceAll("\\s+","");
		int result=-1;//default 
		//if they are not the same length they cannot be the same string 
		if (string1.length() != string2.length()) {  
            System.out.println("False: They are not the same string reversed!");  
            result= 0;
        }  
        else {  
        
            char[] s1 = string1.toCharArray();  
            char[] s2 = string2.toCharArray();
            // check if two strings already equal each other. if theyre the same they can't be the reversed version... 
            if(Arrays.equals(s1, s2)== true) {
        			System.out.println("False! They are just the same word neither is reversed");
        			result=0;
            }
            else {
            		char[] reversed = new char[s2.length];
	            for (int i=0; i<s2.length; i++) {
	            		int j=s2.length-1-i; // it is s2.length-1 because index starts at zero, and it is -i as a way to decrement j since it is not a for loop for j
	            		reversed[i]= s2[j];
	            }
	            if(Arrays.equals(s1, reversed)== true) {
	            		System.out.println("True! They are the same word just one string is reversed");
	            		result=1;
	            }
	            else {
	            		System.out.println("False! They are not the same string reversed");
	            		result= 0;
	            }
            }
        }
		return result;
	}
	public static void main(String[] args) {
		String s1="google ";
		String s2="elgoog";
		System.out.println(reversed(s1,s2));

	}

}
