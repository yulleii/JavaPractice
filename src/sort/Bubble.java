package sort;

public class Bubble {
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void swap(Comparable[]a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void sort(Comparable[]a){
        int N=a.length;
        boolean isSorted=false;
        for(int i=N-1;i>0 && !isSorted;i--){
            isSorted=true;
            for(int j=0;j<i;j++){
                if(less(a[j+1],a[j])){
                    isSorted=false;
                    swap(a,j,j+1);
                }
            }
        }
    }
    public static void show (Comparable[]a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    public static boolean isSorted(Comparable[]a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[]a=new String[]{"all","beg","zug","zoo"};
        new Bubble().sort(a);
        assert isSorted(a);
        show(a);
        Integer[] b=new Integer[]{2,1,3,4,7,9,6};
        new Bubble().sort(b);
        assert isSorted(b);
        show(b);

    }
}
