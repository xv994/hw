package DataStructure.Chapter01;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        while (true){
            
            String operator = input.nextLine();
            System.out.print("Please input the first number: ");
            String number1 = input.nextLine();
            System.out.print("Please input the second number: ");
            String number2 = input.nextLine();
            System.out.println("Please choose the kind of operation");
            System.out.println("1.add\n2.sub\n3.exit");

            if (operator.equals("1"))
                System.out.println("The result is " + new BigInteger(number1).add(new BigInteger(number2)));
            else if (operator.equals("2"))
                System.out.println("The result is " + new BigInteger(number1).sub(new BigInteger(number2)));
            else if (operator.equals("3")){
                System.out.println("Thanks for your using.");
                break;
        }
        else 
            System.out.println("Error. Please try again.");
        }  
    }   
}
