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
  fun reverseOddLevels(root: TreeNode): TreeNode {
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    var i = 0
    while (!q.isEmpty()) {
      val t: List<TreeNode> = ArrayList()
      for (k in q.size() downTo 1) {
        val node: Unit = q.poll()
        if (i % 2 == 1) {
          t.add(node)
        }
        if (node.left != null) {
          q.offer(node.left)
          q.offer(node.right)
        }
      }
      var l = 0
      var r: Int = t.size() - 1
      while (l < r) {
        val x: Unit = t[l].`val`
        t[l].`val` = t[r].`val`
        t[r].`val` = x
        ++l
        --r
      }
      ++i
    }
    return root
  }
}
