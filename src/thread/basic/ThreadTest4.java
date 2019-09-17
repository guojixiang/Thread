package thread.basic;

/**
 * 使用多线程技术时，代码的运行结果与代码执行顺序或者调用顺序无关。
 * @author Administrator
 * 以下main方法，执行，会出现结果：
 * *运行结束！
 * *Mythread！
 */
public class ThreadTest4 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println("运行结束!");
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("Mythread!");
	}
}
