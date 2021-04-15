package tree;
import java.util.Stack;


public class App {

//    static int[] srcArray = new int[] {3,6,1,9,4,7,11,1,2,5,16};
//    static int[] srcArray = new int[] {3,1};

    public static void main(String[] args)  {

        Stack<BiTNode> s = new Stack<>();

        BiTNode root = BiTNodes.createTree(10);
        // BiTNodes.layerPrint(root);
        // BiTNodes.midPrint(root);

        BiTNodes.getPath(root, root.getLeftChild().getRightChild(), s);

        while(!s.isEmpty()){
            System.out.println(s.pop().getData());
        }
    }
}
