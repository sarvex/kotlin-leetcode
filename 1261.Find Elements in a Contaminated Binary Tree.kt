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
internal class FindElements(root: TreeNode) {
  private val s: Set<Int> = HashSet()

  init {
    root.`val` = 0
    dfs(root)
  }

  fun find(target: Int): Boolean {
    return s.contains(target)
  }

  private fun dfs(root: TreeNode) {
    s.add(root.`val`)
    if (root.left != null) {
      root.left.`val` = root.`val` * 2 + 1
      dfs(root.left)
    }
    if (root.right != null) {
      root.right.`val` = root.`val` * 2 + 2
      dfs(root.right)
    }
  }
}
/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
