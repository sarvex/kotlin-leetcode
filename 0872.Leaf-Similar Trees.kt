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
  fun leafSimilar(root1: TreeNode, root2: TreeNode): Boolean {
    val l1: List<Int> = ArrayList()
    val l2: List<Int> = ArrayList()
    dfs(root1, l1)
    dfs(root2, l2)
    return l1.equals(l2)
  }

  private fun dfs(root: TreeNode, nums: List<Int>) {
    if (root.left === root.right) {
      nums.add(root.`val`)
      return
    }
    if (root.left != null) {
      dfs(root.left, nums)
    }
    if (root.right != null) {
      dfs(root.right, nums)
    }
  }
}
