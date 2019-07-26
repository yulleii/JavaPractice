package multithread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
<<<<<<< HEAD
import java.util.concurrent.locks.ReentrantLock;
=======
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
>>>>>>> 052365f3c12c510fc0b70c7f198712368c68c4eb

public class MyLock extends AbstractQueuedSynchronizer {
    protected MyLock() {
        super();
    }
<<<<<<< HEAD
=======
    public void test(){
        ReentrantReadWriteLock rw=new ReentrantReadWriteLock();
    }
>>>>>>> 052365f3c12c510fc0b70c7f198712368c68c4eb
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
