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
  fun findDistance(root: TreeNode?, p: Int, q: Int): Int {
    val g: TreeNode? = lca(root, p, q)
    return dfs(g, p) + dfs(g, q)
  }

  private fun dfs(root: TreeNode?, v: Int): Int {
    if (root == null) {
      return -1
    }
    if (root.`val` === v) {
      return 0
    }
    val left = dfs(root.left, v)
    val right = dfs(root.right, v)
    if (left == -1 && right == -1) {
      return -1
    }
    return 1 + max(left, right)
  }

  private fun lca(root: TreeNode?, p: Int, q: Int): TreeNode? {
    if (root == null || root.`val` === p || root.`val` === q) {
      return root
    }
    val left: TreeNode? = lca(root.left, p, q)
    val right: TreeNode? = lca(root.right, p, q)
    if (left == null) {
      return right
    }
    if (right == null) {
      return left
    }
    return root
  }
}
