package basic.thread;


/**
 * 
 * @author Administrator
 * 线程可以划分优先级，优先级较高的线程得到的cpu资源较多，
 * 也就是cpu优先执行优先级较高的线程对象中的任务。
 * JDK中使用3个常量预置定义优先级的值。
 * public static final int MIN_PRIORITY = 1
 * public static final int NORM_PRIORITY = 5
 * public static final int MAX_PRIORITY = 10
 * 
 * 线程优先级具有以下特性：
 * 1、继承特性
 * 2、规则性
 * 3、随机性
 * 
 */
public class ThreadTest13_priority_fun {
	
	public static void main(String[] args) {
		System.out.println("main basic.thread begin priority="+Thread.currentThread().getPriority());
//		 Thread.currentThread().setPriority(6);
		System.out.println("main basic.thread end priority="+Thread.currentThread().getPriority());
		// 继承特性
		PriorityThread1 priorityThread1 = new PriorityThread1();
		priorityThread1.start();
		
		
	}

}

class PriorityThread1 extends Thread {
	@Override
	public void run() {
		System.out.println("PriorityThread1 run priority=" + this.getPriority());
		PriorityThread2 priorityThread2 = new PriorityThread2();
		priorityThread2.start();
	}
}

class PriorityThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("PriorityThread1 run priority=" + this.getPriority());
	}
}
