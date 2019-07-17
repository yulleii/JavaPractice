import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       // TwoSum();
       //print(0,"这次从idea内部进行add push操作");
//        print(1,"i want to update this file!");
        //testMap
//        int []nums=testMap();
//       for(int i=0;i<nums.length;i++){
//           System.out.println(nums[i]);
//       }
       // demoFunction();
        //demoException();
        //demoSet();
        //demoMapTable();
        //demoList();
        //demoControlFlow();
        //demoString();
        //demoOperation();
        String str=new String("aaaab");
        System.out.println(indexKMP(str,"aaaaa"));
    }
    //常用类
    public static void demoFunction(){
        Random random=new Random();

        random.setSeed(45);
        print(1,random.nextInt(1000));
        print(2,random.nextFloat());
        random.setSeed(46);
        print(3,random.nextInt(100));

        List<Integer>array=Arrays.asList(new Integer[]{1,2,3,4,5});
        Collections.shuffle(array);
        print(4,array);

        Date date=new Date();
        print(5,date);
        print(6,date.getTime());
        print(7,date.getClass());

        DateFormat df=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        print(8,df.format(date));

        print(9,UUID.randomUUID().toString().replaceAll("-",""));
        print(10,Math.sqrt(1.f));
    }
    public static void demoException(){
        try{
            int k=2;
            k=k/1;
            if(k==2){
                throw new Exception("im angry!");
            }
        }catch(Exception e){
            e.printStackTrace();
            print(2,e.getMessage());
        }finally{
            print(3,"finally");
        }
    }
    public static void demoSet(){
        Set<String>strSet=new HashSet<String>();
        for(int i=0;i<3;i++){
            strSet.add(String.valueOf(i));
        }
        print(1,strSet);
        strSet.remove(String.valueOf(1));
        print(2,strSet);
        print(3, strSet.contains(String.valueOf(1)));
        print(4,strSet.isEmpty());
        print(5,strSet.size());
        strSet.addAll(Arrays.asList(new String[]{"A","B","C"}));
        print(6,strSet);

    }
    public static void demoMapTable(){
        Map<String,String> map=new HashMap<String,String>();
        for(int i=0;i<3;i++){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        for(Map.Entry<String,String>entry:map.entrySet()){
            print(2,entry.getKey()+"|"+entry.getValue());
        }
        print(1,map);
        print(3,map.values());
        print(4,map.keySet());
        print(5,map.get("2"));
        print(6,map.containsKey("A"));
        map.replace("2","27");
        print(7,map.get("2"));
    }
    public static void demoList(){
        List<String> strList=new ArrayList<>(10);
        for(int i=0;i<4;i++){
            strList.add(String.valueOf(i));
        }
        print(1,strList);
    }
    public static void demoControlFlow(){
        int a=4;
        int target=a==2?1:3;
        print(1,target);
        //ABC
        String grade="D";
        switch(grade){
            case "A":
                break;
            case "C":
                print(3,"60-80");
                break;
            case "D":
                print(4,"50-60");
                //break;
                default:
                    print(6,"unknown");
                    break;
        }
    }
    public static void demoString(){
        String str="hello world!";
        print(1,str.indexOf('x'));//d://xxx.pdf
        print(2,str.charAt(3));//str[1]
        print(3,str.codePointAt(1));
        print(4,str.compareToIgnoreCase("HELLO WORLD!"));
        print(5,str.compareTo("hello xorld!"));
        print(6,str.replace('o','e'));
        print(7,str);

        //非线程安全
        StringBuilder sb=new StringBuilder();
        sb.append("x ");
        sb.append(1.2);
        sb.append(1.3);
        print(8,sb.toString());
    }
    public static void demoOperation(){
        print(1,5+2);
        print(2,5-2);
        print(3,5*2);
        print(4,5/2);

        print(5,5%2);
        print(6,5<<2);
        print(7,5>>2);
        print(8,5|2);
        print(9,5^2);
        print(10,5==2);
        print(11,5!=2);
    }
    public static void print(int index,Object object){
        /**
         *
         * @param index 索引
         * @param object 对象
         */
        System.out.println(String.format("{%d},%s",index,object.toString()));
    }
    public static int[] testMap(){
        int[]nums=new int[]{1,2,8,10,20,30,42};
        int target=43;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key=target-nums[i];
            if(map.containsKey(key))
                return new int[]{i,map.get(key)};
            map.put(nums[i],i);
        }
        return new int[]{};
    }
    public static boolean TwoSum(){
        System.out.println(Math.round((float)Math.sqrt(13))-1);
        return false;
    }

    //KMP模式匹配
    public static void getNext(String str,int[]next){
        int j=0;
        int k=-1;
        next[0]=-1;
        int len=str.length();
        while(j<len-1) {
            if (k == -1 || str.charAt(j) == str.charAt(k)) {
                ++j;
                ++k;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        System.out.print("next:[");
        for (int i:next)
            System.out.print(i+" ");
        System.out.println("]");
    }
    public static int indexKMP(String s,String pattern){
       int i=0;
       int j=0;
       int slen=s.length();
       int plen=pattern.length();
       int []next=new int[plen];
       getNext(pattern,next);
       while(i<slen && j<plen){
           if(s.charAt(i)==pattern.charAt(j)){
               i++;
               j++;
           }else{
               if(next[j]==-1){
                   i++;
                   j=0;
               }else{
                   j=next[j];
               }
           }
           if(j==plen)
               return i-j;
       }
       return -1;
    }
}
class Person{
    private int age;
    private String name;
    private String number;
    public Person() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}