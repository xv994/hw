package study.io;

import java.io.FileWriter;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        char[] cbuf1 = {'J', 'a', 'v', 'a'};
        FileWriter fo = new FileWriter("txt1.txt");
        try {
            fo.write(cbuf1);
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            fo.close();
        }
    }
}
