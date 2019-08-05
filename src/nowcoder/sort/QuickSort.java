package nowcoder.sort;

import nowcoder.LogTestArray;

import java.util.Arrays;

public class QuickSort extends LogTestArray {
    public  void myMethod(int[]nums){
        if(nums==null || nums.length<2)
            return;
        quickSort(nums,0,nums.length-1);
    }

    public void rightMethod(int[]nums){
        Arrays.sort(nums);
    }

    public static void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void quickSort(int[]nums,int l,int h){
        if(h<=l)return;
        int less=l-1,i=l+1,more=h+1;
        int v=nums[l];
        while(i<more){
            if(nums[i]==v)i++;
            else if(nums[i]<v){
                swap(nums,i++,++less);
            }else{
                swap(nums,i,--more);
            }
        }
        quickSort(nums,l,less);
        quickSort(nums,more,h);
    }

    public static void main(String[] args) {
        new QuickSort().test(5000,10,10);
    }

}
