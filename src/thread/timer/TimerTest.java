package thread.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Timer 定时器相关api使用
 */
public class TimerTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("系统当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date runDate = calendar.getTime();
        Timer timer = new Timer();
        TaskTest task1 = new TaskTest();
        TaskTest task2 = new TaskTest();
        TaskTest task3 = new TaskTest();
        // 指定runDate 执行TaskTest. 计划时间晚于当前时间
        timer.schedule(task1, runDate);
        // 指定runDate 执行TaskTest,并每隔固定时间循环执行
        timer.schedule(task2, runDate, 1000);
        timer.schedule(task3, runDate, 3000);

        // 12 秒后将task2移除任务队列
        Thread.sleep(13000);
        task2.cancel();

        // 5 秒后将任务队列全部清空
        Thread.sleep(5000);
        timer.cancel();

    }

}
