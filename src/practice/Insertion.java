package practice;

public class Insertion {
    public static void main(String[] args) {
        int[]nums=new int[]{5,4,3,2,1};
        new Insertion().sort(nums);
        for(int i=0;i<nums.length;i++) System.out.print(nums[i]);
    }
    public void sort(int[]nums){
        int len=nums.length;
        for(int i=1;i<len;i++){
            for(int j=i;j>0;j--){
                if(nums[j]<nums[j-1])swap(nums,j,j-1);
            }
        }
    }
    public void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
