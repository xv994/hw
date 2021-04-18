/**
 * 
 */
package DataStructure.Chapter03.src.corpus;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author
 *
 */
public class OrganizeFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Path dir = FileSystems.getDefault().getPath("/Users/chenruoyu/Downloads/null");
		Path dest = Paths.get("corpus");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			int id = 1;
			for (Path file : stream) {
				Files.copy(file, dest.resolve(String.valueOf(id++)), StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
		}
	}
}
