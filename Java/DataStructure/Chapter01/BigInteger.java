package DataStructure.Chapter01;

import java.util.LinkedList;


public class BigInteger implements BigInt {

    private LinkedList<Byte> list = new LinkedList<Byte>(); // 'list' stores the absolute value of the value
    private String str = ""; // 'str' stores the String of number
    private String formattedStr = "";   // 'formattedStr' stores the String of number with commas 
    private Sign sign = Sign.POSITIVE;  // 'sign' stores the Sign of number
    private Sign resultSign = null;     //'resultSign' stores the Sign of result of this number add/sub the other value 
    private boolean isBigger = true;    // 'isBigger' stores whether this number is bigger than another number when preforming operations

    public BigInteger(String integer) {
        // this.str = integer;
        this.preprocess(integer);
        // System.out.println("Construct: " + str);
    }
    public BigInteger(Long integer) {
        this(Long.toString(integer));
    }
    public BigInteger(BigInt integer) {
        this(integer.toString());
    }

    /**
     * data preprocess
     * include str to formattedstr
     * @param integer
     */
    public void preprocess(String integer){
        String[] temp = integer.split(",");
        for (int i = 0; i < temp.length; i++)
            this.str += temp[i];

        while (this.str.charAt(0) == '0'){
            this.str = this.str.substring(1);
        }

        // flag : by the value of flag, decide where to start processing
        int flag = 0;
        // because the exitstence of sign, the value of flag may need to be increased by one
        if (this.str.charAt(0) == '+' || this.str.charAt(0) == '-')
            flag = this.str.length() % 3 - 1;
        else
            flag = this.str.length() % 3; 

        // by travarsing 'str' and the value of flag, we add a comma
        for (int i = 0; i < this.str.length(); i++){
            this.formattedStr += this.str.charAt(i);
            if (flag % 3 == 0 && i != this.str.length() - 1 && i > 0)
                this.formattedStr += ",";
            flag++;
        }

        // using the built-in functions of String, String -> byte[]
        byte[] tmp = this.str.getBytes();
        // because forced type conversion (char -> byte), we must process value of each one
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = (byte)(tmp[i] - '0');
        }

        /**  
         * determine whether the first value of the array is a symbol value
         * parameter 'i' is equivalent to the flag
         */
        int i = 0;
        if (tmp[0] < 0){
            if (tmp[0] == -3)   this.sign = Sign.NEGATIVE;
            i = 1;
        }

