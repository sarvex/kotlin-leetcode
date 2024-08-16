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
  private var prev: TreeNode? = null

  fun isValidBST(root: TreeNode?): Boolean {
    return dfs(root)
  }

  private fun dfs(root: TreeNode?): Boolean {
    if (root == null) {
      return true
    }
    if (!dfs(root.left)) {
      return false
    }
    if (prev != null && prev.`val` >= root.`val`) {
      return false
    }
    prev = root
    return dfs(root.right)
  }
}
