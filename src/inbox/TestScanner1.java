package inbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    第一行输入一个数n，表示接下来有n行
    每一行第一个数m表示这一行还有m个数
    读取输入，然后输出。
 */
public class TestScanner1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        ArrayList<List<Integer>>arrayList=new ArrayList<>();
        //读取n行
        for(int k=0;k<n;k++) {
            int m = sc.nextInt();
            Integer[] curs = new Integer[m];
            //读取m个
            for (int i = 0; i < m; i++)
                curs[i] = sc.nextInt();
            arrayList.add(Arrays.asList(curs));
        }

        sc.close();
        System.out.println(arrayList);
    }
}
