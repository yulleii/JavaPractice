package sort;

public class Up2DownMergeSort<T extends Comparable<T>>extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        aux=(T[])new Comparable[nums.length];
        sort(nums,0,nums.length-1);
    }
    private void sort(T[]nums,int l,int h){
        if(h<=l)
            return;
        int mid=l+(h-l)/2;
        sort(nums,l,mid);
        sort(nums,mid+1,h);
        merge(nums,l,mid,h);
    }

    public static void main(String[] args) {
        String[]str=new String[]{"Z","D","A","E","E","F"};
        new Up2DownMergeSort<String>().sort(str);
        for(String s:str)
            System.out.println(s);
        Integer[]ints=new Integer[]{0,2,1,0,7,9,8};
        new Up2DownMergeSort<Integer>().sort(ints);
        for(int i:ints)
            System.out.println(i);
    }
}
