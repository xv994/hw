/**
 * 
 */
package DataStructure.Chapter03.src.index;

/**
 * 索引构建程序接口
 * @author
 *
 */
public interface Indexer {
	/**
	 * 向索引中添加一个<文档-词>索引单元。
	 * @param docId
	 * @param word
	 * @param wf
	 */
	public void index(int docId, String word);
	
	/**
	 * 对索引进行搜索，如果有匹配的结果，
	 * 则返回该单词的倒排列表，若没有匹配的单词，则返回null
	 * @param word
	 * @return 倒排列表，以文档id为内容的数组
	 */
	public int[] search(String word);
}