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
  fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
    val node: TreeNode? = dfs(root, x)
    val l = count(node.left)
    val r = count(node.right)
    return max(max(l, r), n - l - r - 1) > n / 2
  }

  private fun dfs(root: TreeNode?, x: Int): TreeNode? {
    if (root == null || root.`val` === x) {
      return root
    }
    val node: TreeNode? = dfs(root.left, x)
    return if (node == null) dfs(root.right, x) else node
  }

  private fun count(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    return 1 + count(root.left) + count(root.right)
  }
}
