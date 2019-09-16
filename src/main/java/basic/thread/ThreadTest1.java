package basic.thread;

/**
 * 实现多线程的两种方式
 * 	1、继承Thread类
 * 	2、实现Runnable接口
 * @author Administrator
 *
 */

public class ThreadTest1 extends Thread {
	
	public static void main(String[] args) {
		ThreadTest1 threadTest1 = new ThreadTest1();
		threadTest1.start();
		ThreadTest2 threadTest2 = new ThreadTest2();
		Thread thread = new Thread(threadTest2);
		thread.start();
		Thread thread2 = new Thread(new ThreadTest3());
		thread2.start();
	}
	
	@Override
	public void run() {
		System.out.println("我是继承Thread方式实现多线程的！");
	}
}

class ThreadTest2 implements Runnable {
	@Override
	public void run() {
		System.out.println("我是实现Runnable接口实现多线程的！");
	}
}

class ThreadTest3 extends Thread {
	@Override
	public void run() {
		System.out.println("==========================================");
		System.out.println("我是通过构造函数传入Thread对象实现多线程的！因为Thread类实现了Runnable接口！");
	}
}
