
public class Palindrome {
	public static String isPalindrome(String word, int low, int high) {
		word =word.toLowerCase();
		//store result to reduce # of returns 
		String result="";
		if(word.length()==1) {
			result= "True! it is a palindrome";
		}
		//while the highest index is not less than lower
		while(high>low) {
			//check if the characters equal each other
			if ((word.charAt(low)) != (word.charAt(high)))
				result= "False! It is not a Palindrome!";
			else {
				result="True! It is a Palindrome!";
			}
			// check first and last index then check the first+1 and last-1 and so on
			low++;
			high--;
			isPalindrome(word,low,high);
		}
	return result;			
	}
	public static void main(String[] args) {
		String word="byeb";
		String word2= "tacocat";
		String word3= "kayak";
		String word4= "Radar";
		String word5= "Dad";
		System.out.println("Is "+ word + " a Palindrome? "+ isPalindrome(word,0,word.length()-1));
		System.out.println("Is "+ word2 + " a Palindrome? "+ isPalindrome(word2,0,word2.length()-1));
		System.out.println("Is "+ word3 + " a Palindrome? "+ isPalindrome(word3,0,word3.length()-1));
		System.out.println("Is "+ word4 + " a Palindrome? "+ isPalindrome(word4,0,word4.length()-1));
		System.out.println("Is "+ word5 + " a Palindrome? "+ isPalindrome(word5,0,word5.length()-1));
	}

}
