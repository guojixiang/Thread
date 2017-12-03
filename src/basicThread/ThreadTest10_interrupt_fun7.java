package basicThread;

/**
 * 
 * @author Administrator
 * 暴力停止：stop.(过时作废方法，不建议使用)
 */
public class ThreadTest10_interrupt_fun7 {
	public static void main(String[] args) {
	try {
		RunThread5 runThread5 = new RunThread5();
		runThread5.start();
		Thread.sleep(8000);
		runThread5.stop();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}

class RunThread5 extends Thread {
	private int i =0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			while(true) {
				i++;
				System.out.println("i="+i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
