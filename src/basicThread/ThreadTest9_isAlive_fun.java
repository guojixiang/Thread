package basicThread;

/**
 * �жϵ�ǰ�߳��Ƿ��ڻ״̬
 * @author Administrator
 *
 */
public class ThreadTest9_isAlive_fun {
	public static void main(String[] args) throws InterruptedException {
		MyThread9 myThread9 = new MyThread9();
		System.out.println("begin ==" + myThread9.isAlive());
		myThread9.start();
		// ��ֵ��ӡ������̶���
		// Thread.sleep(1000);
		System.out.println("end == " + myThread9.isAlive());
	}
}

class MyThread9 extends Thread {
	@Override
	public void run() {
		System.out.println("run=" + this.isAlive());
	}
}
