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
  fun minimumFlips(root: TreeNode?, result: Boolean): Int {
    return dfs(root)[if (result) 1 else 0]
  }

  private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
      return intArrayOf(1 shl 30, 1 shl 30)
    }
    val x: Int = root.`val`
    if (x < 2) {
      return intArrayOf(x, x xor 1)
    }
    val l = dfs(root.left)
    val r = dfs(root.right)
    var a = 0
    var b = 0
    if (x == 2) {
      a = l[0] + r[0]
      b = min(l[0] + r[1], min(l[1] + r[0], l[1] + r[1]))
    } else if (x == 3) {
      a = min(l[0] + r[0], min(l[0] + r[1], l[1] + r[0]))
      b = l[1] + r[1]
    } else if (x == 4) {
      a = min(l[0] + r[0], l[1] + r[1])
      b = min(l[0] + r[1], l[1] + r[0])
    } else {
      a = min(l[1], r[1])
      b = min(l[0], r[0])
    }
    return intArrayOf(a, b)
  }
}
