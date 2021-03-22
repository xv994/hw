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
		BigInt bInt = new BigInteger(00000001L);
		BigInt result = bInt.add(new BigInteger("9999999999999999999999999999999999"));
		
		System.out.println(result);
	}
}
