package question;

public class Question21 {
    public static void main(String[] args) {
        int[]array=new int[]{1,2,3,4};
        reOrderArray3(array);
        for(int i:array)
            System.out.println(i);
    }
    /*
    题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    //如果不考虑相对位置的关系，使用双指针的思路。时间复杂度O(n)，空间复杂度O(1)
    public static void reOrderArray1(int []array){
        if(array==null || array.length==0)
            return;
        int length=array.length;
        int head=0,tail=length-1;
        while(head<tail){
            while(head<tail && array[head]%2==1)
                head++;
            while(head<tail && array[tail]%2==0)
                tail--;
            if(head<tail){
                int tmp=array[head];
                array[head]=array[tail];
                array[tail]=tmp;
            }
        }
    }

    //如果考虑相对位置关系，可以使用新的数组来存放。空间复杂度O(n)，时间复杂度O(n)
    public static void reOrderArray2(int []array){
        int oddCnt=0;
        for(int x:array){
            if(!isEven(x))
                oddCnt++;
        }
        int []copy=array.clone();
        int i=0,j=oddCnt;
        for(int num:copy){
            if(isEven(num))
                array[j++]=num;
            else
                array[i++]=num;
        }
    }

    //使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度：O(n*n)，空间复杂度O(1)
    public static void reOrderArray3(int []array){
        int N=array.length;
        for(int i=N-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(isEven(array[j])&&!isEven(array[j+1])){
                    swap(array,j,j+1);
                }
            }
        }
    }
    private static void  swap(int[]nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    private  static boolean isEven(int number){
        return number%2==0;
    }
}

