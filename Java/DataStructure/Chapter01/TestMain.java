/**
 * 
 */
package DataStructure.Chapter01;

/**
 * @author 
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInt bInt = new BigInteger("123000");
		BigInt result = bInt.sub(new BigInteger("123489"));
		
		System.out.println(result);
	}
}
