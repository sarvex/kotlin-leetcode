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
  fun sumRootToLeaf(root: TreeNode?): Int {
    return dfs(root, 0)
  }

  private fun dfs(root: TreeNode?, t: Int): Int {
    var t = t
    if (root == null) {
      return 0
    }
    t = (t shl 1) or root.`val`
    if (root.left == null && root.right == null) {
      return t
    }
    return dfs(root.left, t) + dfs(root.right, t)
  }
}
