package basicThread;

/**
 * 判断当前线程是否处于活动状态
 * @author Administrator
 *
 */
public class ThreadTest9_isAlive_fun {
	public static void main(String[] args) throws InterruptedException {
		MyThread9 myThread9 = new MyThread9();
		System.out.println("begin ==" + myThread9.isAlive());
		myThread9.start();
		// 此值打印结果不固定。
		// Thread.sleep(1000);
		System.out.println("end == " + myThread9.isAlive());
	}
}

class MyThread9 extends Thread {
	@Override
	public void run() {
		System.out.println("run=" + this.isAlive());
	}
}
