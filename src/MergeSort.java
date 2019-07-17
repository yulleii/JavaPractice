public class MergeSort {
    private int[]aux;
    private void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void merge(int[]nums,int l,int m,int h){
        int i=l,j=m+1;
        for(int k=l;k<=h;k++){
            aux[k]=nums[k];
        }
        for(int k=l;k<=h;k++){
            if(i>m)nums[k]=aux[j++];
            else if(j>h)nums[k]=aux[i++];
            else if(aux[i]<=aux[j]) nums[k]=aux[i++];
            else nums[k]=aux[j++];
        }
    }

    public void sort(int[]nums){
        int N=nums.length;
        aux=new int[nums.length];
        sort(nums,0,N-1);
    }

    public void sort(int[]nums,int l,int h){
        if(h<=l)return;
        int m=l+(h-l)/2;
        sort(nums,l,m);
        sort(nums,m+1,h);
        merge(nums,l,m,h);
    }

    public static void main(String[] args) {
        MergeSort m=new MergeSort();
        int[]array=new int[]{0,2,1,0,7,9,8};
        m.sort(array);
        for(int i:array)
            System.out.println(i);
    }
}
