package nowcoder;
/*
    给定一个整型矩阵matrix，请按照转圈的方式打印它
 */
public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][]matrix){
        int lx=0;
        int ly=0;
        int rx=matrix.length-1;
        int ry=matrix[0].length-1;
        while(lx<=rx && ly<=ry){
            printEdge(matrix,lx++,ly++,rx--,ry--);
        }
    }

    private static void printEdge(int[][]matrix,int lx,int ly,int rx,int ry){
        if(lx==rx){
            while(ly<=ry)
                System.out.print(matrix[lx][ly++]+" ");
        }else if(ly==ry){
            while(lx<=rx)
                System.out.print(matrix[lx++][ly]+" ");
        }else{
            int curY=ly;
            int curX=lx;
            while(curY!=ry)
                System.out.print(matrix[lx][curY++]+" ");

            while(curX!=rx)
                System.out.print(matrix[curX++][ry]+" ");

            while(curY!=ly)
                System.out.print(matrix[rx][curY--]+" ");

            while(curX!=lx)
                System.out.print(matrix[curX--][ly]+" ");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }
}
