package nowcoder;

import java.util.Arrays;

/*
一个无序数组，找到排序后相邻元素的最大差值。时间复杂度为O(N)
桶排序的思路来解决此问题
 */
public class MaxGapSolution {
    public static int maxGap(int[]nums){
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int N=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        if(min==max)
            return 0;
        boolean[]hasNumber=new boolean[N+1];
        int[]mins=new int[N+1];
        int[]maxs=new int[N+1];
        int bid=0;
        for(int i=0;i<N;i++){
            bid=getIndex(nums[i],N,min,max);
            mins[bid]=hasNumber[bid]?Math.min(mins[bid],nums[i]):nums[i];
            maxs[bid]=hasNumber[bid]?Math.max(maxs[bid],nums[i]):nums[i];
            hasNumber[bid]=true;
        }
        int res=0;
        int pre=maxs[0];
        for(int i=1;i<=N;i++){
            if(hasNumber[i]) {
                res = Math.max(res, mins[i] - pre);
                pre = maxs[i];
            }
        }
        return res;
    }

    public static int getIndex(long number,long len,long min,long max){
        return (int)((number-min)*len/(max-min));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
