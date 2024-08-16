internal class Solution {
  fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
    val node: TreeNode? = lca(root, startValue, destValue)
    val pathToStart = StringBuilder()
    val pathToDest = StringBuilder()
    dfs(node, startValue, pathToStart)
    dfs(node, destValue, pathToDest)
    return "U".repeat(pathToStart.length) + pathToDest.toString()
  }

  private fun lca(node: TreeNode?, p: Int, q: Int): TreeNode? {
    if (node == null || node.`val` === p || node.`val` === q) {
      return node
    }
    val left: TreeNode? = lca(node.left, p, q)
    val right: TreeNode? = lca(node.right, p, q)
    if (left != null && right != null) {
      return node
    }
    return if (left != null) left else right
  }

  private fun dfs(node: TreeNode?, x: Int, path: StringBuilder): Boolean {
    if (node == null) {
      return false
    }
    if (node.`val` === x) {
      return true
    }
    path.append('L')
    if (dfs(node.left, x, path)) {
      return true
    }
    path.setCharAt(path.length - 1, 'R')
    if (dfs(node.right, x, path)) {
      return true
    }
    path.deleteCharAt(path.length - 1)
    return false
  }
}
