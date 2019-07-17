import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> hashMap=new HashMap<>();
        hashMap.put("2","one");
        hashMap.put("3","two");
        hashMap.put("4","three");
        hashMap.put("5","four");
        hashMap.put("6","five");
        hashMap.put("6","fivee");
        Set set=hashMap.entrySet();
        for(Object obj:set){
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

        Set set1=hashMap.keySet();
        for(Object obj:set1){
            System.out.println(obj+"->"+hashMap.get(obj));
        }

        Collection values=hashMap.values();
        for(Object o:values){
            System.out.println(o);
        }

        ArrayList<Integer>arrayList=new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(99);
        arrayList.set(2,98);
        System.out.println(arrayList.get(0));;
        arrayList.remove(new Integer(98));
        Iterator i=arrayList.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        Integer[] obj=arrayList.toArray(new Integer[arrayList.size()]);
        for(int j=0;j<obj.length;j++)
            System.out.println(obj[j]);

    }
}
