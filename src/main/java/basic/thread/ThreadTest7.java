package basic.thread;

/**
 * 多个线程访问同一个变量（该变量是同一个相线程对象），会产生“非线程安全”问题。
 * @author Administrator
 * 分析：
 * 	在某些JVM中，i--的操作要分成3步：
 * 	1、取得原有的i值。
 * 	2、计算i-1。
 *  3、对i进行赋值。
 * 在这三个步骤中，如果有多个县城同时访问，那么一定会出现“非线程安全问题”。
 */
public class ThreadTest7 {
	public static void main(String[] args) {
		// 测试线程安全问题1
//		MyThread3 myThread3 = new MyThread3();
////		MyThread4 myThread3 = new MyThread4();
//		Thread a = new Thread(myThread3,"A");
//		Thread b = new Thread(myThread3,"B");
//		Thread c = new Thread(myThread3,"C");
//		Thread d = new Thread(myThread3,"D");
//		Thread e = new Thread(myThread3,"E");
//		a.start();
//		b.start();
//		c.start();
//		d.start();
//		e.start();	
		System.out.println("=====================================================");
		// 测试i--与print()之间造成的线程安全问题演示（多运行几次，一次可能不会出现想要的结果）
		MyThread5 myThread5 = new MyThread5();
		Thread t1 = new Thread(myThread5);
		Thread t2 = new Thread(myThread5);
		Thread t3 = new Thread(myThread5);
		Thread t4 = new Thread(myThread5);
		Thread t5 = new Thread(myThread5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

// run方法被异步调用，多个线程同时访问该对象的同一变量，产生“非线程安全”问题。
class MyThread3 extends Thread {
	private int count = 5;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		count--;
		System.out.println("由 "+this.currentThread().getName()+" 计算，count="+count);
	}
}

/**
 * synchronized关键字，同步修饰。将run方法修饰为同步方法。
 * 被多个线程调用时。解决“非线程安全”问题。(持有该线程对象锁，才能执行run方法)
 * @author Administrator
 *
 */
class MyThread4 extends Thread {
	private int count = 5;
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		super.run();
		count--;
		System.out.println("由 "+this.currentThread().getName()+" 计算，count="+count);
	}
}

/**
 * 留意i--与System.out.print()的线程安全问题
 * @author Administrator
 * print()用synchronized关键字进行修饰
 */
class MyThread5 extends Thread {
	private int i = 5;
	
	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("i=" + (i--) + " threadName="+Thread.currentThread().getName());
		
		// 注意：代码i--由MyThread3/4里边的单独一行改为在println()方法中直接运行。
	}
	// 以下代码会出现线程安全问题。
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		super.run();
//		System.out.println("i=" + (i--) + " threadName="+Thread.currentThread().getName());
//		
//		// 注意：代码i--由MyThread3/4里边的单独一行改为在println()方法中直接运行。
//	}
} 