        for (; i < tmp.length; i++)
            this.list.addFirst(tmp[i]);
    }

    public LinkedList<Byte> getList(Byte[] value){
        Byte[] tmp = value.clone();
        LinkedList<Byte> lList = new LinkedList<>();

        for (int i = 0; i < tmp.length; i++)
            lList.addLast(tmp[i]);

        return lList;
    }

    @Override
    public BigInt add(BigInt bInt) {

        this.getAddResulSign(bInt);

        if (this.getSign().equals(bInt.getSign())){
            return absoluteAdd(bInt);
        }
        else {
            return absoluteSub(bInt);
        }
       
    }

    public BigInt absoluteAdd(BigInt bInt){
        LinkedList<Byte> addend = new LinkedList<>();
        addend.addAll(getList(bInt.getValue()));
        byte carry = 0;
        
        LinkedList<Byte> sum = new LinkedList<>();

        LinkedList<Byte> shortList = addend.size() < this.list.size() ? (LinkedList)addend.clone() : (LinkedList)this.list.clone();
        LinkedList<Byte> longList = addend.size() > this.list.size() ? (LinkedList)addend.clone() : (LinkedList)this.list.clone();

        for (int i = 0; i < shortList.size(); i++){
            byte temp = (byte)(addend.get(i) + this.list.get(i));
            sum.addFirst((byte)((temp + carry) % 10));
            carry = (temp + carry) >= 10 ? (byte)1 : 0;
        }

        for (int i = shortList.size(); i < longList.size(); i++){
            sum.addFirst((byte)((longList.get(i) + carry) % 10));
            carry = (longList.get(i) + carry) >= 10 ? (byte)1 : 0; 
        }

        if (carry == 1)
            sum.addFirst(carry);

        return new BigInteger(addListToString(sum, bInt));
    }

    @Override
    public BigInt sub(BigInt bInt) {

        this.getSubResulSign(bInt);
        if (!this.getSign().equals(bInt.getSign()))
            return absoluteAdd(bInt);
        else
            return absoluteSub(bInt);

    }

    public BigInt absoluteSub(BigInt bInt){

        LinkedList<Byte> subtractor = new LinkedList<>();
        subtractor.addAll(getList(bInt.getValue()));

        LinkedList<Byte> subtraction = new LinkedList<>();

        LinkedList<Byte> bigList = this.isBigger ? (LinkedList<Byte>)this.list.clone() : (LinkedList<Byte>)subtractor.clone();
        LinkedList<Byte> smallList = !this.isBigger ? (LinkedList<Byte>)this.list.clone() : (LinkedList<Byte>)subtractor.clone();
        
        byte lastBorrow = 0;
        for (int i = 0; i < smallList.size(); i++){
            byte newBorrow = 0;
            byte temp = 0;

            if (bigList.get(i) < smallList.get(i)){
                newBorrow = 1;
                temp = (byte)(bigList.get(i) + 10 - smallList.get(i));
            }
            else{
                temp = (byte)(bigList.get(i) - smallList.get(i));
            }

            subtraction.addFirst((byte)(temp - lastBorrow));
            lastBorrow = newBorrow;
        }

        for (int i = smallList.size(); i < bigList.size(); i++){
            byte newBorrow = 0;
            byte temp = 0;

            if (bigList.get(i) < lastBorrow){
                newBorrow = 1;
                temp = (byte)(bigList.get(i) + 10 - lastBorrow);
            }
            else
                temp = (byte)(bigList.get(i) - lastBorrow);

            if (!(i == bigList.size() - 1 && temp == 0))
                subtraction.addFirst(temp);
            lastBorrow = newBorrow;
        }

        return new BigInteger(subListToString(subtraction, bInt));
    }

    @Override
    public BigInt add(long bLong) {
        return add(new BigInteger(bLong));
    }

    @Override
    public BigInt sub(long bLong) {
        return sub(new BigInteger(bLong));
    }

    @Override
    public BigInt add(int bInt) {
        return add((long)bInt);
    }

    @Override
    public BigInt sub(int bInt) {
        return sub((long)bInt);
    }

    @Override
    public boolean isPositive() {
        return this.getSign().equals(Sign.POSITIVE) ? true : false;
    }

    @Override
    public Sign getSign() {
        return this.sign;
    }

    @Override
    public void setSign(Sign sign) {
        this.sign = sign;
    }

    @Override
    public Byte[] getValue() {
        return this.list.toArray(new Byte[this.list.size()]);
    }

    Sign getAddResulSign(BigInt bInt){

        this.isBigger(bInt);

        if ((this.getSign().equals(Sign.POSITIVE) && bInt.getSign().equals(Sign.POSITIVE)) ||
            (this.getSign().equals(Sign.POSITIVE) && bInt.getSign().equals(Sign.NEGATIVE) && this.isBigger) ||
            (this.getSign().equals(Sign.NEGATIVE) && bInt.getSign().equals(Sign.POSITIVE) && !this.isBigger))
            resultSign = Sign.POSITIVE;
        else if (this.getSign().equals(Sign.NEGATIVE) && bInt.getSign().equals(Sign.NEGATIVE) ||
                (this.getSign().equals(Sign.POSITIVE) && bInt.getSign().equals(Sign.NEGATIVE) && !this.isBigger) ||
                (this.getSign().equals(Sign.NEGATIVE) && bInt.getSign().equals(Sign.POSITIVE) && this.isBigger))
            resultSign = Sign.NEGATIVE;

        return resultSign;
    }

    Sign getSubResulSign(BigInt bInt){

        this.isBigger(bInt);

        if ((this.getSign().equals(Sign.POSITIVE) && bInt.getSign().equals(Sign.NEGATIVE)) ||
            (this.getSign().equals(Sign.POSITIVE) && bInt.getSign().equals(Sign.POSITIVE) && this.isBigger) ||
            (this.getSign().equals(Sign.NEGATIVE) && bInt.getSign().equals(Sign.NEGATIVE) && !this.isBigger))
            resultSign = Sign.POSITIVE;
        else if (this.getSign().equals(Sign.NEGATIVE) && bInt.getSign().equals(Sign.POSITIVE) ||
                (this.getSign().equals(Sign.NEGATIVE) && bInt.getSign().equals(Sign.NEGATIVE) && this.isBigger) ||
                (this.getSign().equals(Sign.POSITIVE) && bInt.getSign().equals(Sign.POSITIVE) && !this.isBigger))
            resultSign = Sign.NEGATIVE;

        return resultSign;
    }

    public boolean isBigger(BigInt bInt){
        LinkedList<Byte> another = new LinkedList<>();
        another.addAll(getList(bInt.getValue()));

        if (this.list.size() > another.size())
            this.isBigger = true;
        else if (this.list.size() < another.size())
            this.isBigger = false;
        else {
            for (int i = 0; i < this.list.size(); i++){
                if (this.list.get(i).equals(another.get(i)))
                    continue;
                else
                    this.isBigger = this.list.get(i) > another.get(i) ? true : false;
            }
        }

        return this.isBigger;
    }

    public String addListToString(LinkedList<Byte> answer, BigInt bInt){
        boolean isZero = true;
        String str = this.getAddResulSign(bInt).equals(Sign.POSITIVE) ? "+" : "-";
        
        for (int i = 0; i < answer.size(); i++){
            if (answer.get(i) != 0)
                isZero = false;
            if (!isZero)
                str += answer.get(i).toString();
        }
        if (isZero)
            str = "0";
        return str;
    }

    public String subListToString(LinkedList<Byte> answer, BigInt bInt){
        boolean isZero = true;
        String str = this.getSubResulSign(bInt).equals(Sign.POSITIVE) ? "+" : "-";
        
        for (int i = 0; i < answer.size(); i++){
            if (answer.get(i) != 0)
                isZero = false;
            if (!isZero)
                str += answer.get(i).toString();
        }
        if (isZero)
            str = "0";
        return str;
    }
    
    @Override
    public String toString() {
        // return this.str;    
        return this.formattedStr;
    }
}
