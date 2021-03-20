package DataStructure.Chapter01;

import java.util.Scanner;

public class highAccuracy {

    private String element1 = "";
    private String element2 = "";
    private String operator = "";
    private String result = "";

    public highAccuracy(){}
    public highAccuracy(String element1, String element2, String operator){
        this.element1 = element1;
        this.element2 = element2;
        this.operator = operator;
    }

    public String getElement1() {
        return element1;
    }

    public void setElement1(String element1) {
        this.element1 = element1;
    }

    public String getElement2() {
        return element2;
    }

    public void setElement2(String element2) {
        this.element2 = element2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResult(){

        this.result = compute();

        return this.result.toString();
    }

    public String compute(){
        if (this.operator.equals("+"))
            return compute_add();
        else if (this.operator.equals("-"))
            return compute_sub();
        return null;
    }

    public String compute_add(){
        char[] array1 = this.element1.toCharArray();
        char[] array2 = this.element2.toCharArray();

        if (array1[0] >='0' && array1[0] <= '9' && array2[0] >='0' && array2[0] <= '9'){
            int[] number1 = new int[array1.length];
            int[] number2 = new int[array2.length];
            int[] tmp = new int[array1.length > array2.length ? array1.length : array2.length];

            for (int i = 0; i < number1.length; i++){
                number1[i] = array1[i] - '0';
            }
            for (int i = 0; i < number1.length; i++){
                number2[i] = array2[i] - '0';
            }

            int carry = 0;
            for (int i = 1; i <= (array1.length < array2.length ? array1.length : array2.length); i++){
                int tmp1 = number1[number1.length - i];
                int tmp2 = number2[number2.length - i];
                tmp[tmp.length - i] = (tmp1 + tmp2) % 10 + carry;
                carry = (tmp1 + tmp2) / 10;
            }
            
            if (number1.length > number2.length){
                number1[number1.length - number2.length + 1] += carry;
                for (int i = 0; i < number1.length - number2.length - 1; i++){
                    tmp[i] = number1[i];
                }
            }
            else{
                number2[number2.length - number1.length + 1] += carry;
                for (int i = 0; i < number2.length - number1.length - 1; i++){
                    tmp[i] = number2[i];
                }
            }

            String tmp_string = "";
            for (int i = 0; i < tmp.length; i++){
                tmp_string += "" + tmp[i];
            }

            return tmp_string;
        }
        
    }

    public String toString(){
        return this.result == null ? "WARNING PLEASE CHECK" : "The result is " + this.result;
    }

    
    public static void main(String[] args) {
        highAccuracy r = new highAccuracy("9", "9", "+");

        // Scanner input = new Scanner(System.in);

        // r.setElement1(input.nextLine());
        // r.setElement2(input.nextLine());
        // r.setOperator(input.nextLine());
        

        System.out.println(r.getResult());
    }
    
}
