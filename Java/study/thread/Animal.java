package study.thread;

public class Animal extends Thread{

    public Animal(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i <= 100; i += 10){
            System.out.println(this.getName() + " runs " + i + "m.");
            try {
                //休眠不到一秒的时间
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Animal rabbit = new Animal("rabbit");
        //设置优先级
        rabbit.setPriority(1);
        Animal turtoise = new Animal("turtoise");
        turtoise.setPriority(10);
        rabbit.start();
        turtoise.start();
    }
}
