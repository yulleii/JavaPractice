package designmode;

public class HungrySingleton {
    private HungrySingleton(){};
    private static HungrySingleton instance;

    public static HungrySingleton getInstance(){
        if(instance==null){
            instance=new HungrySingleton();
        }
        return instance;
    }
}

class LazySingleton {
    private LazySingleton(){};
    private static LazySingleton instance=new LazySingleton();

    public static LazySingleton getInstance(){
        return instance;
    }
}

