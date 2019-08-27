package practice;

import nowcoder.LogTestArray;

import java.util.Arrays;

public class Heap extends LogTestArray {
    public static void main(String[] args) {
        new Heap().test(5000,100,9);
    }

    @Override
    public void myMethod(int[] nums) {
        sort(nums);
    }

    @Override
    public void rightMethod(int[] nums) {
        Arrays.sort(nums);
    }

    public void sort(int[]nums){
        int len=nums.length-1;
        for(int i=(len-1)/2;i>=0;i--)sink(nums,i,len);
        while(len>0){
            swap(nums,0,len--);
            sink(nums,0,len);
        }
    }
    public void sink(int[]nums,int c,int t){
        while(2*c<t){
            int k=2*c+1;
            if(k<t && nums[k]<nums[k+1])k++;
            if(nums[c]>nums[k])break;
            swap(nums,k,c);
            c=k;
        }
    }

}
