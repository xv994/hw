package study.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fo = new FileOutputStream("ttt3.txt");
        byte[] inb = {-61, -26, -49, -14, -74, -44, -49, -13};
        try {
            fo.write(inb);
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            fo.close();
        }
    }
}
