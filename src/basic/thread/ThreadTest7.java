package basic.thread;

/**
 * ����̷߳���ͬһ���������ñ�����ͬһ�����̶߳��󣩣�����������̰߳�ȫ�����⡣
 * @author Administrator
 * ������
 * 	��ĳЩJVM�У�i--�Ĳ���Ҫ�ֳ�3����
 * 	1��ȡ��ԭ�е�iֵ��
 * 	2������i-1��
 *  3����i���и�ֵ��
 * �������������У�����ж���س�ͬʱ���ʣ���ôһ������֡����̰߳�ȫ���⡱��
 */
public class ThreadTest7 {
	public static void main(String[] args) {
		// �����̰߳�ȫ����1
//		MyThread3 myThread3 = new MyThread3();
////		MyThread4 myThread3 = new MyThread4();
//		Thread a = new Thread(myThread3,"A");
//		Thread b = new Thread(myThread3,"B");
//		Thread c = new Thread(myThread3,"C");
//		Thread d = new Thread(myThread3,"D");
//		Thread e = new Thread(myThread3,"E");
//		a.start();
//		b.start();
//		c.start();
//		d.start();
//		e.start();	
		System.out.println("=====================================================");
		// ����i--��print()֮����ɵ��̰߳�ȫ������ʾ�������м��Σ�һ�ο��ܲ��������Ҫ�Ľ����
		MyThread5 myThread5 = new MyThread5();
		Thread t1 = new Thread(myThread5);
		Thread t2 = new Thread(myThread5);
		Thread t3 = new Thread(myThread5);
		Thread t4 = new Thread(myThread5);
		Thread t5 = new Thread(myThread5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

// run�������첽���ã�����߳�ͬʱ���ʸö����ͬһ���������������̰߳�ȫ�����⡣
class MyThread3 extends Thread {
	private int count = 5;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		count--;
		System.out.println("�� "+this.currentThread().getName()+" ���㣬count="+count);
	}
}

/**
 * synchronized�ؼ��֣�ͬ�����Ρ���run��������Ϊͬ��������
 * ������̵߳���ʱ����������̰߳�ȫ�����⡣(���и��̶߳�����������ִ��run����)
 * @author Administrator
 *
 */
class MyThread4 extends Thread {
	private int count = 5;
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		super.run();
		count--;
		System.out.println("�� "+this.currentThread().getName()+" ���㣬count="+count);
	}
}

/**
 * ����i--��System.out.print()���̰߳�ȫ����
 * @author Administrator
 * print()��synchronized�ؼ��ֽ�������
 */
class MyThread5 extends Thread {
	private int i = 5;
	
	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("i=" + (i--) + " threadName="+Thread.currentThread().getName());
		
		// ע�⣺����i--��MyThread3/4��ߵĵ���һ�и�Ϊ��println()������ֱ�����С�
	}
	// ���´��������̰߳�ȫ���⡣
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		super.run();
//		System.out.println("i=" + (i--) + " threadName="+Thread.currentThread().getName());
//		
//		// ע�⣺����i--��MyThread3/4��ߵĵ���һ�и�Ϊ��println()������ֱ�����С�
//	}
} 

