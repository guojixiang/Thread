package basic.thread;

/**
 * 
 * @author Administrator 
 * �ж��߳��Ƿ���ֹͣ״̬
 * this.interrupted() ���Ե�ǰ�̣߳�����this.interrupted()���̣߳��Ƿ��Ѿ��жϡ�
 * this.isInterrupted() �����߳��Ƿ��Ѿ��жϡ�
 * 
 * interrupted()����̬������public static boolean interrupted();
 * �̵߳��ж�״̬�ɸ÷����������������������ø÷�������ڶ��ε����ý�����false��
 * ���ڵ�һ�ε�������������ж�״̬֮���ҵڶ��ε��ü������ж�״̬ǰ����ǰ�߳��ٴ��жϵ�������⣩
 *         
 */
public class ThreadTest10_interrupt_fun2 {
	public static void main(String[] args) {
		try {
			RunThread runThread = new RunThread();
			System.out.println("is�Ƿ�ֹͣ1�� = "+runThread.isInterrupted());
			runThread.start();
			runThread.interrupt();
			Thread.sleep(200);
//			ʹmain�̲߳����ж�Ч����
//			Thread.currentThread().interrupt();
//			System.out.println("�Ƿ�ֹͣ1�� = "+runThread.interrupted());
//			System.out.println("�Ƿ�ֹͣ2�� = "+runThread.interrupted());
			System.out.println("is�Ƿ�ֹͣ1�� = "+runThread.isInterrupted());
			System.out.println("is�Ƿ�ֹͣ2�� = "+runThread.isInterrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch!");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}

class RunThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 20000; i++) {
			System.out.println("i=" + (i + 1));
		}
		System.out.println("runThread run!");
	}
}