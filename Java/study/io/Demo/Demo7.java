package study.io;

import java.io.IOException;
import java.io.InputStreamReader;

public class Demo7 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        char[] cbuf = new char[50];
        in.read(cbuf);
        System.out.println(cbuf);
    }
}
