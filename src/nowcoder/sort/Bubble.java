package nowcoder.sort;

import nowcoder.LogTestArray;

import java.util.Arrays;

public class Bubble extends LogTestArray {
    @Override
    public void myMethod(int[] nums) {
        if(nums==null || nums.length<2)
            return;
        int length=nums.length;
        boolean flag=false;
        for(int i=length-1;i>0 && !flag;i--) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j+1);
                    flag=false;
                }
            }
        }
    }

    @Override
    public void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        new Bubble().test(5000,10,100);
    }
}
