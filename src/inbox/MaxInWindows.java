package inbox;

import java.util.ArrayList;
import java.util.LinkedList;

/*
    给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
    那么一共存在6个滑动窗口,他们的最大值分别为{4,4,6,6,6,5};针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
    {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
    {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[]num,int size){
        ArrayList<Integer>ret=new ArrayList<>();
        if(num==null)return ret;
        if(num.length<size||size<1)return ret;
        LinkedList<Integer>indexDeque=new LinkedList<>();
        //首先到第一个滑动窗口最后一个的前一个位置，后续每一步都要记录每一次滑动的最大值
        for(int i=0;i<size-1;i++){
            while(!indexDeque.isEmpty() && num[i]>num[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }

        for(int i=size-1;i< num.length;i++){
            //从队尾开始比较，删除比当前值小的点
            while(!indexDeque.isEmpty() && num[i]>num[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            //判断当前的最大值是否过期，删除队列头部已经不在滑动窗口内的点
            if(i-indexDeque.getFirst()+1>size){
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }

    public static void main(String[] args) {
        new MaxInWindows().maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }
}
