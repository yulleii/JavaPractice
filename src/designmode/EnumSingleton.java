package designmode;

import java.util.Collections;

public enum EnumSingleton{
    INSTANCE;
    private String objName;


    public String getObjName() {
        return objName;
    }


    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        EnumSingleton first=EnumSingleton.INSTANCE;
        first.setObjName("first");
        System.out.println(first.getObjName());
        EnumSingleton second=EnumSingleton.INSTANCE;
        second.setObjName("second");
        System.out.println(second.getObjName());
        System.out.println(first.getObjName());
        System.out.println(second.getObjName());
        try{
            EnumSingleton[] s=EnumSingleton.class.getEnumConstants();
            for(EnumSingleton enumSingleton:s){
                System.out.println(enumSingleton.getObjName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}