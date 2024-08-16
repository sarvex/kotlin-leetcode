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
  fun minimumLevel(root: TreeNode?): Int {
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    var ans = 0
    var s: Long = MAX_VALUE
    var level = 1
    while (!q.isEmpty()) {
      var t: Long = 0
      for (m in q.size() downTo 1) {
        val node: TreeNode = q.poll()
        t += node.`val`
        if (node.left != null) {
          q.offer(node.left)
        }
        if (node.right != null) {
          q.offer(node.right)
        }
      }
      if (s > t) {
        s = t
        ans = level
      }
      ++level
    }
    return ans
  }
}
