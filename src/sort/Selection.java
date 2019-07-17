package sort;

public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N=nums.length;
        for(int i=0;i<N-1;i++){
            int min=i;
            for(int j=i+1;j<N;j++){
                if(less(nums[j],nums[min])){
                    min=j;
                }
            }
            swap(nums,i,min);
        }
    }

    public static void main(String[] args) {
        Integer[]nums=new Integer[]{1,3,2,6,4,5};
        new Selection().sort(nums);
        for(int i:nums)
            System.out.print(i);
    }
}
