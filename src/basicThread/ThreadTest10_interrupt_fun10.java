package basicThread;

/**
 * interrupt()��return()���ʹ��Ҳ��ʵ��ֹͣ�̵߳Ľ����
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
				System.out.println("ֹͣ�ˣ�");
				return;
			}
			System.out.println("timer="+System.currentTimeMillis());
		}
	}
}
