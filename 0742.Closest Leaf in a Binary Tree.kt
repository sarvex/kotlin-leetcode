import java.util.*

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
  private val g: Map<TreeNode, List<TreeNode>> = HashMap()

  fun findClosestLeaf(root: TreeNode?, k: Int): Int {
    dfs(root, null)
    val q: Deque<TreeNode> = LinkedList()
    val vis: Set<TreeNode> = HashSet(q.size())
    for (node in g.keySet()) {
      if (node != null && node.`val` === k) {
        vis.add(node)
        q.offer(node)
        break
      }
    }
    while (true) {
      val node: TreeNode? = q.poll()
      if (node != null) {
        if (node.left === node.right) {
          return node.`val`
        }
        for (nxt in g[node]) {
          if (vis.add(nxt)) {
            q.offer(nxt)
          }
        }
      }
    }
  }

  private fun dfs(root: TreeNode?, fa: TreeNode?) {
    if (root != null) {
      g.computeIfAbsent(root) { k -> ArrayList() }.add(fa)
      g.computeIfAbsent(fa) { k -> ArrayList() }.add(root)
      dfs(root.left, root)
      dfs(root.right, root)
    }
  }
}
