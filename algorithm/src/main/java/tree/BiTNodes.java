package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;


public  class BiTNodes {

    public static BiTNode createTree(int len){
        BiTNode[] nodes= new BiTNode[len];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new BiTNode( i,null,null);
        }
        for (int i = 0; i < nodes.length; i++) {
            if((i*2+1)<nodes.length)
            {
                nodes[i].leftChild=nodes[i*2+1];
            }
            if((i*2+2)<nodes.length)
            {
                nodes[i].rightChild=nodes[i*2+2];
            }
        }
        return nodes[0];
    }
        //按层打印
    public static void  layerPrint(BiTNode root){
        if(root ==null  ){
            return;
        }
        BiTNode p;
        Queue<BiTNode> queue = new LinkedList<BiTNode>();
        queue.offer(root);
        while(queue.size()>0){
            p=queue.poll();
            System.out.println(p.data);
            if(p.leftChild!=null){
                queue.offer(p.leftChild);
            }
            if(p.rightChild!=null){
                queue.offer(p.rightChild);
            }
        }
    }
    //中序打印
    public static void midPrint(BiTNode node){
        if(node ==null){return;}
        if(node.leftChild!=null){
            midPrint(node.leftChild);
        }
        System.out.println(node.data);
        if(node.rightChild!=null){
            midPrint(node.rightChild);
        }
    }

    public static boolean getPath(BiTNode node,BiTNode targetNode,Stack<BiTNode> s){

        if(node==null){
            return false;
        }
        if(node== targetNode){
            s.push(node);
            return true;
        }
        if((getPath(node.leftChild,targetNode,s))||(getPath(node.rightChild, targetNode, s)))
        {
            s.push(node);
            return true;
        }

     return false;

        
    }
    
}
