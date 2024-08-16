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
  private val nums: List<Int> = ArrayList()

  fun balanceBST(root: TreeNode?): TreeNode? {
    dfs(root)
    return build(0, nums.size() - 1)
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    nums.add(root.`val`)
    dfs(root.right)
  }

  private fun build(i: Int, j: Int): TreeNode? {
    if (i > j) {
      return null
    }
    val mid = (i + j) shr 1
    val left: TreeNode? = build(i, mid - 1)
    val right: TreeNode? = build(mid + 1, j)
    return TreeNode(nums[mid], left, right)
  }
}
