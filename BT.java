public class BT<T>{
    private BTNode root;
    
    public BT(){
        root = null;
    }
    
    public boolean isEmpty(){
        return (root == null);
    }
    
    public void insert(T data){
        root = insert(root, data);
    }
    private BTNode insert(BTNode node, T data){
        if(node == null)
            node = new BTNode(data);
        else {
            if(node.getRight() == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
    return node;    
    }
    
    public int countNodes(){
         return countNodes(root);
    }
    
    private int countNodes(BTNode r){
        if(r == null)
            return 0;
        else{
            int count = 1;
            count += countNodes(r.getLeft());
            count += countNodes(r.getRight());
            return count;
        }
    }
    
    public boolean search(T val){
        return search(root, val);    
    }
    
    public boolean search(BTNode r, T val){
        if (r.getData() == val)
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), val))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), val))
                return true;
         return false; 
    }
    
    public void inorder(){
        inorder(root);
    }
    private void inorder(BTNode r){
        if (r != null){
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    
    public void preorder(){
         preorder(root);
    }
    private void preorder(BTNode r){
        if (r != null){
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());             
            preorder(r.getRight());
        }
    }
    
    public void postorder(){
        postorder(root);
    }
    private void postorder(BTNode r){
        if (r != null){
            postorder(r.getLeft());             
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }
////////////////////////////////////////////////////////////////////////////////    
    
    public BTNode getNode(T data){
        
        BTNode n = root;
        
        while( n != null){
            if( n.getData() == data)
                return n;
            
            if (n.right.getData() == data){
                return n.right;
            }
            
            n = n.left;
        }
        
        return null;
    }
    
    public boolean isLeaf(T data){
        return isLeaf(getNode(data));
    }
    
    public boolean isLeaf(BTNode n){
        return(n.left == null && n.right == null);
    }
    
    public void clear(){
        root = null;
    }
    
////////////////////////////////////////////////////////////////////////////////
//Binary Search Tree Methods
    
    public BTNode BSTsearch(T data){
        BTNode n = root;
        while(n != null){
            if(Integer.parseInt(data+"") == Integer.parseInt(n.getData()+""))
                return n;
            else{
                if(Integer.parseInt(data+"") < Integer.parseInt(n.getData()+""))
                    n = n.left;
                else
                    n = n.right;
            }
                
        }
        return null;
    }
    
    public void BSTinsert(T data){
        if(root == null){
            root = new BTNode(data);
            return;
        }
        BTNode n = root;
        BTNode p = null;
        while(n!=null){
            p = n;
            if( Integer.parseInt(data+"") < Integer.parseInt(n.getData()+""))
                n = n.left;
            else
                n = n.right;
        }
        
        if(Integer.parseInt(data+"") < Integer.parseInt(p.getData()+""))
            p.left = new BTNode(data);
        else
            p.right = new BTNode(data);
            
    }
     
    public void BSTdelete(T data){
        BTNode n = BSTsearch(data);
        if(n == null)
            return;
        
        BTNode p = getParent(data);
        if(isLeaf(n)){                                                           //case 1
            if(p == null)
                root = null;
            else if(p.left == n)
                p.left = null;
            else
                p.right = null;
        }
        
        if((n.left == null && n.right!=null)||(n.left != null && n.right==null)){ //case 2
            if(p == null){
                if(n.left!=null)
                    root = n.left;
                else
                    root = n.right;
            }
            else if(p.left == n){
                if(n.left != null)
                    p.left = n.left;
                else
                    p.left = n.right;
            }
            else{
                if(n.left != null)
                    p.right = n.left;
                else
                    p.right = n.right;
            }
        }
        
        if(n.left != null && n.right !=null){                                     //case 3
            BTNode m = BSTgetMax(n.left);
                
                T mData = (T)m.getData();
                BTNode mParent = getParent(mData);
                
                n.setData(m.getData());
                if(mParent.left == m)
                    mParent.left = m.left;
                else
                    mParent.right = m.left;
            System.out.println(mParent.getData());
        }
    }
    
    public int BSTgetMax(){
        return Integer.parseInt(BSTgetMax(root).getData()+"");
    }
    public BTNode BSTgetMax(BTNode n){
        while(n.right != null)
            n = n.right;
        
        return n;
    }
    
    public BTNode getParent(T data){
        BTNode n = root;
        BTNode p = null;
        while(Integer.parseInt(n.getData()+"")!=Integer.parseInt(data+"")){
            p = n;
            if( Integer.parseInt(data+"") < Integer.parseInt(n.getData()+""))
                n = n.left;
            else
                n = n.right;
        }
        return p;
    }
    
}
