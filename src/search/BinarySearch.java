package search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int []nums=new int[]{1,6,9,21,32,99,225,315,1000};
        System.out.println(valueSearch(nums,99));
    }

    //二分查找
    public static int BinarySearch(int[]nums,int key){
        if(nums==null)
            return -1;
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]<key){
                low=mid+1;
            }else if(nums[mid]>key){
                high=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    //插值查找
    public static int valueSearch(int[]nums,int key){
        if(nums==null)
            return -1;
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            mid=low+(high-low)*(key-nums[low])/(nums[high]-nums[low]);
            if(nums[mid]>key){
                high=mid-1;
            }
            else if(nums[mid]<key){
                low=mid+1;
            }
            else
                return mid+1;
        }
        return -1;
    }

    //斐波那契查找
    public static int fibonacciSearch(int[]nums,int key){
        if(nums==null)
            return -1;
        int low=0;
        int high=nums.length-1;
        int mid;

        return -1;
    }

    public static int fibonacci(int index){
        if(index<=1)
            return index;
        int pre1=0;
        int pre2=1;
        int target=0;
        for(int i=2;i<=index;i++){
            target=pre1+pre2;
            pre1=pre2;
            pre2=target;
        }
        return target;
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
}
