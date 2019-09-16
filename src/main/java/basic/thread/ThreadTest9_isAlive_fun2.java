package basic.thread;

/**
 * 构造函数传入线程对象：this和Thread的差异之处。
 * @author Administrator
 *
 */
public class ThreadTest9_isAlive_fun2 {
		public static void main(String[] args) {
			MyThread10 myThread10 = new MyThread10();
			Thread t = new Thread(myThread10);
			System.out.println("main begin t isAlive="+t.isAlive());
			t.setName("A");
			t.start();
			System.out.println("main end t isAlive="+t.isAlive());
		}
	}

	class MyThread10 extends Thread {
		public MyThread10() {
			System.out.println("MyThread10-------begin:");
			System.out.println("Thread.currentThread().getName() = "+Thread.currentThread().getName());
			System.out.println("Thread.currentThread().isAlive() = "+Thread.currentThread().isAlive());
			System.out.println("this.getName()="+ this.getName());
			System.out.println("this.isAlive()="+ this.isAlive());
			System.out.println("MyThread10-------end");
		}
		
		@Override
		public void run() {
			System.out.println("run-------begin:");
			System.out.println("Thread.currentThread().getName() = "+Thread.currentThread().getName());
			System.out.println("Thread.currentThread().isAlive() = "+Thread.currentThread().isAlive());
			System.out.println("this.getName()="+ this.getName());
			System.out.println("this.isAlive()="+ this.isAlive());
			System.out.println("run-------end");
		}
}
