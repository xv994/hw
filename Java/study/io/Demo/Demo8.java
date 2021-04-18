package study.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo8 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        String s;
        while ((s = in.readLine()).length() != 0)
            System.out.println(s);
    }
}
