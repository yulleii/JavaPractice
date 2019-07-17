public class HeapSort2 {
    private void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void sink(int[]nums,int f,int l){
        while(2*f<=l){
            int k=2*f;
            if(nums[k]<nums[k])k++;
            if(nums[f]>nums[k])break;
            swap(nums,f,k);
            f=k;
        }
    }
    public void sort(int[]nums){
        int N=nums.length-1;
        for(int i=N/2;i>0;i--)sink(nums,i,N);
        while(N>0){
            swap(nums,1,N--);
            sink(nums,1,N);
        }
    }

    public static void main(String[] args) {
        int[]nums=new int[]{9,8,7,6,5,4,3,2,1,0};
        new MergeSort().sort(nums);
        for(int i:nums)
            System.out.print(i+" ");
    }
}
