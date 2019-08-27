package practice;



public class QuickSort {
    public static void main(String[] args) {
        int[]nums=new int[]{5,4,2,2,1};
        new QuickSort().sort(nums);
        for(int i=0;i<nums.length;i++) System.out.print(nums[i]);
    }
    public void sort(int []nums){
        int len=nums.length;
        quickSort(nums,0,len-1);
    }
    public void quickSort(int[]nums,int left,int right){
        if(left>=right)return;
        int l=left-1,m=left+1,r=right+1;
        int v=nums[left];
        while(m<r){
            if(v==nums[m])m++;
            else if(v>nums[m])swap(nums,m++,++l);
            else swap(nums,m,--r);
        }
        quickSort(nums,left,l);
        quickSort(nums,r,right);

    }
    public void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
