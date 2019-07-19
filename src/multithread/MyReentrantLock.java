package multithread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class MyReentrantLock implements Lock {
    //当前锁的拥有者
    AtomicReference<Thread>owner=new AtomicReference<>();
    //等待队列
    private LinkedBlockingQueue<Thread>waiter=new LinkedBlockingQueue<>();
    //标记加锁次数
    AtomicInteger count=new AtomicInteger(0);
    @Override
    public void lock() {
        if(!tryLock()){
            waiter.offer(Thread.currentThread());
            for(;;){
                Thread head=waiter.peek();
                if(head == Thread.currentThread()){
                    if(!tryLock())
                        LockSupport.park();
                    else{
                        waiter.poll();
                        return;
                    }
                }else{
                    LockSupport.park();
                }
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        //判断count是否为0，若不为0，说明锁已经被占用
        int ct=count.get();
        if(ct!=0){
            //若owner为自己，ct+1,重入锁的特点在此
            if(owner.get()==Thread.currentThread()){
                count.set(ct+1);
                return true;
            }else{
                //若不是，抢锁失败
                return false;
            }
        }else{
            if(count.compareAndSet(ct,ct+1)){
                owner.set(Thread.currentThread());
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        if(tryUnlock()){
            Thread th=waiter.peek();
            if(th!=null)
                LockSupport.unpark(th);
        }
    }

    public boolean tryUnlock(){
        //判断当前线程是不是owner
        if(owner.get()!=Thread.currentThread()){
            throw new IllegalMonitorStateException();
        }else{
            int ct=count.get();
            int nextc=ct-1;
            count.set(nextc);
            if(nextc==0){
                owner.compareAndSet(Thread.currentThread(),null);
                return true;
            }else
                return false;
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

class CounterLock{
    volatile int i=0;
    Lock lock=new MyReentrantLock();
    public void add(){
        lock.lock();
        i++;
        lock.unlock();
    }

    public static void main (String[] args)throws InterruptedException {
        CounterLock counterLock=new CounterLock();
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<10000;j++){
                    counterLock.add();
                }
                System.out.println("done");
            }).start();
        }
        Thread.sleep(1000L);
        System.out.println(counterLock.i);
    }
}
