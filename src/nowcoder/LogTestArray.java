package nowcoder;

import java.util.Arrays;

public abstract class LogTestArray{
    //产生随机样本
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //随机长度的数组
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            //随机的数据
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void swap(int[]arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public abstract void myMethod(int []nums);

    //正确的算法
    public abstract void rightMethod(int []nums);

    public void test(int t,int size,int value) {
        int testTime = t;
        int maxSize = size;
        int maxValue = value;
        boolean succeed = true;
        int[]arr=null;
        int[]arr1=null;
        int[]arr2=null;
        for (int i = 0; i < testTime; i++) {
            arr = generateRandomArray(maxSize, maxValue);
            arr1=copyArray(arr);
            arr2 = copyArray(arr);
            myMethod(arr1);
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }

        if(!succeed){
            System.out.println("Fucking fucked!");
            printArray(arr);
            printArray(arr1);
            printArray(arr2);
        }else
            System.out.println("Nice!");
    }
}

