package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestFuture {
    public static class Task implements Runnable{
        public void run(){
            System.out.println("execute");
        }
    }

    public static void main(String[]args){
//        ExecutorService executorService= Executors.newCachedThreadPool();
////        for(int i=0;i<10;i++){
////            executorService.submit(new Task());
////        }
////        if(!executorService.isShutdown()){
////            executorService.shutdown();
////        }
        try {
            testFuture();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static class FutureTask1 implements Callable<String> {
        public String call()throws  Exception{
            System.out.println("execute!");
            return "complete";
        }
    }
    public static void testFuture()throws InterruptedException,
            ExecutionException {
        List<Future<String>> result=new ArrayList<Future<String>>();
        ExecutorService executorService=Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            result.add(executorService.submit(new FutureTask1()));
        }
        for(Future<String>future:result){
            System.out.println(future.get());
        }

        System.out.println("Main Complete");

        if(!executorService.isShutdown())
            executorService.shutdown();
    }
}
