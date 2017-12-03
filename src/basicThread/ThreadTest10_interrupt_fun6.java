package basicThread;

public class ThreadTest10_interrupt_fun6 {
	public static void main(String[] args) {
		RunThread4 runThread4 = new RunThread4();
		runThread4.start();
		runThread4.interrupt();
		System.out.println("end!");
	}
}

class RunThread4 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			for(int i=0;i<100000;i++) {
				System.out.println("i="+(i+1));
			}
			System.out.println("run begin!");
			Thread.sleep(1000);
			System.out.println("run end!");
		} catch(InterruptedException e) {
			System.out.println("先停止，在遇到sleep！进入catch！");
			e.printStackTrace();
		}
	}
}
