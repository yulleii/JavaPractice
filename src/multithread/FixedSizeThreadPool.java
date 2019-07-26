package multithread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedSizeThreadPool {
    //需要一个仓库
    private BlockingQueue<Runnable>blockingQueue;
    //需要一个线程的集合
    private List<Thread> workers;
    //需要一个人干活
    public static class Worker extends Thread{
        private FixedSizeThreadPool pool;
        public Worker(FixedSizeThreadPool pool){
            this.pool=pool;
        }
        public void run(){
            //希望它不断的向仓库里面拿任务
            while(this.pool.isWorking || this.pool.blockingQueue.size()>0){
                Runnable task=null;
                try{
                    if(this.pool.isWorking)
                        task=this.pool.blockingQueue.take();
                    else
                        task=this.pool.blockingQueue.poll();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                if(task!=null){
                    task.run();
                    System.out.println("线程："+Thread.currentThread().getName()+"执行完毕");
                }
            }
        }
    }
    //需要进行线程池的初始化，规定仓库大小和集合大小。可以把线程准备就绪
    public FixedSizeThreadPool(int poolSize,int taskSize){
        if(poolSize<=0 || taskSize <=0){
            throw new IllegalArgumentException("非法参数");
        }
        this.blockingQueue=new LinkedBlockingQueue<>(taskSize);
        this.workers= Collections.synchronizedList(new ArrayList<>());
        for(int i=0;i<poolSize;i++){
            Worker worker=new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    //需要向仓库中放任务——阻塞
    public boolean submit(Runnable task){
        if(isWorking)
            return this.blockingQueue.offer(task);
        else
            return false;
    }

    //需要向仓库中放任务——非阻塞
    public void execute(Runnable task){
        try{
             this.blockingQueue.put(task);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    //需要关闭的方法
    //关闭的时候：仓库要停止继续添加新任务
    //关闭的时候，仓库的剩余任务要执行完
    //关闭的时候，如果再去仓库拿东西就不需要阻塞了
    //关闭的时候，如果还有线程被阻塞，我们要强行中断
    private volatile boolean isWorking=true;
    public void shutdown(){
        this.isWorking=false;
        for(Thread thread:workers){
            if(thread.getState().equals(Thread.State.WAITING)||
                    thread.getState().equals(Thread.State.BLOCKED)){
                thread.interrupt();
            }
        }
    }
}

class TestThreadPool{
    public static void main(String[] args) {
        FixedSizeThreadPool pool=new FixedSizeThreadPool(3,6);
        for(int i=0;i<6;i++){
            pool.submit(new Runnable(){
                public void run(){
                    System.out.println("一个线程被放到仓库中");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println("有一个线程被唤醒了");
                    }
                }
            });
        }
        pool.shutdown();
    }
}