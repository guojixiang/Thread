package basic.thread;

/**
 * stop()释放锁将会给数据造成不一致性的结果。
 * @author Administrator
 *
 */
public class ThreadTest10_interrupt_fun9 {
	public static void main(String[] args) {
		try {
			SynchronizedObject object = new SynchronizedObject();
			RunThread7 runThread7 = new RunThread7(object);
			runThread7.start();
			Thread.sleep(500);
			runThread7.stop();
			System.out.println(object.getUserName()+" "+object.getPassword());
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SynchronizedObject {
	private String userName = "a";
	private String password = "aa";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	synchronized public void peintString(String userName,String password) {
		try {
			this.userName = userName;
			Thread.sleep(1000);
			this.password = password;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class RunThread7 extends Thread {
	private SynchronizedObject object;
	
	public RunThread7(SynchronizedObject object) {
		super();
		this.object = object;
	}
	
	@Override
	public void run() {
		object.peintString("b", "bb");
	}
}
