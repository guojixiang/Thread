package basic.thread;

/**
 * 
 * @author Administrator 守护线程： 线程分为两种：用户线程，守护线程。
 *         守护线程是一种特殊的线程，当进程中不存在非守护线程时，则守护线程自动销毁。
 */
public class ThreadTest14_daemon_fun {
	public static void main(String[] args) {
		try {
			DaemonThread daemonThread = new DaemonThread();
			daemonThread.setDaemon(true);
			daemonThread.start();
			// 有可能会在打印一次。这是线程异步特性决定的。
			Thread.sleep(5000);
			System.out.println("我离开daemonThread对象也不再打印了，也就是停止了！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class DaemonThread extends Thread {
	private int i = 0;

	@Override
	public void run() {
		try {
			while (true) {
				i++;
				System.out.println("i=" + (i));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
