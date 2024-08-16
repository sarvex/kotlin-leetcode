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
  private val ans: List<Int> = ArrayList()

  fun preorderTraversal(root: TreeNode?): List<Int> {
    dfs(root)
    return ans
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    ans.add(root.`val`)
    dfs(root.left)
    dfs(root.right)
  }
}
