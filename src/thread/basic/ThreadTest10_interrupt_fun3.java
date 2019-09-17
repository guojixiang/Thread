package thread.basic;

public class ThreadTest10_interrupt_fun3 {
	public static void main(String[] args) {
		Thread.currentThread().interrupt();
		System.out.println("是否停止1？"+Thread.currentThread().isInterrupted());
		System.out.println("是否停止2？"+Thread.interrupted());
	}
}

