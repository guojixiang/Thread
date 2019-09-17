package thread.basic;

/**
 * 
 * @author Administrator 
 * 判断线程是否是停止状态
 * this.interrupted() 测试当前线程（运行this.interrupted()的线程）是否已经中断。
 * this.isInterrupted() 测试线程是否已经中断。
 * 
 * interrupted()：静态方法：public static boolean interrupted();
 * 线程的中断状态由该方法清除。即，如果连续调用该方法，则第二次掉调用将返回false。
 * （在第一次调用已清除了其中断状态之后，且第二次调用检验完中断状态前，当前线程再次中断的情况除外）
 *         
 */
public class ThreadTest10_interrupt_fun2 {
	public static void main(String[] args) {
		try {
			RunThread runThread = new RunThread();
			System.out.println("is是否停止1？ = "+runThread.isInterrupted());
			runThread.start();
			runThread.interrupt();
			Thread.sleep(200);
//			使main线程产生中断效果。
//			Thread.currentThread().interrupt();
//			System.out.println("是否停止1？ = "+runThread.interrupted());
//			System.out.println("是否停止2？ = "+runThread.interrupted());
			System.out.println("is是否停止1？ = "+runThread.isInterrupted());
			System.out.println("is是否停止2？ = "+runThread.isInterrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch!");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}

class RunThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 20000; i++) {
			System.out.println("i=" + (i + 1));
		}
		System.out.println("runThread run!");
	}
}