package nowcoder.dynamicplan;
/*
   机器人走最短路径问题
 */
public class MinPath {
    public static int minPath1(int[][]matrix){
        return process1(matrix,matrix.length-1, matrix[0].length-1);
    }
    private static int process1(int[][]matrix,int i,int j){
        int res=matrix[i][j];
        if(i==0 && j==0)return res;
        if(i!=0 && j==0)return res+process1(matrix,i-1,j);
        if(i==0 && j!=0)return res+process1(matrix,i,j-1);
        return Math.min(process1(matrix,i,j-1), process1(matrix,i-1,j))+res;
    }

    // for Solution
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    private static int dp(int[][]matrix){
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)return 0;
        int row=matrix.length;
        int col=matrix[0].length;
        int[][]dp=new int[row][col];
        dp[0][0]=matrix[0][0];
        for(int m=1;m<row;m++){
            dp[m][0]=matrix[m][0]+dp[m-1][0];
        }
        for(int n=1;n<col;n++){
            dp[0][n]=dp[0][n-1]+matrix[0][n];
        }
        for(int r=1;r<row;r++){
            for(int c=1;c<col;c++){
                dp[r][c]=Math.min(dp[r][c-1],dp[r-1][c])+matrix[r][c];
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int [][]n=null;
        n=generateRandomMatrix(10,10);
        System.out.println(dp(n));
        System.out.println(minPath1(n));

    }
}
