package study.io;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream("./study/io/invoice.dat");
        DataInputStream in = new DataInputStream(fi);

        double price;
        int unit;
        String desc;
        double total = 0.0;
        try {
            while (true){
                price = in.readDouble();
                in.readChar();
                unit = in.readInt();
                in.readChar();
                desc = in.readLine();
                System.out.println("You've ordered " + unit + " units of " + desc + " at $" + price);
                total = total + unit * price;
            }
        } catch (EOFException e) {
            System.out.println("For a TOTAL of: $" + total);
        } finally {
            in.close();
        }

    }
}
