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
  fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    return dfs(root, low, high)
  }

  private fun dfs(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) {
      return 0
    }
    val x: Int = root.`val`
    var ans = if (low <= x && x <= high) x else 0
    if (x > low) {
      ans += dfs(root.left, low, high)
    }
    if (x < high) {
      ans += dfs(root.right, low, high)
    }
    return ans
  }
}
