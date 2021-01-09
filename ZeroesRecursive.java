
public class ZeroesRecursive {
	// recursive algorithm that counts number of zeros in binary representation of N
	public static int countZ(int N) {
		//N is the sum of powers of 2
		int count=0;
		//base condition-- if N is 0, binary value is 0, so it is one 0
		if (N==0) {return 1;}
		//by logic, If N is 1 it doesn't have a 0 so only check until N is 2 bc it reduces number of iterations
		while( N>1) {
			//if current bit is 0 increment count
			// N mod 2 finds the last bit. 0 is even and 1 is odd so to just N%2 indicates its even or 0
			int bit=N%2;
			if(bit==0) {
				count++;
			}
			System.out.println(N);
			//dividing by 2 shifts it to the left. equivalent to going from 2^3 to 2^2
			countZ(N/=2);
			
		}
		return count;
	}
	public static void main(String[] args) {
		int N = 16;
		System.out.println(countZ(N));
	}
}
