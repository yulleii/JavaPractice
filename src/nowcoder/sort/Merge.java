package nowcoder.sort;

import nowcoder.LogTestArray;

import java.util.Arrays;

public class Merge extends LogTestArray {
    private int[]tmp;
    @Override
    public void myMethod(int[] nums) {
        if(nums==null || nums.length<2)
            return;
        tmp=new int[nums.length];
        merge(nums,0,nums.length-1);
    }

    public void merge(int[]nums,int L,int R){
        if(R<=L)
            return;
        int mid=L+((R-L)>>1);
        merge(nums,L,mid);
        merge(nums,mid+1,R);
        mergeProcess(nums,L,mid,R);
    }

    public void mergeProcess(int []nums,int L,int mid,int R){
        int p1=L;
        int p2=mid+1;
        for(int k=L;k<=R;k++)
            tmp[k]=nums[k];
        for(int i=L;i<=R;i++){
            if(p1>mid)
                nums[i]=tmp[p2++];
            else if(p2>R)
                nums[i]=tmp[p1++];
            else if(tmp[p1]<tmp[p2])
                nums[i]=tmp[p1++];
            else
                nums[i]=tmp[p2++];
        }
    }

    @Override
    public void rightMethod(int[] nums) {
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        new Merge().test(5000,10,10);
    }
}
