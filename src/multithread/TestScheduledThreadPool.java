package multithread;

import java.util.concurrent.*;

public class TestScheduledThreadPool {
    public static void main(String[] args) {
        ExecutorService service=new ScheduledThreadPoolExecutor(2);
    }
}
