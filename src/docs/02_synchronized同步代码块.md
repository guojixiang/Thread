##同步代码块知识点
1、synchronized关键字声明方法在某些情况下是存在弊端的。
 * 如：A线程调用同步方法执行一个长时间的任务，那么B线程则必须等待比较长的时间。
 * synchronized方法对当前对象加锁；
 * synchronized代码块对某一个对象进行加锁；
 
2、当两个并发线程访问同一个对象Object中的synchronized(this)同步代码块时，一段时间只能有一个线程被执行，另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码。
 *  一半异步，一半同步：不在synchronized块中就是异步执行，在synchronized块中就是同步执行。

3、当一个线程访问object的synchronized(this)同步代码块时，
 * 其它线程对于同一个object中所有其他synchronized(this)同步代码块的访问将会阻塞；
 * 这说明synchronized使用的对象监视器是一个
 
4、synchronized(this)代码块是锁定当前对象的。

5、任意对象作为对象监视器。synchronized同步方法或者synchronized(this)同步代码块分别有两种作用：
 *  （1） synchronized同步方法
     1. 对其他synchronized同步方法或者synchronized（this）同步代码块调用呈阻塞状态。
     2. 同一时间只有一个线程可以执行synchronized同步方法中的代码。
 * （2）synchronized（this）同步代码块
    1. 对其他synchronized同步方法或者synchronized（this）同步代码块调用呈阻塞状态；
    2. 同一时间只有一个线程可以执行synchronized同步代码块中的代码；
    
  除了以上两种，还有一种同步格式：synchronized(非this对象)
  
   1. 多个线程持有的“对象监视器”为同一个对象的前提下，同一时间只有一个线程可以执行synchronized
  （非this对象）同步代码块中的代码。
   2. 当持有“对象监视器” 为同一个对象的前提下，同一时间只有一个线程看可以执行synchronized（非this对象x）同步代码块中的代码

非this对象同步代码块，持有不同的对象监视器是异步的效果。

同步代码块放在非同步synchronized方法中进行声明，并不能保证调用方法的线程的执行同步/顺序性，
也就是线程调用方法的顺序是无序的，虽然在同步代码块中执行的顺序是同步的，这样极易出现“脏读”问题。（解决办法：对要操作的实例，如果是单实例，可以作为同步锁）

* synchronized（非this对象x）格式的写法将x对象本身作为“对象监视器”，可得出3个结论：
 1. 当多个线程同时执行synchronized（X）{}同步代码块时呈现同步效果。
 2. 当其他线程执行x对象中的synchronized同步方法时呈现同步效果。
 3. 当其他线程执行x对象中的synchronized（this）代码块时呈现同步效果。

* 静态同步synchronized方法与synchronized（class）代码块
关键字synchronized可应用在static静态方法上，是对当前*.java文件对应的Class类进行持锁。