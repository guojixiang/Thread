package basicThread;

/**
 * Thread类的静态方法：currentThread()：
 * 返回代码段正在被哪个线程调用的信息。
 * @author Administrator
 * 
 */
public class ThreadTest8_currentThread_fun {
	public static void main(String[] args) {
		// 演示1
		//System.out.println(Thread.currentThread().getName());
		// 演示2
		MyThread7 myThread = new MyThread7();
		myThread.start();
		
		// 演示3,演示3、2、1不能同时演示：线程的执行顺序和调用顺序无关。
		//myThread.run();
		
	}
}

class MyThread7 extends Thread {
	public MyThread7() {
		System.out.println("构造方法的打印：" + Thread.currentThread().getName());
	}
	
	@Override
	public void run() {
		System.out.println("run 方法的打印："+Thread.currentThread().getName());
	}
}