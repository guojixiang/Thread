package basic.thread;

/**
 * 线程停止
 * 
 * @author Administrator 
 * 演示：停止不了的线程 interrupt()
 * 使用效果不像for+break语句那样，马上停止循环。
 * 调用该方法仅仅是在当前线程中打了 一个停止的标记，并不是真的停止了线程。
 */
public class ThreadTest10_interrupt_fun {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try {
			MyThread11 myThread11 = new MyThread11();
			myThread11.start();
			myThread11.sleep(1000);
			// 从运行结果来看，线程并没有停止。
			myThread11.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch!");
			e.printStackTrace();
		}
		
	}
}

class MyThread11 extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i="+(i+1));
		}
	}
}
