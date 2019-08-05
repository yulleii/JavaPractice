package nowcoder.sort;

import nowcoder.LogTestArray;

import java.util.Arrays;

public class Insertion extends LogTestArray {
    @Override
    public void myMethod(int[] nums) {
        if(nums==null || nums.length<2)
            return;
        int N= nums.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0 && nums[j-1]>nums[j];j--)
                swap(nums,j,j-1);
        }
    }

    @Override
    public void rightMethod(int[] nums) {
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        new Insertion().test(5000,10,100);
    }
}
