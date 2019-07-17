package sort;

public class Down2UpMerge<T extends Comparable<T>>extends MergeSort<T> {
    public void sort(T[]nums){
        int N=nums.length;
        aux=(T[])new Comparable[N];

        for(int sz=1;sz<N;sz+=sz){
            for(int lo=0;lo<N-sz;lo+=sz+sz){
                merge(nums,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }
    public static void main(String[] args) {
        String[]str=new String[]{"Z","D","A","E","E","F"};
        new Up2DownMergeSort<String>().sort(str);
        for(String s:str)
            System.out.println(s);
    }

}
