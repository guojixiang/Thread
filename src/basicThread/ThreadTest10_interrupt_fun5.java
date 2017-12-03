package basicThread;
/**
 * 
 * @author Administrator
 * 在沉睡中停止：线程在sleep()状态下停止线程
 * 如果在sleep状态下停止某一个线程，会进入catch语句，并且清除停止状态值，使之变成false.
 */
public class ThreadTest10_interrupt_fun5 {
	public static void main(String[] args) {
		try {
			RunThread3 runThread3 = new RunThread3();
			runThread3.start();
			Thread.sleep(200);
			runThread3.interrupt();
		} catch(InterruptedException e) {
			System.out.println("main catch!");
			e.printStackTrace();
		}
	}
}

class RunThread3 extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("run begin");
			Thread.sleep(20000);
			System.out.println("run end!");
		} catch(InterruptedException e) {
			System.out.println("在沉睡中被停止！进入catch!"+this.isInterrupted());
			e.printStackTrace();
		}
	}
}
