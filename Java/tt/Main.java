/**
 * 
 */
package tt;
import java.util.Scanner;

/**
 * @author 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("\nWelcome!");
		BigInteger aInt = new BigInteger("-100");
		// BigInteger bInt = new BigInteger(-10L);
		BigInt result = aInt.add(new BigInteger("-1"));
		System.out.println(result);
	}
}
