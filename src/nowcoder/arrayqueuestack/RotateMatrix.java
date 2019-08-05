package nowcoder.arrayqueuestack;
/*
旋转正方形矩阵
 */
public class RotateMatrix {
    public static void rotate(int [][]nums){
        int left=0;
        int row=nums.length-1;
        int col=nums[0].length-1;
        if(row!=col)
            throw new IllegalArgumentException("not a correct matrix");
        while(left<row){
            process(nums,left++,row--);
        }
    }

    public static void process(int[][]nums,int left,int right){
        int times=right-left;
        for(int i=0;i<times;i++){
           int tmp=nums[left][left+i];
           nums[left][left+i]=nums[right-i][left];
           nums[right-i][left]=nums[right][right-i];
           nums[right][right-i]=nums[left+i][right];
           nums[left+i][right]=tmp;
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
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }

}
