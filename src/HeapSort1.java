public class HeapSort1 {
    private void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void sink(int[]nums,int f,int l){
        while(2*f<=l){
            int k=2*f;
            if(nums[k]<nums[k+1])
                k++;
            if(nums[f]>nums[k])
                break;
            swap(nums,f,k);
            f=k;
        }
    }
    public void sort(int[]nums){
        int N=nums.length-1;
        for(int i=N/2;i>0;i--)
            sink(nums,i,N);
        while(N>1){
            swap(nums,1,N--);
            sink(nums,1,N);
        }
    }

    public static void main(String[] args) {
        int[]nums=new int[]{1,2,0,-1,3,2,1,5};
        new MergeSort().sort(nums);
        for(int i:nums)
            System.out.print(i+" ");
    }
}
