package basic.thread;

/**
 * 
 * @author Administrator
 * ������ǰ��cpu��Դ�������ø�����������ȥռ��CPUִ��ʱ�䡣
 * ������ʱ�䲻ȷ�����п��ܸոշ����������ֻ��CPUʱ��Ƭ
 *
 */
public class ThreadTest12_yield_fun {
	public static void main(String[] args) {
		MyThread12 myThread12 = new MyThread12();
		myThread12.start();
	}
}

class MyThread12 extends Thread {
	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for(int i=0;i<50000000;i++) {
//			 Thread.yield();
			count = count + (i+1);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("��ʱ��"+(endTime - beginTime) + "���룡");
	}
}
