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
  fun sumEvenGrandparent(root: TreeNode?): Int {
    return dfs(root, 1)
  }

  private fun dfs(root: TreeNode?, x: Int): Int {
    if (root == null) {
      return 0
    }
    var ans = dfs(root.left, root.`val`) + dfs(root.right, root.`val`)
    if (x % 2 == 0) {
      if (root.left != null) {
        ans += root.left.`val`
      }
      if (root.right != null) {
        ans += root.right.`val`
      }
    }
    return ans
  }
}
