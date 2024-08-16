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
  fun generateTrees(n: Int): List<TreeNode> {
    return dfs(1, n)
  }

  private fun dfs(i: Int, j: Int): List<TreeNode> {
    val ans: List<TreeNode> = ArrayList()
    if (i > j) {
      ans.add(null)
      return ans
    }
    for (v in i..j) {
      val left: List<TreeNode> = dfs(i, v - 1)
      val right: List<TreeNode> = dfs(v + 1, j)
      for (l in left) {
        for (r in right) {
          ans.add(TreeNode(v, l, r))
        }
      }
    }
    return ans
  }
}
