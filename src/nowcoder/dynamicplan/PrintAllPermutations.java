package nowcoder.dynamicplan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PrintAllPermutations {
    public static void printAllPermutations1(String str){
        char[]chars=str.toCharArray();
        printAllSub(chars,0,"");
    }

    public static void printAllSub(char[]c, int i, String res){
        if(i==c.length){
            System.out.println(String.valueOf(res));
            return;
        }
        printAllSub(c,i+1,res);
        printAllSub(c,i+1,res+String.valueOf(c[i]));
    }
    public static void process(char[] chs, int i, List<Character> res) {
        if(i == chs.length) {
            printList(res);
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chs[i]);
        process(chs, i+1, resKeep);
        List<Character> resNoInclude = copyList(res);
        process(chs, i+1, resNoInclude);
    }

    public static void printList(List<Character> res) {
        if(res.isEmpty())
            return;
        for(Character c:res){
            System.out.print(c);
        }
    }
    public static List<Character> copyList(List<Character> list){
        List<Character>list1=new ArrayList<>();
        for(Character c:list)
            list1.add(c);
        return list1;
    }

    public static void main(String[] args) {
        process("abcd".toCharArray(),0,new ArrayList<Character>());
    }
}
