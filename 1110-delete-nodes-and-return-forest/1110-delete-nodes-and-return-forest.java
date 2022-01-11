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
    // BFS like thought:
    // 1. change the parent -> delete_node to parent->null
    // 2. add the to_delete's children to the final list.
   public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList();
        Set<Integer> set = new HashSet();
        for(int t : to_delete) {
            set.add(t);
        }
        solve(root, set, res);
        if(!set.contains(root.val))
            res.add(root);
        
        return res;
    }
    
    TreeNode solve(TreeNode root, Set<Integer> set, List<TreeNode> res) {
        if(root == null) return null;
        root.left = solve(root.left, set, res);
        root.right = solve(root.right, set, res);
        if(set.contains(root.val)) {
            if(root.left != null) {
                res.add(root.left);
            }
            if(root.right != null) {
                res.add(root.right);
            }
            return null;
        }
        return root;
    }
}