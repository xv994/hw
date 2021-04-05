package DataStructure.Chapter02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import DataStructure.Chapter02.HTNode.Code;

/**
 * 哈夫曼树实现
 * @author
 *
 */
public class HuffmanTree {

	/**
	 * 哈夫曼编码
	 */
	protected Map<Character, String> code = null;
	
	/**
	 * 生成的huffman树根结点
	 */
	private HTNode tree = null;
		
	/**
	 * 根据初始的结点列表，建立哈夫曼树，
	 * 并生成哈夫曼编码，保存在当前类的code对象中，
	 * 生成的树根结点，被保存在当前类的tree对象中。
	 * 可以反复生成哈夫曼树，每次重新构建树，将更新编码
	 * @param nodes
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public HTNode buildTree(List<HTNode> nodes) throws CloneNotSupportedException{

		while (nodes.size() > 1){
			HTNode lchild = nodes.remove(findMinNode(nodes));
			HTNode rchild = nodes.remove(findMinNode(nodes));
			HTNode parentNode = new HTNode(lchild.getWeight() + rchild.getWeight(), lchild, rchild, false);
			nodes.add(parentNode);
	}
		this.tree = nodes.get(0);
		this.getCode();
		return this.tree ;
	}

	public int findMinNode(List<HTNode> nodes){
		HTNode temp = nodes.get(0);

		for (int i = 1; i < nodes.size(); i++){
			if (temp.compareTo(nodes.get(i)) > 0){
				temp = nodes.get(i);
			}
		}

		return nodes.indexOf(temp);
	}
	
	/**
	 * 根据已建立的哈夫曼树根结点，生成对应的字符编码，
	 * 字符编码应为0，1字符串
	 * @param tree
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public static Map<Character, String> getCode(HTNode tree) throws CloneNotSupportedException{

		HTNode tem = (HTNode)tree.clone();
		preprocess(tem);

		Map<Character, String> map = new HashMap<>();
		Queue<HTNode> queue = new LinkedList<>();
		boolean isFirst = true;

		queue.add(tree);

		while (!queue.isEmpty()){
			tree = queue.poll();

			if (tree != null){
				if (isFirst){
					isFirst = false;
				}
				else {
					tree.setPointCode(tree.getPointCode() + tree.getCode().getCode());
				}
				
				if (!tree.isLeaf()){
					tree.getLchild().setPointCode(tree.getPointCode());
					tree.getRchild().setPointCode(tree.getPointCode());
				}
				else {
					map.put(tree.getData(), tree.getPointCode());
				}

				queue.add(tree.getLchild());
				queue.add(tree.getRchild());
			}
			
		}

		return map;
	}

	public static void preprocess(HTNode tree){

		Stack<HTNode> stack = new Stack<>();

		while (tree != null || !stack.isEmpty()){
			if (tree != null){
				if (!tree.isLeaf()){
					tree.getLchild().setCode(Code.ZERO);
					tree.getRchild().setCode(Code.ONE);
				}
				stack.push(tree);
				tree = tree.getLchild();
			}
			else{
				tree = stack.pop();
				tree = tree.getRchild();
			}
		}
	}
	
	/**
	 * 获取已建立的哈夫曼树生成的字符编码，
	 * 字符编码应为0，1字符串
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public Map<Character, String> getCode() throws CloneNotSupportedException{
		this.code = HuffmanTree.getCode(this.tree);
		return this.code;
	}
	
	
	/**
	 * 统计字符串中字符出现的频率
	 * @param text
	 * @return
	 */
	public static Map<Character,Integer> computeCharCount(String text){

		Map<Character, Integer> map = new HashMap<>();
		char[] charArray = text.toCharArray();

		for (int i = 0; i < charArray.length; i++){
			// if ((charArray[i] >= 'a' && charArray[i] <= 'z') || (charArray[i] >= 'A' && charArray[i] <= 'Z')){
			// 	char tem = Character.toLowerCase(charArray[i]) ;
			char tem = charArray[i];
				if (map.containsKey(tem)){
					int temp = map.get(tem);
					map.put(tem, ++temp);
				}
				else{
					map.put(tem, 1);
				}
			// }
			
		}

		return map;
	}
	
