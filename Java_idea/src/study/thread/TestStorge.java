package study.thread;

public class TestStorge {
    public static void main(String[] args) {
        Storage store = new Storage("洗衣机", 4);
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        producer.start();
        consumer.start();
    }
}
