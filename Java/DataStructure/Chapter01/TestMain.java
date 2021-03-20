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
		BigInt bInt = new BigInteger(0000000L);
		BigInt result = bInt.add(new BigInteger("000000000"));
		
		System.out.println(result);
	}
}
