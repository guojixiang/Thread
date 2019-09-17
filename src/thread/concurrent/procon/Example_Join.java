package thread.concurrent.procon;

/**
 * join 实现线程间通信
 */
public class Example_Join {

    private static int a, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread_1 = new Thread(() -> {
            a = 2;
            System.out.println("Now, a is " + a);
        });

        Thread thread_2 = new Thread(() -> {
            b = 2;
            System.out.println("Now, b is " + b);
        });

        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();

        System.out.println("a+b should be 4, now is " + (a + b));

    }


}
