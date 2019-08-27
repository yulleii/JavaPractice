package practice;

public class Bubble {
    public static void main(String[] args) {
        int[]nums=new int[]{5,4,3,2,1};
        new Bubble().sort(nums);
        for(int i=0;i<nums.length;i++) System.out.print(nums[i]);
    }

    public void sort(int[]nums){
        int len=nums.length;
        boolean flag=false;
        for(int i=len-1;i>0 && !flag;i--){
            flag=true;
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){swap(nums,j,j+1); flag=false;}
            }
        }
    }

    public void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
