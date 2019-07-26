package multithread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class MyLock extends AbstractQueuedSynchronizer {
    protected MyLock() {
        super();
    }
    public void test(){
        ReentrantReadWriteLock rw=new ReentrantReadWriteLock();
    }

    @Override
    //尝试获取锁
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }
    //尝试释放锁
    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }
    //是否排他
    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
