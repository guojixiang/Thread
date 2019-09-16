package basic.thread;
/**
 * 线程启动顺序与start()执行顺序无关
 * @author Administrator
 *
 */
public class ThreadTest6 {
	public static void main(String[] args) {
		MyThread2 thread1 = new MyThread2(1);
		MyThread2 thread2 = new MyThread2(2);
		MyThread2 thread3 = new MyThread2(3);
		MyThread2 thread4 = new MyThread2(4);
		MyThread2 thread5 = new MyThread2(5);
		MyThread2 thread6 = new MyThread2(6);
		MyThread2 thread7 = new MyThread2(7);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		
	}
}

class MyThread2 extends Thread {
	private int i;
	public MyThread2(int i) {
		super();
		this.i = i;
	}
	@Override
	public void run() {
		System.out.println(i);
	}
}
