package concurrent.thread.procon;

/**
 * 生产者，消费者：一生产，多消费；多生产，多消费；多生产，一消费
 */
public class Example_2 {


    public static String queueStr = "";

    public static void main(String[] args) throws InterruptedException {
        String lock = new String("lock");
//        Producer1_1 producer1_1 = new Producer1_1(lock);
//        producer1_1.start();
        Consumer1_1 consumer1_1 = new Consumer1_1(lock);
        Consumer1_1 consumer1_2 = new Consumer1_1(lock);
        consumer1_1.start();
        consumer1_2.start();

        Thread.sleep(1000);
        System.out.println(consumer1_1.getName() + " state is " + consumer1_1.getState().name());
        System.out.println(consumer1_2.getName() + " state is " + consumer1_2.getState().name());
        queueStr = "test";
        synchronized (lock) {
            lock.notifyAll();
        }
        queueStr = "test";
        System.exit(0);
    }
}

class Producer1_1 extends Thread {

    private String lock;

    public Producer1_1(String lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    // 多生产者时，使用while,当线程唤醒时及时检测条件变化。
                    if (!Example_2.queueStr.equals("")) {
                        lock.wait();
                    }
                    String queueVal = Thread.currentThread().getName() + System.currentTimeMillis();
                    System.out.println("--producer set queue: " + queueVal);
                    Thread.sleep(10);
                    Example_2.queueStr = queueVal;
                    // 多个生产者时，使用notifyAll()，唤醒全部，保证唤醒消费者
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("--producer_1 stop...");
            e.printStackTrace();
        }
    }
}

class Consumer1_1 extends Thread {

    private String lock;

    public Consumer1_1(String lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    // if 会出现当条件发生改变时，不能及时响应，导致被唤醒的线程并发的执行后续逻辑，会导致资源不足
                    if (Example_2.queueStr.equals("")) {
                        System.out.println(Thread.currentThread().getName() + " consumer get queue is empty ,waiting...");
                        lock.wait();
                    }
//                    while (Example_2.queueStr.equals("")) {
//                        System.out.println(Thread.currentThread().getName() + " consumer get queue is empty ,waiting...");
//                        lock.wait();
//                    }
                    System.out.println(Thread.currentThread().getName() + " consumer get queue: " + Example_2.queueStr);
                    Example_2.queueStr = "";
                    // 多个消费者时，唤醒全部，保证唤醒生产者
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("consumer_1 stop...");
            e.printStackTrace();
        }
    }
}
