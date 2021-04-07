/**
 * 
 */
package DataStructure.Chapter03.src.corpus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
/**
 * 读取文件，解析其内容，分词，去除停用词，返回单词及词频
 * @author
 *
 */
public class ReadFile {
	/**
	 * 停用词典
	 */
	private static final Set<String> stopWords = new HashSet<>();
	
	/**
	 * 需要从分词结果中去除的词性（词性名前缀）
	 */
	private static final Set<String> stopos = new HashSet<>();
	
	static{
		/**
		 * 停用词,停用词保存在stopwords.txt文件中，每行一个
		 */
		Path file = Paths.get("bin/stopwords.txt");
		try {
			BufferedReader reader = Files.newBufferedReader(file);
			String line = null;
			while((line = reader.readLine())!=null){
				if(line == null||"".equals(line))
					continue;//跳过可能存在的空行
				stopWords.add(line.trim().toLowerCase());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("读取"+stopWords.size()+"个停用词");
		/**
		 * 词性处理，在这个集合中的词性全部过滤掉,
		 * 删掉所有数词（m）,标点(w)
		 */
		stopos.addAll(Arrays.asList(new String[]{"m","w"}));
	}
	/**
	 * 解析文件，将文件内容中的descriptions部分提取出来，
	 * 分词，并将分词后的单词集合返回
	 * @param file
	 * @return
	 */
	public static Set<String> parseFile(Path file){
		Set<String> words = new HashSet<>();
		try {
			BufferedReader reader = Files.newBufferedReader(file);
			String line = null;
			while((line = reader.readLine())!=null){
				if(line == null||"".equals(line))
					continue;
				if("descriptions".equals(line.substring(0, line.lastIndexOf(':')))){
					String content = line.substring(line.lastIndexOf(':')+1).trim();
					List<Term> terms = StandardTokenizer.segment(content);
					for(Term term : terms){
						if(stopos.contains(String.valueOf(term.nature.firstChar())))
							continue;
						if(stopWords.contains(term.word.toLowerCase()))
							continue;
						words.add(term.word.toLowerCase());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}
	
	public static String readFile(Path file){
		String content = "";
		try {
			BufferedReader reader = Files.newBufferedReader(file);
			String line = null;
			while((line = reader.readLine())!=null){
				if(line == null||"".equals(line))
					continue;
				content+=line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
