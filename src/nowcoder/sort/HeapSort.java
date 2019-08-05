package nowcoder.sort;

import nowcoder.LogTestArray;

import java.util.Arrays;

public class HeapSort extends LogTestArray {
    public void myMethod(int []nums){
        if(nums==null || nums.length<2)
            return;
        int N=nums.length-1;
        for(int i=(N-1)/2;i>=0;i--){
            sink(nums,i,N);
        }
        while(N>=0){
            swap(nums,0,N--);
            sink(nums,0,N);
        }
    }

    public static void swap(int []nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void sink(int[]nums,int i,int m){
        while(2*i<m){
            int down=2*i+1;
            if(down<m && nums[down]<nums[down+1])
                down++;
            if(!(nums[down]>nums[i]))
                break;
            swap(nums,down,i);
            i=down;
        }
    }

    public void rightMethod(int[]nums){
        Arrays.sort(nums);
    }
    public static void main(String[] args) {
        new HeapSort().test(5000,50,100);
    }
}
