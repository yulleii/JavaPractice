package multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

public class CountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);
    public static void main(String[]args) throws InterruptedException{
        Thread thread=new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName());
                    c.countDown();
                    System.out.println(2);
                    c.countDown();
                    Thread.sleep(2000);
                    System.out.println("我还在线程里面呢");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("begin");
        c.await();
        System.out.println("finished");
    }
}
