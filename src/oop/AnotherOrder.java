package oop;

public class AnotherOrder {
    public static void main(String[] args) {
        Order order=new Order();
        order.testOrder();
        TestOrder testOrder=new TestOrder();
        testOrder.test();
        TestOrder.test();
    }
}
class oo extends Order{

    @Override
    int testOrder() {
        helloworld=1;
        return super.testOrder();
    }
}
