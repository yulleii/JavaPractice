package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeQuickSort<T extends Comparable<T>>extends QuickSort<T>{
    protected void sort(T[]nums,int l,int h){
        if(h<=l)
            return;
        int lt=l,i=l+1,gt=h;
        T v=nums[l];
        while(i<=gt){
            int cmp=nums[i].compareTo(v);
            if(cmp<0){
                swap(nums,lt++,i++);
            }else if(cmp>0){
                swap(nums,i,gt--);
            }else
                i++;
        }
        sort(nums,l,lt-1);
        sort(nums,gt+1,h);
    }

    public static void main(String[] args) {
        String[]str=new String[]{"Z","D","A","E","E","F"};
        new ThreeQuickSort<String>().sort(str);
        for(String s:str)
            System.out.print(s);
    }
}