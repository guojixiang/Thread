package concurrent.thread.procon;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 运行字节流进行线程间数据通信
 * 字节流也可替换成对应的字符流：PipedWriter,PipedReader
 */
public class Example_PipedStream {

    public static void main(String[] args) {
        try{
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();

            // 使两个stream之间产生通信链接
            pipedOutputStream.connect(pipedInputStream);

            ThreadWrite threadWrite = new ThreadWrite(writeData, pipedOutputStream);
            threadWrite.start();

            Thread.sleep(2000);
            ThreadRead threadRead = new ThreadRead(readData,pipedInputStream);
            threadRead.start();


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ThreadRead extends Thread {
    private ReadData readData;
    private PipedInputStream pipedInputStream;

    public ThreadRead(ReadData readData, PipedInputStream pipedInputStream) {
        super();
        this.readData = readData;
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        readData.readMethod(pipedInputStream);
    }
}

class ThreadWrite extends Thread {

    private WriteData writeData;
    private PipedOutputStream pipedOutputStream;

    public ThreadWrite(WriteData writeData, PipedOutputStream pipedOutputStream) {
        super();
        this.writeData = writeData;
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(pipedOutputStream);
    }
}

class WriteData {
    public void writeMethod(PipedOutputStream pipedOutputStream) {
        try {
            System.out.println("Write:");
            for (int i = 0 ;i< 300; i++) {
                String writeData = " "+ (i+1);
                pipedOutputStream.write(writeData.getBytes());
                System.out.print(writeData);
            }
            System.out.println();
            pipedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadData {
    public void readMethod(PipedInputStream pipedInputStream) {
        System.out.println("read: ");
        byte[] byteArray = new byte[20];
        try {
            int readLength = pipedInputStream.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.println("read data: "+newData);
                readLength = pipedInputStream.read(byteArray);
            }
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
