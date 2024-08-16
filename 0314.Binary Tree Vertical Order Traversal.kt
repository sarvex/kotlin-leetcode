import java.util.TreeMap

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
  private val d: TreeMap<Int, List<IntArray>> = TreeMap()

  fun verticalOrder(root: TreeNode?): List<List<Int>> {
    dfs(root, 0, 0)
    val ans: List<List<Int>> = ArrayList()
    for (v in d.values()) {
      Collections.sort(v) { a, b -> a.get(0) - b.get(0) }
      val t: List<Int> = ArrayList()
      for (e in v) {
        t.add(e.get(1))
      }
      ans.add(t)
    }
    return ans
  }

  private fun dfs(root: TreeNode?, depth: Int, offset: Int) {
    if (root == null) {
      return
    }
    d.computeIfAbsent(offset) { k -> ArrayList() }.add(intArrayOf(depth, root.`val`))
    dfs(root.left, depth + 1, offset - 1)
    dfs(root.right, depth + 1, offset + 1)
  }
}
