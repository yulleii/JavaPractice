public class exception {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        try{
            System.out.println("try");
            System.out.println("try"+1/0);
            return -1;

        }catch(Exception e){
            System.out.println("catch");
            e.printStackTrace();
        }finally{
            System.out.println("finallly");
            return -2;
        }

    }
}
