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
  private val s: List<Int> = ArrayList()

  fun replaceValueInTree(root: TreeNode): TreeNode {
    dfs1(root, 0)
    root.`val` = 0
    dfs2(root, 0)
    return root
  }

  private fun dfs1(root: TreeNode?, depth: Int) {
    if (root == null) {
      return
    }
    if (s.size() <= depth) {
      s.add(0)
    }
    s.set(depth, s[depth] + root.`val`)
    dfs1(root.left, depth + 1)
    dfs1(root.right, depth + 1)
  }

  private fun dfs2(root: TreeNode, depth: Int) {
    var depth = depth
    val l = if (root.left == null) 0 else root.left.`val`
    val r = if (root.right == null) 0 else root.right.`val`
    val sub = l + r
    ++depth
    if (root.left != null) {
      root.left.`val` = s[depth] - sub
      dfs2(root.left, depth)
    }
    if (root.right != null) {
      root.right.`val` = s[depth] - sub
      dfs2(root.right, depth)
    }
  }
}
