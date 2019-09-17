package thread.basic;

/**
 * interrupt()与return()结合使用也能实现停止线程的结果。
 * @author Administrator
 *
 */
public class ThreadTest10_interrupt_fun10 {
	public static void main(String[] args) throws InterruptedException {
		RunThread8 runThread8 = new RunThread8();
		runThread8.start();
		Thread.sleep(2000);
		runThread8.interrupt();
	}
}

class RunThread8 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			if(this.isInterrupted()) {
				System.out.println("停止了！");
				return;
			}
			System.out.println("timer="+System.currentTimeMillis());
		}
	}
}
