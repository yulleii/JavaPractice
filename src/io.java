import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class io {

    public static void main(String[] args) {
        //testFile();
        testFileInputStream();
    }

    public static void testFile(){
        //File一些方法
        File file=new File("hello.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println("getParent: "+file.getParent());
        if(file.exists())
            System.out.println("file exists");
        if(file.isDirectory())
            System.out.println("this is a directory");
        System.out.println("last modified: "+file.lastModified());
    }

    public static void testFileInputStream(){
        InputStream inputStream=null;
        try{
            inputStream=new FileInputStream("C:\\Users\\62359\\Desktop\\testjava\\src\\hello.txt");
            byte[]bytes=new byte[inputStream.available()];
            inputStream.read(bytes);
            String str=new String(bytes,"utf-8");
            System.out.println(str);
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
