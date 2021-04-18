package study.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fo = new FileOutputStream(".//study//io//invoice.dat");
        DataOutputStream out = new DataOutputStream(fo);
        double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
        int[] units = {12, 8, 13, 29, 50};
        String[] descs = {"Java T-Shirts", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain"};

        try {
            for (int i = 0; i < prices.length; i++){
                out.writeDouble(prices[i]);
                out.writeChar('\t');
                out.writeInt(units[i]);
                out.writeChar('\t');
                out.writeChars(descs[i]);
                out.writeChar('\n');
            }
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally{
            out.close();
            fo.close();
        }
    }
}
