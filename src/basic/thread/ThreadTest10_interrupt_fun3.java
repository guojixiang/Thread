package basic.thread;

public class ThreadTest10_interrupt_fun3 {
	public static void main(String[] args) {
		Thread.currentThread().interrupt();
		System.out.println("�Ƿ�ֹͣ1��"+Thread.currentThread().isInterrupted());
		System.out.println("�Ƿ�ֹͣ2��"+Thread.interrupted());
	}
}

