package basicThread;

/**
 * ����stop()��java.lang.ThreadDeath�쳣��
 * ����stop����ʱ���׳�java.lang.ThreadDeath�쳣������ͨ������£����쳣����Ҫ��ʽ�Ĳ�׽��
 * @author Administrator
 * stop()�����Ѿ���ʱ����Ϊ���ǿ�����߳�ֹͣ�����п���ʹһЩ�����ԵĹ����ò�����ɣ�
 * ����֮�⣺�������Ķ�������ˡ����������������ݵò���ͬ���Ĵ����������ݲ�һ�����⡣
 * �����ʾ�ࣺThreadTest10_interrupt_fun9.java
 *
 */
public class ThreadTest10_interrupt_fun8 {
	public static void main(String[] args) {
		RunThread6 runThread6 = new RunThread6();
		runThread6.start();
	}
}

class RunThread6 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			this.stop();
		} catch (ThreadDeath e) {
			// TODO: handle exception
			System.out.println("����catch����������");
			e.printStackTrace();
		}
	}
}
