package DataStructure.Chapter02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) throws CloneNotSupportedException {

        HuffmanTree htree = new HuffmanTree();
        
        // String data = "In computer science and information theory, "
		// 		+ "a Huffman code is a particular type of optimal prefix code that is commonly used for lossless data compression. "
		// 		+ "The process of finding and/or using such a code proceeds by means of Huffman coding, "
		// 		+ "an algorithm developed by David A. Huffman while he was a Ph.D. student at MIT, and published in the 1952 paper "
		// 		+ "\"A Method for the Construction of Minimum-Redundancy Codes\".[1] "
		// 		+ "The output from Huffman's algorithm can be viewed as a variable-length code table for encoding a source symbol "
		// 		+ "(such as a character in a file). The algorithm derives this table from the estimated probability or frequency of occurrence"
		// 		+ " (weight) for each possible value of the source symbol. As in other entropy encoding methods, more common symbols are generally "
		// 		+ "represented using fewer bits than less common symbols. Huffman's method can be efficiently implemented, "
		// 		+ "finding a code in linear time to the number of input weights if these weights are sorted.[2] However, "
		// 		+ "although optimal among methods encoding symbols separately, Huffman coding is not always optimal among all compression methods.";


        String data = "aaaabbbccd";

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
        System.out.println();

    }
}
