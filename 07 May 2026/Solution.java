/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
   
    public boolean isSubTree(Node root1, Node root2) {
        // code here
        if(root1==null && root2==null) return true;
     if(root1==null || root2==null) return false;
     //start from here 
     boolean check = false;
     if(root1.data == root2.data) 
     {
         check = isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
     }
     //look at left 
     if(!check)
     {
         check = isSubTree(root1.left,root2);
     }
     
     //look at right 
     if(!check)
     {
         check = isSubTree(root1.right,root2);
     }
     return check;
        
    }
}