package tree;

public class BiTNode {
    int data;
    BiTNode leftChild;
    BiTNode rightChild;
    public BiTNode(int data, BiTNode leftChild, BiTNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public BiTNode getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(BiTNode leftChild) {
        this.leftChild = leftChild;
    }
    public BiTNode getRightChild() {
        return rightChild;
    }
    public void setRightChild(BiTNode rightChild) {
        this.rightChild = rightChild;
    }
    
    
    
}
