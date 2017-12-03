package basicThread;
/**
 * 
 * @author Administrator
 * �ڳ�˯��ֹͣ���߳���sleep()״̬��ֹͣ�߳�
 * �����sleep״̬��ֹͣĳһ���̣߳������catch��䣬�������ֹͣ״ֵ̬��ʹ֮���false.
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
			System.out.println("�ڳ�˯�б�ֹͣ������catch!"+this.isInterrupted());
			e.printStackTrace();
		}
	}
}
