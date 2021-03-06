package nowcoder.sort;
/*
    在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
    求一个数组的小和。
    例子：
    [1,3,4,2,5]
    1左边比1小的数，没有；
    3左边比3小的数，1；
    4左边比4小的数，1、3；
    2左边比2小的数，1；
    5左边比5小的数，1、3、4、2；
    所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum {
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
        int mid=l+((r-l)/2);
        return mergeSort(nums,l,mid)+mergeSort(nums,mid+1,r)+mergeProcess(nums,l,mid,r);
    }

    public static int mergeProcess(int []nums,int l,int m,int r){
        int p1=l;
        int p2=m+1;
        int sum=0;
        for(int k=l;k<=r;k++)
            aux[k]=nums[k];
        for(int k=l;k<=r;k++){
            if(p1>m)
                nums[k]=aux[p2++];
            else if (p2>r)
                nums[k]=aux[p1++];
            else if(aux[p1]<aux[p2]){
                nums[k]=aux[p1++];
                //sum+=(r-p2+1);
            }else{
                sum+=(m-p1+1);
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
        System.out.println(myMethod(new int[]{1,2,3,4,5,6,7,0}));
    }
}
