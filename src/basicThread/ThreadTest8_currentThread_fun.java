package basicThread;

/**
 * Thread��ľ�̬������currentThread()��
 * ���ش�������ڱ��ĸ��̵߳��õ���Ϣ��
 * @author Administrator
 * 
 */
public class ThreadTest8_currentThread_fun {
	public static void main(String[] args) {
		// ��ʾ1
		//System.out.println(Thread.currentThread().getName());
		// ��ʾ2
		MyThread7 myThread = new MyThread7();
		myThread.start();
		
		// ��ʾ3,��ʾ3��2��1����ͬʱ��ʾ���̵߳�ִ��˳��͵���˳���޹ء�
		//myThread.run();
		
	}
}

class MyThread7 extends Thread {
	public MyThread7() {
		System.out.println("���췽���Ĵ�ӡ��" + Thread.currentThread().getName());
	}
	
	@Override
	public void run() {
		System.out.println("run �����Ĵ�ӡ��"+Thread.currentThread().getName());
	}
}