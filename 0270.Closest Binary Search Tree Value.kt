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
  private var ans = 0
  private var target = 0.0
  private var diff: Double = MAX_VALUE

  fun closestValue(root: TreeNode?, target: Double): Int {
    this.target = target
    dfs(root)
    return ans
  }

  private fun dfs(node: TreeNode?) {
    var node: TreeNode = node ?: return
    val nxt: Double = Math.abs(node.`val` - target)
    if (nxt < diff || (nxt == diff && node.`val` < ans)) {
      diff = nxt
      ans = node.`val`
    }
    node = if (target < node.`val`) node.left else node.right
    dfs(node)
  }
}
