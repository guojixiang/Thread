package basicThread;

/**
 * this与Thread调用currentThread()方法的不同。
 * 
 * @author Administrator
 * 
 */
public class ThreadTest8_currentThread_this_Thread {
	public static void main(String[] args) {
		MyThread8 myThread8 = new MyThread8();
		Thread t = new Thread(myThread8);
		t.setName("A");
		t.start();
	}
}

class MyThread8 extends Thread {
	public MyThread8() {
		System.out.println("MyThread8-------begin:");
		System.out.println("Thread.currentThread().getName() = "+Thread.currentThread().getName());
		System.out.println("this.getName()="+ this.getName());
		System.out.println("MyThread8-------end");
	}
	
	@Override
	public void run() {
		System.out.println("run-------begin:");
		System.out.println("Thread.currentThread().getName() = "+Thread.currentThread().getName());
		System.out.println("this.getName()="+ this.getName());
		System.out.println("run-------end");
	}
	
	
}