package practice;

public class Select {
    public static void main(String[] args) {
        int[]nums=new int[]{5,5,3,2,1};
        new Select().sort(nums);
        for(int i=0;i<nums.length;i++) System.out.print(nums[i]);
    }
    public void sort(int[]nums){
        int len=nums.length;
        for(int i=0;i<len-1;i++){
            int min=i;
            for(int j=i+1;j<len;j++){
                if(nums[min]>nums[j])min=j;
            }
            swap(nums,min,i);
        }
    }
    public void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}
