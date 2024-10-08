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
  fun isBalanced(root: TreeNode?): Boolean {
    return height(root) >= 0
  }

  private fun height(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val l = height(root.left)
    val r = height(root.right)
    if (l == -1 || r == -1 || abs(l - r) > 1) {
      return -1
    }
    return 1 + max(l, r)
  }
}
