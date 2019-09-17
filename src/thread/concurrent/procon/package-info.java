package thread.concurrent.procon;

/**
 * 线程间通信机制实现：wait/notify。
 * 通过生产者消费者案例进行代码演示。
 * 该包下有两个例子，Example_1.java 展示一生产者一消费者的工作流程，Example_2.java展示了其余情况下的工作流程
 * wait/notify 必须在同步方法或者同步代码块中调用，即在调用前，线程必须获得该对象的对象级别的锁。
 *
 *
 * join 方式实现线程间通信。
 * 使用场景：主线程需要等待子线程执行完毕再继续执行。代码演示见：Example_join.java
 *
 * 通过管道实现线程间通信：字节流（PipedInputStream,PipedOutputStream），字符流(PipedReader,PipedWriter)
 *
 *
 */