package question;

public class Question16 {
    public static void main(String[] args) {
        System.out.println(new Question16().power(0,10));
    }

    public double power(double base, int exponent) {
        if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        boolean isNegative=false;
        if(exponent<0){
            exponent=-exponent;
            isNegative=true;
        }
        double pow=power(base*base,exponent/2);
        if(exponent%2==1)
            pow=pow*base;
        return isNegative?1/pow:pow;
    }
}
