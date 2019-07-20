package multithread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCreateThread {
    public static void main (String[] args) throws ExecutionException,InterruptedException{
//      for(int i=0;i<10;i++){
//          new MyThread(i).start();
//      }
        //使用实现的方式
        /*
        for(int i=0;i<10;i++){
            new Thread(new Runnable(){
                public void run(){
                    try{
                        for(int i=0;i<10;i++){
                            Thread.sleep(1000);
                            System.out.println(String.format("T2:%d",i));
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        */
//        MyThread1 thread1=new MyThread1();
//            new Thread(thread1).start();
//            new Thread(thread1).start();
        MyCallable mc=new MyCallable();
        FutureTask<Integer>ft=new FutureTask<>(mc);
        Thread thread=new Thread(ft);
        Thread thread1=new Thread(ft);
        thread.start();
        thread1.start();
        System.out.println(ft.get());

    }
}
class MyThread extends Thread{
    private int tid;
    Object obj=new Object();
    public MyThread(int tid){
        this.tid=tid;
    }
    @Override
    public void run(){
        try{
            synchronized (MyThread.class) {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println(String.format("%d:%d", tid, i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class MyThread1 implements Runnable{
    @Override
    public void run(){
        try{
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println(String.format("T2:%d", i));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class MyCallable implements Callable<Integer> {
    public Integer call(){
        return 123;
    }
}


