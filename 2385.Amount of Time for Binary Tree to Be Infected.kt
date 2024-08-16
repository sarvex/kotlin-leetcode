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
  private val g: Map<Int, List<Int>> = HashMap()

  fun amountOfTime(root: TreeNode?, start: Int): Int {
    dfs(root, null)
    return dfs2(start, -1)
  }

  private fun dfs(node: TreeNode?, fa: TreeNode?) {
    if (node == null) {
      return
    }
    if (fa != null) {
      g.computeIfAbsent(node.`val`) { k -> ArrayList() }.add(fa.`val`)
      g.computeIfAbsent(fa.`val`) { k -> ArrayList() }.add(node.`val`)
    }
    dfs(node.left, node)
    dfs(node.right, node)
  }

  private fun dfs2(node: Int, fa: Int): Int {
    var ans = 0
    for (nxt in g.getOrDefault(node, List.of())) {
      if (nxt != fa) {
        ans = max(ans, 1 + dfs2(nxt, node))
      }
    }
    return ans
  }
}
