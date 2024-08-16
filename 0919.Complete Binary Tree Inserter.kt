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
internal class CBTInserter(root: TreeNode) {
  private val tree: List<TreeNode> = ArrayList()

  init {
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      for (i in q.size() downTo 1) {
        val node: TreeNode = q.poll()
        tree.add(node)
        if (node.left != null) {
          q.offer(node.left)
        }
        if (node.right != null) {
          q.offer(node.right)
        }
      }
    }
  }

  fun insert(`val`: Int): Int {
    val p: TreeNode = tree[(tree.size() - 1) / 2]
    val node: TreeNode = TreeNode(`val`)
    tree.add(node)
    if (p.left == null) {
      p.left = node
    } else {
      p.right = node
    }
    return p.`val`
  }

  fun get_root(): TreeNode {
    return tree[0]
  }
}
/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
