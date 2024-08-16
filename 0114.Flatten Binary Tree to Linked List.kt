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
  fun flatten(root: TreeNode?) {
    var root: TreeNode? = root
    while (root != null) {
      if (root.left != null) {
        // 找到当前节点左子树的最右节点
        var pre: TreeNode = root.left
        while (pre.right != null) {
          pre = pre.right
        }

        // 将左子树的最右节点指向原来的右子树
        pre.right = root.right

        // 将当前节点指向左子树
        root.right = root.left
        root.left = null
      }
      root = root.right
    }
  }
}
