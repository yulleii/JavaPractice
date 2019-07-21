package multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

public class CountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);
    public static void main(String[]args) throws InterruptedException{
        new Thread(new Runnable(){
            public void run(){
                System.out.println(Thread.currentThread().getName());
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        System.out.println("begin");
        c.await();
        System.out.println("finished");
    }
}
