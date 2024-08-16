import java.util.*

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
  fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    val q: Deque<Array<TreeNode?>> = ArrayDeque()
    q.offer(arrayOf(root, null))
    var d1 = 0
    var d2 = 0
    var p1: TreeNode? = null
    var p2: TreeNode? = null
    var depth = 0
    while (!q.isEmpty()) {
      for (n in q.size() downTo 1) {
        val t: Array<TreeNode?> = q.poll()
        val node: TreeNode? = t[0]
        val parent: TreeNode? = t[1]
        if (node.`val` === x) {
          d1 = depth
          p1 = parent
        } else if (node.`val` === y) {
          d2 = depth
          p2 = parent
        }
        if (node.left != null) {
          q.offer(arrayOf<TreeNode?>(node.left, node))
        }
        if (node.right != null) {
          q.offer(arrayOf<TreeNode?>(node.right, node))
        }
      }
      ++depth
    }
    return p1 !== p2 && d1 == d2
  }
}
