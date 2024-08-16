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
  private val ans: List<List<Int>> = ArrayList()

  fun findLeaves(root: TreeNode?): List<List<Int>> {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    val h: Int = max(l, r)
    if (ans.size() === h) {
      ans.add(ArrayList())
    }
    ans[h].add(root.`val`)
    return h + 1
  }
}
