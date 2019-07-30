package multithread;

public class TestInterrupt {


    public static void main(String[] args) {
        try {
            Thread thread = new MyThread2();
            thread.start();
            Thread.sleep(5000);
            thread.interrupt();
            System.out.println("finish");
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
class MyThread2 extends Thread{
    public void run(){
        try{
            while(!interrupted()){
                System.out.println("im waiting! "+Thread.currentThread().getName());
                //Thread.sleep(2000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("thread end!");
        }
    }
}