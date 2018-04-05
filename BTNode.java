public class BTNode<T>{
    T info;
    BTNode<T> left, right;
    
    public BTNode(){
        this(null,null,null);
    }
    
    public BTNode(T el){
        this(el,null,null);
    }
    
    public BTNode(T el, BTNode<T> l, BTNode<T> r){
        info = el;
        left = l;
        right = r;
    }
    
    public void setLeft(BTNode n){
        left = n;
    }
    
    public void setRight(BTNode n){
        right = n;
    }
    
    public BTNode getLeft(){
        return left;
    }
    
    public BTNode getRight(){
        return right;
    }
    
    public void setData(T data){
        info = data;
    }
    
    public T getData(){
        return info;
    }
    
}