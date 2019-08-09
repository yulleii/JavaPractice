package nowcoder.dynamicplan;

import java.util.HashMap;
/*
给出n个数字 a_1,...,a_n，问最多有多少不重叠的非空区间，使得每个区间内数字的xor都等于0。
 */
public class MostEOR {
    public static int mostEor(int []arr){
        int ans=0;
        int xor=0;
        int []mosts=new int[arr.length];
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            if(map.containsKey(xor)){
                int pre=map.get(xor);
                mosts[i]=pre==-1?1:(mosts[pre]+1);//mosts[i]=mosts[k-1]+1
            }
            if(i>0){
                mosts[i]=Math.max(mosts[i-1],mosts[i]);
            }
            map.put(xor,i);
            ans=Math.max(ans,mosts[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mostEor(new int[]{1,2,3,2,1,2,3}));
    }
}
