package basic.thread;

/**
 * �߳�ֹͣ
 * 
 * @author Administrator 
 * ��ʾ��ֹͣ���˵��߳� interrupt()
 * ʹ��Ч������for+break�������������ֹͣѭ����
 * ���ø÷����������ڵ�ǰ�߳��д��� һ��ֹͣ�ı�ǣ����������ֹͣ���̡߳�
 */
public class ThreadTest10_interrupt_fun {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try {
			MyThread11 myThread11 = new MyThread11();
			myThread11.start();
			myThread11.sleep(1000);
			// �����н���������̲߳�û��ֹͣ��
			myThread11.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch!");
			e.printStackTrace();
		}
		
	}
}

class MyThread11 extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i="+(i+1));
		}
	}
}
