package oop;


public class TestOrder {
    public static void main(String[] args) {
        Order order=new Order(1,"order1");
        Order order1=new Order(2,"order2");
        Integer i=5;
        int i1= i.intValue();
        int i2=i;
        String str=i1+"";
        System.out.println(str);
        System.out.println(String.valueOf(i1));
        System.out.println(Integer.parseInt(str));
        Person1 person1=new Person1();
        person1.eat();
        new AA().run();
        System.out.println(TestStatic.a);
        TestStatic.a++;

    }
    protected static void test(){};
}

class Order{
    private int orderId;
    private String orderName;
    int helloworld=1;
    public Order(){

    }
    public Order(int orderId ,String orderName){
        this.orderId=orderId;
        this.orderName=orderName;
        System.out.println("完成构造器初始化");
    }
    //静态代码块1
    static{
        System.out.println("我是静态代码块1");

    }
    //非静态初始化块
    {
        orderId=1002;
        orderName="AA";
        System.out.println("我是非静态代码块1");
    }
    static{
        System.out.println("我是静态代码块2");
    }

    {
        orderId=1003;
        orderName="BB";
        System.out.println("我是非静态代码块2");
    }
    int testOrder(){
        class order1{
            private int order1=1;
        }
        return 1;
    }
    class subOrder{

    }
}
class Test extends Order{
    public void a(){
        testOrder();
    }
}

abstract class Person{
    private int age;
    private String name;
    Person(){
        age=1;
        name="default";
    }
    public abstract void eat();
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
class Person1 extends Person{
    public void eat(){
        System.out.println(getAge()+":吃饭"+getName());
    }

}
interface A{
     int i=12;
     boolean FLAG=false;
     public void run1();
     public boolean isMan1();
     public boolean haveDream1();
}
interface B{
    int i=13;
    boolean FLAG=true;
    void run();
    boolean isMan();
    boolean haveDream();
}

interface C extends B,A{

}
class AA implements  A,B{
    public void run(){
        System.out.println(A.FLAG);
        System.out.println(A.i);
    }
    public void run1(){};
    public boolean isMan1(){return false;};

    @Override
    public boolean haveDream1() {
        return false;
    }

    public boolean isMan(){
        return false;
    }
    public boolean haveDream(){
        return false;
    }
}
class TestOverride{

    public TestOverride(int i,int j){
    }
    public TestOverride(String str){
        String str1="yulei";
    }
    public void test(){

    }
    public void test1(){
        this.test();
    }
}

class TestOverride1 extends TestOverride{

    public TestOverride1(){
        super(1,2);
    }
}
class TestStatic {
    public static int a=1;
}
