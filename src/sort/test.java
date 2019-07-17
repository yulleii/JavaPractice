package sort;
import java.util.ArrayList;
public class test {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null)
            return new ArrayList<Integer>();
        ArrayList<Integer>array=new ArrayList<>();
        for(int i=0;i<k;i++){
            array.add(select(input,i));
        }
        return array;
    }
    private int select(int []nums,int k){
        int l=0,h=nums.length-1;
        while(h>l){
            int j=partition(nums,l,h);
            if(j==k)
                return nums[k];
            else if(j>k)
                h=j-1;
            else
                l=j+1;
        }
        return nums[k];
    }
    private int partition(int[]nums,int l,int h){
        int i=l,j=h+1;
        int v=nums[i];
        while(true){
            while(nums[++i]<v && i!=h);
            while(v<nums[--j] && j!=l);
            if(i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    private void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        ArrayList<Integer>arrayList= new test().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
        for(int i:arrayList)
            System.out.println(i);
    }
}
