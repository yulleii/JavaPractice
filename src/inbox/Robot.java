package inbox;
/*
    地上有一个m行和n列的方格。
    一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
    但是不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格（35,37）
    因为3+5+3+7 = 18。但是，它不能进入方格（35,38）
    因为3+5+3+8 = 19。
    请问该机器人能够达到多少个格子？
 */
public class Robot {
    private int bitSum(int target1,int target2){
        int res=0;
        while(target1!=0){
            res+=target1%10;
            target1=target1/10;
        }
        while(target2!=0){
            res+=target2%10;
            target2=target2/10;
        }
        return res;
    }
    public int moveCount(int threshold,int rows,int cols){
        boolean[][]flag=new boolean[rows][cols];
        return moveCount(threshold,rows,cols,0,0,flag);
    }

    private int moveCount(int threshold,int rows,int cols,int cR,int cL,boolean[][]flag){
        if(cR<0 ||  cR==rows || cL<0 || cL==cols || flag[cR][cL] || bitSum(cR,cL)>threshold){
            return 0;
        }
        flag[cR][cL]=true;
        int res=0;
        res+=moveCount(threshold,rows,cols,cR+1,cL,flag)+
                moveCount(threshold,rows,cols,cR-1,cL,flag)+
                moveCount(threshold,rows,cols,cR,cL+1,flag)+
                moveCount(threshold,rows,cols,cR,cL-1,flag)+1;
        return res;
    }


}
