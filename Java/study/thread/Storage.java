package study.thread;

public class Storage {
    private String name;
    private int max;
    private int sum;
    private int no;
    public Storage(String name, int max){
        this.name = name;
        this.max = max;
    }
    public Storage(){}

    public synchronized void input(){
        while (sum >= max){
            try {
                wait();
            } catch(Exception e){}
        }
        sum ++;
        no ++;
        notify();
        System.out.printf("生产%d%s，当前库存数：%d\n", no, name, sum);
    }

    public synchronized void output(){
        while (sum <= 0){
            try {
                wait();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        sum --;
        notify();
        System.out.printf("消费%d%s，当前库存数：%d\n", no - sum, name, sum);
    }

}
