package nowcoder.dynamicplan;

public class N {
    public static int f(int N){
        if(N==1 || N==2)
            return 1;

        return f(N-1)+f(N-2);
    }

    public static int cows(int N){
        if(N<1)return 0;
        if(N<=3)return N;
        return cows(N-1)+cows(N-3);
    }

    public static int cowNumber2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(cows(10));
    }
}
