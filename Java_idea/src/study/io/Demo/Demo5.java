package study.io;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream("./study/io/ttt3.txt");
        byte[] inb = new byte[fi.available()];
        try {
            fi.read(inb);
            for (int i = 0; i < inb.length; i++){
                System.out.println(inb[i]);
            }
            System.out.println();
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally{
            fi.close();
        }
    }
}
