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
  fun minCameraCover(root: TreeNode?): Int {
    val ans = dfs(root)
    return min(ans[0], ans[1])
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return intArrayOf(1 shl 29, 0, 0)
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    val a: Int = 1 + min(min(l[0], l[1]), l[2]) + min(min(r[0], r[1]), r[2])
    val b: Int = min(min(l[0] + r[1], l[1] + r[0]), l[0] + r[0])
    val c = l[1] + r[1]
    return intArrayOf(a, b, c)
  }
}
