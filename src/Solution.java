public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        return search(array,k+0.5)-search(array,k-0.5);
    }
    private  int search(int[]array,double k){
        int left=0,right=array.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(array[mid]>k)right=mid-1;
            else left=mid+1;
        }
        System.out.println(left);
        return left;
    }

    public static void main(String[] args) {
        new Solution().GetNumberOfK(new int[]{1,2,2,2,3},2);
    }
}
