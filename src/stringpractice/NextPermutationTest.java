package stringpractice;

import java.util.Arrays;

/*
    字典序排列，求下一个字典序，如果有返回true否则false
 */
public class NextPermutationTest {
    public static void main(String[] args) {
        String str="abcb";
        char[]c=str.toCharArray();
        //Arrays.sort(c);
        while(nextPermutation(c))
            System.out.println(String.valueOf(c));
    }

    private static boolean nextPermutation(char[]chars){
        int len=chars.length;

        int i=len-2;
        //从倒数第二个字符开始,从右向左,找到第一个破坏从右向左递增顺序的数字
        while(i>=0 && chars[i]>=chars[i+1])i--;
        if(i<0)return false;
        int k=len-1;
        //从右向左,找到第一个大于char[i]的数字
        while(k>i&& chars[k]<=chars[i])k--;
        //交换两个数字后，逆序后面的序列
        swap(chars,i,k);
        reverse(chars,i+1,len-1);
        return true;
    }

    private static void swap(char[]c,int i,int j){
        char cc=c[i];
        c[i]=c[j];
        c[j]=cc;
    }

    private static void reverse(char[]c,int a,int b){
        while(a<=b){
            swap(c, a++, b--);
        }
    }
}
