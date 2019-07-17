package tree;

import java.util.HashMap;
import java.util.Map;

public class TestBinaryTree {
    public static void main(String[] args) {
        int[]array=new int[]{1,2,3,4,5,6,7,8,9,10,11};
        BinaryTree binaryTree=new BinaryTree(array,0);
        binaryTree.layerTranverse(binaryTree.root);
    }
}
