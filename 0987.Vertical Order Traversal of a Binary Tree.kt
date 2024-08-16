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
  private val nodes: List<IntArray> = ArrayList()

  fun verticalTraversal(root: TreeNode?): List<List<Int>> {
    dfs(root, 0, 0)
    Collections.sort(nodes) { a, b ->
      if (a.get(0) !== b.get(0)) {
        return@sort Integer.compare(a.get(0), b.get(0))
      }
      if (a.get(1) !== b.get(1)) {
        return@sort Integer.compare(a.get(1), b.get(1))
      }
      Integer.compare(a.get(2), b.get(2))
    }
    val ans: List<List<Int>> = ArrayList()
    var prev = -2000
    for (node in nodes) {
      val j = node[0]
      val `val` = node[2]
      if (prev != j) {
        ans.add(ArrayList())
        prev = j
      }
      ans[ans.size() - 1].add(`val`)
    }

    return ans
  }

  private fun dfs(root: TreeNode?, i: Int, j: Int) {
    if (root == null) {
      return
    }
    nodes.add(intArrayOf(j, i, root.`val`))
    dfs(root.left, i + 1, j - 1)
    dfs(root.right, i + 1, j + 1)
  }
}
