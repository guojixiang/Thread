package basicThread;

/**
 * ʹ�ö��̼߳���ʱ����������н�������ִ��˳����ߵ���˳���޹ء�
 * @author Administrator
 * ����main������ִ�У�����ֽ����
 * *���н�����
 * *Mythread��
 */
public class ThreadTest4 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println("���н���!");
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("Mythread!");
	}
}
