package thread.concurrent.procon;

/**
 * 生产者与消费者：一生产，一消费
 */
public class Example_1 {

    public static String queueStr = "";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin test.");
        String lock = new String("lock");
        Producer_1 producer_1 = new Producer_1(lock);
        Consumer_1 consumer_1 = new Consumer_1(lock);
        producer_1.start();
        consumer_1.start();

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                producer_1.interrupt();
                consumer_1.interrupt();
                System.out.println("all threads stop.");
            }
        });

        Thread.sleep(100);

        System.exit(0);
    }


}

class Producer_1 extends Thread {

    private String lock;

    public Producer_1(String lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    if (!Example_1.queueStr.equals("")) {
                        lock.wait();
                    }
                    String queueVal = Thread.currentThread().getName()+System.currentTimeMillis();
                    System.out.println("producer set queue: "+ queueVal);
                    Example_1.queueStr = queueVal;
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("producer_1 stop...");
            e.printStackTrace();
        }
    }
}

class Consumer_1 extends Thread {

    private String lock;

    public Consumer_1(String lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    if (Example_1.queueStr.equals("")) {
                        lock.wait();
                    }
                    System.out.println("consumer get queue: "+ Example_1.queueStr);
                    Example_1.queueStr = "";
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("consumer_1 stop...");
            e.printStackTrace();
        }
    }
}
