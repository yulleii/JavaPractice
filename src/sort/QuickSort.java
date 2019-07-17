package sort;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums,0,nums.length-1);
    }

    private void sort(T[]nums,int l,int h){
        if(h<=l)return;
        int j=partition(nums,l,h);
        sort(nums,l,j-1);
        sort(nums,j+1,h);
    }

    private void shuffle(T[]nums){
        List<Comparable<T>>list= Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private int partition(T[]nums,int l,int h){
        int i=l,j=h+1;
        T v=nums[l];
        while(true){
            while(less(nums[++i],v)&&i!=h);
            while(less(v,nums[--j])&&j!=l);
            if(i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    //应用：找出数组的第 k 个元素。
    public T select(T[]nums,int k){
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

    public static void main(String[] args) {
        String[]str=new String[]{"Z","D","A","E","E","F"};
        new QuickSort<String>().sort(str);
        System.out.println(new QuickSort<String>().select(str,str.length-2));
        for(String s:str)
            System.out.print(s);
    }

}
