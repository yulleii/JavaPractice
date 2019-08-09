package search;

public class Solution {
    public static void main(String[] args) {
       String str="ab";
       char[]c=str.toCharArray();
       int len=c.length;
       process(c,0,len);
    }
    private static void process(char[]c,int begin,int end){
        if(begin==end-1){
            for(char cc:c)
                System.out.print(cc);
            System.out.println();
        }else{
            for(int i=begin;i<end;i++){
                if(isSwap(c,i,begin)){
                    swap(c,i,begin);
                    process(c,begin+1,end);
                    swap(c,i,begin);
                }
            }
        }
    }
    private static boolean isSwap(char[]c,int begin,int end){
        for(int i=begin;i<=end;i++){
            if(c[i]==c[end])
                return false;
        }
        return true;

    }

    private static void swap(char[]c,int i,int j){
        char tmp=c[i];
        c[i]=c[j];
        c[j]=tmp;
    }



}