	/**
	 * 使用当前类训练好的huffman编码来对文本进行编码
	 * @return
	 */
	public String encode(String text){
		char[] charArray = text.toCharArray();
		String str = "";
		for (int i = 0; i < charArray.length; i++){
			// Character.toLowerCase(charArray[i]);
			// if (charArray[i] <= 'z' && charArray[i] >= 'a')
			if(this.code.containsKey(charArray[i]))
				str += this.code.get(charArray[i]);
		}
		return str;
	}
	 
	/**
	 * 使用指定的huffman编码来对文本进行编码
	 * @return
	 */
	public static String encode(String text, Map<Character, String> code){

		char[] charArray = text.toCharArray();

		String HStr = "";
		for (int i = 0; i < charArray.length; i++){
			// Character.toLowerCase(charArray[i]);
			// if (charArray[i] <= 'z' && charArray[i] >= 'a')
				HStr += code.get(charArray[i]);
		}

		return HStr;
	}

	/**
	 * 使用当前类中训练好的huffman编码，
	 * 对编码后的文本进行解码
	 * @param text
	 * @return
	 */
	public String decode(String text){

		Map<String, Character> map = new HashMap<>();
		for (Character c : this.code.keySet()){
			String str = this.code.get(c);
			map.put(str, c);
		}

		char[] charArray = text.toCharArray();
		String str = "";
		String trueText = "";

		for (int i = 0; i < charArray.length; i++){
			str += charArray[i];
			if (map.containsKey(str)){
				trueText += map.get(str);
				str = "";
			}
		}

		return trueText;
	}
	
	public HTNode getTree() {
		return tree;
	}

	/**
	 * 使用预先建立好的huffman树，
	 * 对编码后的文本进行解码
	 * @param text
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public String decode(String text, HTNode tree) throws CloneNotSupportedException{

		Map<Character, String> newCode = HuffmanTree.getCode(tree);

		Map<String, Character> map = new HashMap<>();
		for (int i = 0; i < newCode.size(); i++){
			map.put(newCode.get(('a' + i)), (char)('a' + i));
		}

		char[] charArray = text.toCharArray();
		String str = "";
		String trueText = "";

		for (int i = 0; i < charArray.length; i++){
			str += charArray[i];
			if (map.containsKey(str)){
				trueText += map.get(str);
				str = "";
			}
		}
		
		return trueText;
	}


	public static void main(String[] args) throws CloneNotSupportedException{
		HuffmanTree htree = new HuffmanTree();
		//首先对字符串中的字符出现次数进行统计
		String data = "In computer science and information theory, "
				+ "a Huffman code is a particular type of optimal prefix code that is commonly used for lossless data compression. "
				+ "The process of finding and/or using such a code proceeds by means of Huffman coding, "
				+ "an algorithm developed by David A. Huffman while he was a Ph.D. student at MIT, and published in the 1952 paper "
				+ "\"A Method for the Construction of Minimum-Redundancy Codes\".[1] "
				+ "The output from Huffman's algorithm can be viewed as a variable-length code table for encoding a source symbol "
				+ "(such as a character in a file). The algorithm derives this table from the estimated probability or frequency of occurrence"
				+ " (weight) for each possible value of the source symbol. As in other entropy encoding methods, more common symbols are generally "
				+ "represented using fewer bits than less common symbols. Huffman's method can be efficiently implemented, "
				+ "finding a code in linear time to the number of input weights if these weights are sorted.[2] However, "
				+ "although optimal among methods encoding symbols separately, Huffman coding is not always optimal among all compression methods.";
		Map<Character, Integer> chars = HuffmanTree.computeCharCount(data);
		ArrayList<HTNode> nodes = new ArrayList<>();
		for(Character c : chars.keySet()){
			HTNode node = new HTNode();
			node.setData(c);
			node.setWeight(chars.get(c));
			node.setLchild(null);
			node.setRchild(null);
			node.setLeaf(true);
			nodes.add(node);
		}
		HTNode tree = htree.buildTree(nodes);
		Map<Character, String> code = HuffmanTree.getCode(tree);
		for(Character c : code.keySet()){
			System.out.println("字符'"+c+"'的哈夫曼编码："+code.get(c));
		}
		String text = "In computer science and information theory";
		String coded = htree.encode(text);
		System.out.println("字符串：In computer science and information theory");
		System.out.println("被编码为："+coded);
		String oriText = htree.decode(coded);
		System.out.println("编码："+coded);
		System.out.println("被解码为："+oriText);
		System.out.println(oriText.equals(text));
	}
}
