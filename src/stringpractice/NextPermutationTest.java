package stringpractice;
/*
    字典序排列，求下一个字典序，如果有返回true否则false
 */
public class NextPermutationTest {
    public static void main(String[] args) {
        String str="dbca";
        char[]c=str.toCharArray();
        while(nextPermutation(c))
            System.out.println(String.valueOf(c));
    }

    private static boolean nextPermutation(char[]chars){
        int len=chars.length;
        int i=len-2;
        while(i>=0 && chars[i]>chars[i+1])i--;
        if(i<0)return false;
        int k=len-1;
        while(k>i&& chars[k]<=chars[i])k--;
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
