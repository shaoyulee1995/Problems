import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
        Queue<Node> bfs = new LinkedList<>();
        
        bfs.add(root);
        
        while(!bfs.isEmpty()){
            Node node = bfs.poll();
            System.out.print(node.data +" ");
            if(node.left != null){
                bfs.add(node.left);
            }    
            if(node.right != null){
                bfs.add(node.right);
            }
        }
    }

	public static Node insert(Node root, int data) {