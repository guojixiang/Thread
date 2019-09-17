package thread.basic;

/**
 * 方法stop()与java.lang.ThreadDeath异常。
 * 调用stop方法时会抛出java.lang.ThreadDeath异常，但在通常情况下，此异常不需要显式的捕捉。
 * @author Administrator
 * stop()方法已经过时，因为如果强制让线程停止，则有可能使一些请理性的工作得不到完成，
 * 除此之外：对锁定的对象进行了“解锁”，导致数据得不到同步的处理，出现数据不一致问题。
 * 请见演示类：ThreadTest10_interrupt_fun9.java
 *
 */
public class ThreadTest10_interrupt_fun8 {
	public static void main(String[] args) {
		RunThread6 runThread6 = new RunThread6();
		runThread6.start();
	}
}

class RunThread6 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			this.stop();
		} catch (ThreadDeath e) {
			// TODO: handle exception
			System.out.println("进入catch（）方法！");
			e.printStackTrace();
		}
	}
}
