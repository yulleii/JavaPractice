package stringpractice;
/*
    给定一个字符类型的数组chas,请在单词间做逆序调整。
    只要做到单词的顺序逆序即可,对空格的位置没有要求
 */
public class RotateWord {

    public void rotateWord(char[] chas){
        if(chas==null ||chas.length==0)
            return;
        reverse(chas,0,chas.length-1);
        int l=-1,r=-1;
        for(int i=0;i<chas.length;i++){
            if(chas[i]!=' '){
                l=i==0||chas[i-1]==' '?i:l;
                r=i==chas.length-1||chas[i+1]==' '?i:r;
            }
            if(l!=-1 && r!=-1){
                reverse(chas,l,r);
                l=-1;
                r=-1;
            }
        }
    }

    public void reverse(char[]chas,int start,int end){
        char tmp=0;
        while(start<end){
            tmp=chas[start];
            chas[start]=chas[end];
            chas[end]=tmp;
            start++;
            end--;
        }
    }
}
