package study.io;

import java.io.FileReader;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("txt1.txt");
        int c;
        try {
            while ((c = fr.read()) != -1){
                System.out.println((char)c);
            }
            System.out.println();
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            fr.close();
        }
    }
}
