package multithread;


public class TestCreateThread {
    public static void main(String[] args) {
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
        MyThread1 thread1=new MyThread1();
            new Thread(thread1).start();
            new Thread(thread1).start();

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



