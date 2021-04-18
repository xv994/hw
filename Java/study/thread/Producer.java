package study.thread;

public class Producer extends Thread{
    Storage store;
    public Producer(Storage store){
        this.store = store;
    }
    public Producer(){}

    public void run(){
        for (int i = 0; i < 10; i++) {
            store.input();
        }
    }
}
