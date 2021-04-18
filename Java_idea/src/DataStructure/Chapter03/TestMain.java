///**
// *
// */
//package DataStructure.Chapter03;
//
//import java.io.IOException;
//import java.nio.file.DirectoryIteratorException;
//import java.nio.file.DirectoryStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.Set;
//
//import DataStructure.Chapter03.src.index.Indexer;
//import DataStructure.Chapter03.src.corpus.ReadFile;
//import DataStructure.Chapter03.src.index.MemoryIndexer;
//import DataStructure.Chapter03.src.search.MemorySearcher;
//import DataStructure.Chapter03.src.search.Searcher;
//
///**
// * @author
// *
// */
//public class TestMain {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		//构建索引时，对语料库中的文件逐个处理
//		Path corpus = Paths.get("corpus");//取出语料库文件路径
//		Indexer index = null;
//		try (DirectoryStream<Path> stream = Files.newDirectoryStream(corpus)) {
//			int docId;
//			//TODO 这里可以根据需要调整
//			index = new MemoryIndexer(200);
//			for (Path file : stream) {
//				try{
//					docId = Integer.parseInt(file.getFileName().toString());
//				}catch (NumberFormatException x){
//					//若语料目录中存在非数字文件名的文件，则跳过这些文件
//					continue;
//				}
//				//1）先读取语料中的文件，依次分词，去除停用词
//				Set<String> words = ReadFile.parseFile(file);
//				//2）从语料中读取出来的结果，以<DocId,Word>的形式交给索引构建程序
//				for(String word : words){
//					index.index(docId, word);
//				}
//			}
//		} catch (IOException | DirectoryIteratorException x) {
//			System.err.println(x);
//		}
//		//TODO 索引持久化
//		//最后，使用得到的索引，进行检索，返回结果
//		Searcher search = new MemorySearcher();
//		int[] results = search.search(index, Arrays.asList(new String[]{"road","Photograph","plants"}), 10);
//		//结果将被展示出来
//		if(results ==null){
//			System.out.println("对不起，没有匹配的搜索结果");
//		}else{
//			for(int i=0;i<results.length;i++){
//				int docId = results[i];
//				Path file = corpus.resolve(String.valueOf(docId));
//				System.out.println("搜索结果No."+(++i)+".DocId:"+docId);
//				System.out.println(ReadFile.readFile(file));
//			}
//		}
//	}
//
//}
