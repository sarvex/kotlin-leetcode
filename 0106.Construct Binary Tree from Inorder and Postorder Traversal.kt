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
  private val d: Map<Int, Int> = HashMap()
  private var postorder: IntArray

  fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    this.postorder = postorder
    val n = inorder.size
    for (i in 0 until n) {
      d.put(inorder[i], i)
    }
    return dfs(0, 0, n)
  }

  private fun dfs(i: Int, j: Int, n: Int): TreeNode? {
    if (n <= 0) {
      return null
    }
    val v = postorder[j + n - 1]
    val k = d[v]!!
    val l: TreeNode? = dfs(i, j, k - i)
    val r: TreeNode? = dfs(k + 1, j + k - i, n - k + i - 1)
    return TreeNode(v, l, r)
  }
}
