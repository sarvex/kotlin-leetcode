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
  private val pos: Map<Int, Int> = HashMap()
  private var preorder: IntArray

  fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
    this.preorder = preorder
    for (i in postorder.indices) {
      pos.put(postorder[i], i)
    }
    return dfs(0, preorder.size - 1, 0, postorder.size - 1)
  }

  private fun dfs(a: Int, b: Int, c: Int, d: Int): TreeNode? {
    if (a > b) {
      return null
    }
    val root: TreeNode = TreeNode(preorder[a])
    if (a == b) {
      return root
    }
    val i = pos[preorder[a + 1]]!!
    val m = i - c + 1
    root.left = dfs(a + 1, a + m, c, i)
    root.right = dfs(a + m + 1, b, i + 1, d - 1)
    return root
  }
}
