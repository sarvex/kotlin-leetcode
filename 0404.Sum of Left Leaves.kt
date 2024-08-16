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
  fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    var ans = sumOfLeftLeaves(root.right)
    if (root.left != null) {
      if (root.left.left === root.left.right) {
        ans += root.left.`val`
      } else {
        ans += sumOfLeftLeaves(root.left)
      }
    }
    return ans
  }
}
