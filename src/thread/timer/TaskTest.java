package thread.timer;

import java.util.Date;
import java.util.TimerTask;

public class TaskTest extends TimerTask {
    @Override
    public void run() {
        System.out.println("Time is " + new Date() +".Timer task executing.Threan Name is "+ Thread.currentThread().getName());
    }
}
