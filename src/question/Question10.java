package question;
/*
    1.求斐波那契数列的第 n 项，n <= 39。
    2.青蛙跳台阶
    一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
    求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class Question10 {


    //递归思路，效率最低。O(2^n)
    public int f1(int n){
        if(n<=1)
            return n;
        else{
            return f1(n-1)+f1(n-2);
        }
    }

    public int f2(int n){
        if(n<=1)
            return n;
        int pre1=0;
        int pre2=1;
        int target=0;
        for(int i=2;i<=n;i++){
            target=pre1+pre2;
            pre1=pre2;
            pre2=target;
        }
        return target;
    }

    public int s2(int n){
        if(n<1)
            return 0;
        if(n==1 || n==2)
            return n;
        int res=2;
        int pre=1;
        int tmp=0;
        for(int i=3;i<=n;i++){
            tmp=res;
            res=res+pre;
            pre=tmp;
        }
        return tmp;
    }
}
