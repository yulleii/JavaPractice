package practice;

public class Merge {
    private int[]aux;
    public static void main(String[] args) {
        int[]nums=new int[]{5,4,3,2,1};
        new Merge().sort(nums);
        for(int i=0;i<nums.length;i++) System.out.print(nums[i]);
    }
    public void sort(int []nums){
        int len=nums.length;
        aux=new int[len];
        merge(nums,0,len-1);
    }
    public void merge(int []nums,int left,int right){
        if(left>=right)return;
        int mid=left+((right-left)>>1);
        merge(nums,left,mid);
        merge(nums,mid+1,right);
        mergeProcess(nums,left,mid,right);
    }
    public void mergeProcess(int[]nums,int left,int mid,int right){
        for(int i=left;i<=right;i++)aux[i]=nums[i];
        int l=left,r=mid+1;
        int k=left;
        while(k<=right){
            if(l>mid)nums[k++]=aux[r++];
            else if(r>right)nums[k++]=aux[l++];
            else if(aux[l]<aux[r])nums[k++]=aux[l++];
            else nums[k++]=aux[r++];
        }
    }

    public void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}
