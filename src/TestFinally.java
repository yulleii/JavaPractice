public class TestFinally {
    public static void  main(String[] args) {
        System.out.println(inc());
    }

    public static int inc(){
        int x;
        try{
            x=0;
            return x;
        }catch(Exception e){
            x=1;
            return x;
        }finally{
            x=2;
        }
    }
}
