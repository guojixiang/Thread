package basic.thread;


/**
 * 
 * @author Administrator
 * �߳̿��Ի������ȼ������ȼ��ϸߵ��̵߳õ���cpu��Դ�϶࣬
 * Ҳ����cpu����ִ�����ȼ��ϸߵ��̶߳����е�����
 * JDK��ʹ��3������Ԥ�ö������ȼ���ֵ��
 * public static final int MIN_PRIORITY = 1
 * public static final int NORM_PRIORITY = 5
 * public static final int MAX_PRIORITY = 10
 * 
 * �߳����ȼ������������ԣ�
 * 1���̳�����
 * 2��������
 * 3�������
 * 
 */
public class ThreadTest13_priority_fun {
	
	public static void main(String[] args) {
		System.out.println("main basic.thread begin priority="+Thread.currentThread().getPriority());
//		 Thread.currentThread().setPriority(6);
		System.out.println("main basic.thread end priority="+Thread.currentThread().getPriority());
		// �̳�����
		PriorityThread1 priorityThread1 = new PriorityThread1();
		priorityThread1.start();
		
		
	}

}

class PriorityThread1 extends Thread {
	@Override
	public void run() {
		System.out.println("PriorityThread1 run priority=" + this.getPriority());
		PriorityThread2 priorityThread2 = new PriorityThread2();
		priorityThread2.start();
	}
}

class PriorityThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("PriorityThread1 run priority=" + this.getPriority());
	}
}
