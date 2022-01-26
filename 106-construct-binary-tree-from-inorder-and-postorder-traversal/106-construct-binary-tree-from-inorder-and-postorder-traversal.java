/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int postorderIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex=postorder.length-1;
        Map<Integer, Integer> inorderMap=new  HashMap<Integer, Integer>();
        
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }
        
        return buildBinaryTree(inorder, postorder, inorderMap, 0, inorder.length-1);
    }
    
    private TreeNode buildBinaryTree(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap,
                                    int startIndex, int endIndex) {
        if(startIndex>endIndex) {
            return null;
        }
        
        int val=postorder[postorderIndex--];
        int rootIndex = inorderMap.get(val);
        TreeNode node= new TreeNode(val);
        
         if(startIndex == endIndex) {
            return node;
        }
        
        
        node.right = buildBinaryTree(inorder, postorder, inorderMap, rootIndex+1, endIndex);
        node.left = buildBinaryTree(inorder, postorder, inorderMap, startIndex, rootIndex-1);
        
        return node;
    }
}