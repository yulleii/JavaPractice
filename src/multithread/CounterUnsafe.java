//package multithread;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
//public class CounterUnsafe {
//    volatile int i=0;
//    private static Unsafe unsafe=null;
//    private static long valueOffset;
//    static {
//        try{
//            Field field=Unsafe.class.getDeclaredField("theUnsafe");
//            field.setAccessible(true);
//            unsafe=(Unsafe)field.get(null);
//            Field iField=CounterUnsafe.class.getDeclaredField("i");
//            //Unsafe用于拿到i在内存的偏移量
//            valueOffset=unsafe.objectFieldOffset(iField);
//        }catch(IllegalAccessException | NoSuchFieldException e){
//            e.printStackTrace();
//        }
//    }
//    public void add(){
//        for(;;){
//            //获取旧值
//            int currentValue=unsafe.getIntVolatile(this,valueOffset);
//            if(unsafe.compareAndSwapInt(this,valueOffset,currentValue,currentValue+1))
//                break;
//        }
//    }
//}
//class testCounter{
//    public static void main (String[] args) throws InterruptedException{
//        CounterUnsafe cu=new CounterUnsafe();
//        for(int i=0;i<10;i++){
//            new Thread(()->{
//                for(int j=0;j<10000;j++){
//                    cu.add();
//                }
//                System.out.println("done");
//            }).start();
//        }
//        Thread.sleep(1000L);
//        System.out.println(cu.i);
//    }
//}
