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

  fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {
    dfs(root)
    val ans: List<List<Int>> = ArrayList()
    for (x in queries) {
      var i: Int = Collections.binarySearch(nums, x + 1)
      var j: Int = Collections.binarySearch(nums, x)
      i = if (i < 0) -i - 2 else i - 1
      j = if (j < 0) -j - 1 else j
      val mi = if (i >= 0 && i < nums.size()) nums[i] else -1
      val mx = if (j >= 0 && j < nums.size()) nums[j] else -1
      ans.add(List.of(mi, mx))
    }
    return ans
  }

  private fun dfs(root: TreeNode?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    nums.add(root.`val`)
    dfs(root.right)
  }
}
