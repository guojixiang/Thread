package basic.thread;

public class ThreadTest10_interrupt_fun3 {
	public static void main(String[] args) {
		Thread.currentThread().interrupt();
		System.out.println("ÊÇ·ñÍ£Ö¹1£¿"+Thread.currentThread().isInterrupted());
		System.out.println("ÊÇ·ñÍ£Ö¹2£¿"+Thread.interrupted());
	}
}

