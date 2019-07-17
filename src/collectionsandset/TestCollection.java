package collectionsandset;

import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        TestMap();
        //TestSet();
        //TestArrayList();
    }
    public static void TestArrayList(){
        ArrayList<Computer>array=new ArrayList<>();
        Computer computer=new Computer("Dell","2019-3-15","6090");
        array.add(new Computer("apple","2019-10-20","13888"));
        array.add(new Computer("asuv","2019-11-11","8000"));
        array.add(computer);
        ArrayList<Computer>array1=new ArrayList<>();
        array.add(new Computer("apple","2019-10-20","13888"));
        array.add(new Computer("asuv","2019-11-11","8000"));
        //遍历元素
        Iterator iterator=array.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for(Computer c:array){
            System.out.println(c);
        }
        for(int i=0;i<array.size();i++)
            System.out.println(array.get(i));
        //contains
        System.out.println(array.contains(new Computer("apple","2019-10-20","13888")));
        System.out.println(array.containsAll(array1));
    }

    public static void TestSet(){
        //自然排序
        Set set=new TreeSet();
        Computer computer1=new Computer("apple","2019-10-20","13888");
        set.add(computer1);
        set.add(new Computer("aauv","2019-11-11","8000"));
        set.add(new Computer("aauv","2019-11-11","8000"));
        System.out.println(set);
        //定制排序
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Computer && o2 instanceof Computer){
                    Computer computer1=(Computer)o1;
                    Computer computer2=(Computer)o2;
                    int i=computer1.getCreatedDate().compareTo(computer2.getCreatedDate());
                    if(i==0){
                        i=computer1.getPrice().compareTo(computer2.getPrice());
                        if(i==0)
                            return computer1.getName().compareTo(computer2.getName());
                    }
                    return i;
                }
                return 0;
            }
        };
        Set set1=new TreeSet(comparator);
        set1.add(computer1);
        set1.add(new Computer("aauv","2019-11-11","8000"));
        set1.add(new Computer("aauv","2019-11-11","8000"));
        set1.add(new Computer("apple","2019-10-20","8000"));
        System.out.println(set1);
    }

    public static void TestMap(){
        Map map=new Hashtable();
        map.put(new Computer("apple","1","5000"),100);
        map.put(new Computer("watch", "2","3000"),"wow");
        //遍历map
        //遍历key
        Set set=map.keySet();
        for(Object obj:set){
            System.out.println(obj+" "+map.get(obj));
        }
        //遍历value
        Collection values=map.values();
        Iterator i=values.iterator();
        while(i.hasNext())
            System.out.println(i.next());
        //遍历k-v
        Set entrySet=map.entrySet();
        for(Object obj:entrySet){
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(obj);
        }
    }
}
