package nowcoder.sort;

import nowcoder.LogTestArray;

/*
荷兰国旗问题：也是快排partition的思想
 */
public class NetherlandsFlag {
    public static void sort(int[]nums,int flag){
        if(nums==null || nums.length<2)
            return;
        int more=nums.length;
        int k=0;
        int less=-1;
        while(k<more) {
            if (nums[k] == flag)
                k++;
            else if (nums[k] < flag) {
                swap(nums, k++, ++less);
            } else {
                swap(nums, --more, k);
            }
        }
    }

    public static void swap(int []nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        int[]arr=new int[]{4,4,5,1,2,3,9,4};
        sort(arr,4);
        LogTestArray.printArray(arr);
    }
}
