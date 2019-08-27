package practice;

import nowcoder.LogTestArray;

import java.util.Arrays;

public class ThreeQuickSort extends LogTestArray {
    public static void main(String[] args) {
        new ThreeQuickSort().test(5000,1000,100);
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
        int len=nums.length;
        threeQuickSort(nums,0,len-1);
    }
    private  void threeQuickSort(int []nums,int left,int right){
        if(left>=right)return;
        int m=(int)((right-left+1)*Math.random())+left;
        swap(nums,m,right);
        int []p=partition(nums,left,right);
        threeQuickSort(nums,left,p[0]);
        threeQuickSort(nums,p[1]+1,right);
    }
    private int []partition(int[]nums,int left,int right){
        int l=left-1,r=right;
        int v=nums[right];
        while(left<r){
            if(nums[left]==v)left++;
            else if(nums[left]<v)swap(nums,++l,left++);
            else swap(nums,--r,left);
        }
        swap(nums,left,right);
        return new int[]{l,r};
    }
}
