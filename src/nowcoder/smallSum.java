package nowcoder;

public class smallSum {
    private static int[]aux;
    public static int myMethod(int[] nums) {
        if(nums==null || nums.length<2)
            return 0;
        aux=new int[nums.length];
        return mergeSort(nums,0,nums.length-1);
    }

    public static int mergeSort(int[]nums,int l,int r){
        if(l==r)
            return 0;
        int mid=l+((r-l)>>1);
        return mergeSort(nums,l,mid)+mergeSort(nums,mid+1,r)+mergeProcess(nums,l,mid,r);
    }

    public static int mergeProcess(int []nums,int l,int m,int r){
        int p1=l;
        int p2=m+1;
        int sum=0;
        for(int k=l;k<=m;k++)
            aux[k]=nums[k];
        for(int k=l;k<=m;k++){
            if(p1>m)nums[k]=aux[p2++];
            else if(p2>r)nums[k]=aux[p1++];
            else if(nums[p1]<nums[p2]){
                nums[k]=aux[p1++];
                sum+=(r-p2+1)*nums[k];
            }else{
                nums[k]=aux[p2++];
            }
        }
        return sum;
    }

    public static int rightMethod(int[] nums) {
        if(nums==null || nums.length<2)
            return 0;
        int sum=0;
        for(int j=1;j<nums.length;j++){
            for(int i=0;i<j;i++){
                if(nums[i]<nums[j])
                    sum+=nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(myMethod(new int[]{5,4,3,2,1}));
    }
}
