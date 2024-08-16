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
  fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null) {
      return false
    }
    return same(root, subRoot) || isSubtree(root.left, subRoot)
        || isSubtree(root.right, subRoot)
  }

  private fun same(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null || q == null) {
      return p === q
    }
    return p.`val` === q.`val` && same(p.left, q.left) && same(p.right, q.right)
  }
}
