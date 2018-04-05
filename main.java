import java.io.*;

public class main {
    public static void main(String args[]) throws IOException{
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        BT tree = new BT();
        
        tree.insert(10);
        tree.insert(5);
        tree.insert("AB");
        tree.insert("CD");
        
        tree.clear();
        
        tree.insert('b');
        tree.insert(13);
        tree.insert(15);
        tree.insert('c');
        
        
        System.out.print("preorder: ");
        tree.preorder();
        System.out.print("\ninorder: ");
        tree.inorder();
        System.out.print("\npostorder: ");
        tree.postorder();
        System.out.println("\n");
        
        
        System.out.println(tree.isLeaf(13));
        
        
    }
}
