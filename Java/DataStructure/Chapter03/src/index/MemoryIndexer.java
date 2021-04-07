/**
 * 
 */
package DataStructure.Chapter03.src.index;

/**
 * 基本的倒排索引需要包含两部分，
 * 词典以及倒排列表，
 * 这两部分是分开的：
 * 词典可以使用多种结构实现，如哈希＋链表，或者B+树
 * 倒排列表则是一个整数数组
 * @author 
 *
 */
public class MemoryIndexer implements Indexer {
	
	@Override
	public void index(int docId, String word) {
		
	}

	@Override
	public int[] search(String word) {
		return null;
	}

	/**
	 * 初始化词典，根据指定的槽数作为参数，但不可以小于50
	 * @param buckets
	 */
	public MemoryIndexer(int buckets){
		//TODO
	}
	
	/**
	 * 初始化词典，哈希表的槽数取默认值
	 * @param buckets
	 */
	public MemoryIndexer(){
		new MemoryIndexer(100);
	}	
}
