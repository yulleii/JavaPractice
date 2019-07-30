package nowcoder;


import java.util.Arrays;

public class ThreeQuickSort extends LogTestArray {
    public void myMethod(int[]nums){
        if(nums==null || nums.length<2)
            return;
        sort(nums);
    }

    public void rightMethod(int[]nums){
        Arrays.sort(nums);
    }

    public static void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void sort(int[]nums){
        quickSort(nums,0,nums.length-1);
    }
    public void quickSort(int[]nums,int l,int r){
        if(r<=l)return;
        int m=(int)((r-l+1)*Math.random());
        swap(nums,m,r);
        int[]p=partition(nums,l,r);
        quickSort(nums,l,p[0]-1);
        quickSort(nums,p[1]+1,r);
    }
    public static int[] partition(int[]nums,int l,int r){
        int less=l-1,more=r;
        int v=nums[r];
        while(l<more){
            if(nums[l]==v)l++;
            else if(nums[l]<v)swap(nums,++less,l++);
            else{
                swap(nums,l,--r);
            }
        }
        swap(nums,r,more);
        return new int[]{less+1,more};
    }

    public static void main(String[] args) {
        new QuickSort().test(5000,100,9);
    }
}
