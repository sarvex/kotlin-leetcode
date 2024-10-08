/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
internal class Solution {
  fun tree2str(root: TreeNode?): String {
    if (root == null) {
      return ""
    }
    if (root.left == null && root.right == null) {
      return root.`val` + ""
    }
    if (root.right == null) {
      return root.`val` + "(" + tree2str(root.left) + ")"
    }
    return root.`val` + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")"
  }
}
