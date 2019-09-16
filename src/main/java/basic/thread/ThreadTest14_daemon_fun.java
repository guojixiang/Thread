package basic.thread;

/**
 * 
 * @author Administrator �ػ��̣߳� �̷߳�Ϊ���֣��û��̣߳��ػ��̡߳�
 *         �ػ��߳���һ��������̣߳��������в����ڷ��ػ��߳�ʱ�����ػ��߳��Զ����١�
 */
public class ThreadTest14_daemon_fun {
	public static void main(String[] args) {
		try {
			DaemonThread daemonThread = new DaemonThread();
			daemonThread.setDaemon(true);
			daemonThread.start();
			// �п��ܻ��ڴ�ӡһ�Ρ������߳��첽���Ծ����ġ�
			Thread.sleep(5000);
			System.out.println("���뿪daemonThread����Ҳ���ٴ�ӡ�ˣ�Ҳ����ֹͣ�ˣ�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class DaemonThread extends Thread {
	private int i = 0;

	@Override
	public void run() {
		try {
			while (true) {
				i++;
				System.out.println("i=" + (i));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
