package basic.thread;

/**
 * ʵ�ֶ��̵߳����ַ�ʽ
 * 	1���̳�Thread��
 * 	2��ʵ��Runnable�ӿ�
 * @author Administrator
 *
 */

public class ThreadTest1 extends Thread {
	
	public static void main(String[] args) {
		ThreadTest1 threadTest1 = new ThreadTest1();
		threadTest1.start();
		ThreadTest2 threadTest2 = new ThreadTest2();
		Thread thread = new Thread(threadTest2);
		thread.start();
		Thread thread2 = new Thread(new ThreadTest3());
		thread2.start();
	}
	
	@Override
	public void run() {
		System.out.println("���Ǽ̳�Thread��ʽʵ�ֶ��̵߳ģ�");
	}
}

class ThreadTest2 implements Runnable {
	@Override
	public void run() {
		System.out.println("����ʵ��Runnable�ӿ�ʵ�ֶ��̵߳ģ�");
	}
}

class ThreadTest3 extends Thread {
	@Override
	public void run() {
		System.out.println("==========================================");
		System.out.println("����ͨ�����캯������Thread����ʵ�ֶ��̵߳ģ���ΪThread��ʵ����Runnable�ӿڣ�");
	}
}
