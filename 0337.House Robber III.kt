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
  fun rob(root: TreeNode?): Int {
    val ans = dfs(root)
    return max(ans[0], ans[1])
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return IntArray(2)
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    return intArrayOf(root.`val` + l[1] + r[1], max(l[0], l[1]) + max(r[0], r[1]))
  }
}
