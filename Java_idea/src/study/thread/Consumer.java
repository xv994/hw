package study.thread;

public class Consumer extends Thread{
    Storage store;
    public Consumer(Storage store){
        this.store = store;
    }
    public Consumer(){}

    public void run(){
        for (int i = 0; i < 10; i++) {
            store.output();
        }
    }
}
