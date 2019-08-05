package nowcoder.arrayqueuestack;

public class ZPrint {
    public static void print(int[][]arr){
        boolean flag=true;
        int row=arr.length-1;
        int col=arr[0].length-1;
        int ax=0;
        int ay=0;
        int by=0;
        int bx=0;
        while(ay<=col){
            printEdge(arr,flag,ax,ay,bx,by);
            ay=ax==row?ay+1:ay;
            ax=ax==row?row:ax+1;
            bx=by==col?bx+1:bx;
            by=by==col?col:by+1;
            flag=!flag;
        }
    }

    private static void printEdge(int[][]arr,boolean flag,int lx,int ly,int rx,int ry){
        if(flag){
            while(lx!=rx-1){
                System.out.print(arr[lx--][ly++]+" ");
            }
        }else{
            while(rx!=lx+1){
                System.out.print(arr[rx++][ry--]+" ");
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        print(matrix);
        System.out.println("=========");
    }
}
