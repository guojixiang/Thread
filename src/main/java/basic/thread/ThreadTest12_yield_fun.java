package basic.thread;

/**
 * 
 * @author Administrator
 * 放弃当前的cpu资源，将它让给其他的任务去占用CPU执行时间。
 * 放弃的时间不确定，有可能刚刚放弃，马上又获得CPU时间片
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
		System.out.println("用时："+(endTime - beginTime) + "毫秒！");
	}
}
