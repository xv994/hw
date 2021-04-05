package DataStructure.Chapter02;

public class HTNode implements Comparable<HTNode>, Cloneable{
	public enum Code{
		ZERO('0'), ONE('1');
		private char code;
		private Code(char c){
			this.code = c;
		}
		public char getCode(){
			return code;
		}
	}
	
	/**
	 *  哈夫曼树的叶子结点数据
	 */
	private char data;
	/**
	 * 结点的编码，只有0和1两种可能
	 */
	private Code code = Code.ZERO;
	
	public static final char ZERO = '0';
	public static final char ONE = '1';
	
	private double weight;
	private HTNode lchild = null;
	private HTNode rchild = null;
	private boolean isLeaf = true;
	private String pointCode = "";

	public HTNode(){}
	public HTNode(double weight, HTNode lchild, HTNode rchild, boolean isLeaf){
		this.weight = weight;
		this.lchild = lchild;
		this.rchild = rchild;
		this.isLeaf = isLeaf;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public HTNode getLchild() {
		return lchild;
	}

	public void setLchild(HTNode lchild) {
		this.lchild = lchild;
	}

	public HTNode getRchild() {
		return rchild;
	}
	public void setRchild(HTNode rchild) {
		this.rchild = rchild;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	@Override
	public int compareTo(HTNode o) {
		if(this.weight<o.weight){
			return -1;
		}else{
			return 1;
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		return (HTNode)super.clone();
	}
	public String getPointCode() {
		return pointCode;
	}
	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	} 
}