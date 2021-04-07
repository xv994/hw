/**
 * 
 */
package DataStructure.Chapter03.src.search;

import java.util.List;

import DataStructure.Chapter03.src.index.Indexer;

/**
 * @author
 *
 */
public interface Searcher {
	/**
	 * 对索引进行查询，
	 * 查找同时匹配words中单词的文档编号，
	 * 并至多返回results个结果，若results小于等于0，则返回所有结果.
	 * 若索引中没有同时包含words中所有单词的文档，则返回null
	 * @param index
	 * @param words
	 * @param results
	 * @return
	 */
	public int[] search(Indexer index, List<String> words, int results);
}
