package basic.thread;
/**
 * ��ֹͣ���̣߳��쳣��
 * @author Administrator
 *
 */
public class ThreadTest10_interrupt_fun4 {

	public static void main(String[] args) {
		try {
			RunThread2 runThread2 = new RunThread2();
			runThread2.start();
			Thread.sleep(2000);
			runThread2.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch!");
			e.printStackTrace();
		}

	}
}

class RunThread2 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (this.interrupted()) {
					System.out.println("�Ѿ���ֹͣ״̬�ˣ���Ҫ�˳��ˣ�");
					throw new InterruptedException();
				}
				System.out.println("i=" + (i + 1));
			}
		} catch (InterruptedException e) {
			System.out.println("��RunThread2.java��run�����е�catch�ˣ�");
			e.printStackTrace();
		}
	}
}
