package inbox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class TestScanner {
    public static void main(String[] args) {
        test1();
    }

    /*
    next() nextXXX() nextLine()的用法
    读取键盘每一行的整型到一个二维列表
     */
    public static void test1(){
        Scanner sc=new Scanner(System.in);
        //使用二维list来存储不定行不定列的数据
        List<List<Integer>> list=new ArrayList<>();
        String str;
        //终止条件,下一行为空时
        while(!(str=sc.nextLine()).equals("")){
            String[]str1=str.split(" ");
            List<Integer>list1=new ArrayList<>();
            for(int i=0;i<str1.length;i++)
                list1.add(Integer.parseInt(str1[i]));
            list.add(list1);
        }
        System.out.println(list);

        sc.close();
    }
}
