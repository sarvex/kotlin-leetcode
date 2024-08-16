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
internal class BSTIterator(root: TreeNode?) {
  private var cur = 0
  private val vals: List<Int> = ArrayList()

  init {
    inorder(root)
  }

  fun next(): Int {
    return vals[cur++]
  }

  fun hasNext(): Boolean {
    return cur < vals.size()
  }

  private fun inorder(root: TreeNode?) {
    if (root != null) {
      inorder(root.left)
      vals.add(root.`val`)
      inorder(root.right)
    }
  }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
