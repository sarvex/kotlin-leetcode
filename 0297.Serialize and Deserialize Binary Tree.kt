import java.util.*

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {
  // Encodes a tree to a single string.
  fun serialize(root: TreeNode?): String? {
    if (root == null) {
      return null
    }
    val ans: List<String> = ArrayList()
    val q: Deque<TreeNode> = LinkedList()
    q.offer(root)
    while (!q.isEmpty()) {
      val node: TreeNode? = q.poll()
      if (node != null) {
        ans.add(node.`val` + "")
        q.offer(node.left)
        q.offer(node.right)
      } else {
        ans.add("#")
      }
    }
    return java.lang.String.join(",", ans)
  }

  // Decodes your encoded data to tree.
  fun deserialize(data: String?): TreeNode? {
    if (data == null) {
      return null
    }
    val vals: Array<String> = data.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    var i = 0
    val root: TreeNode = TreeNode(vals[i++].toInt())
    val q: Deque<TreeNode> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      val node: TreeNode = q.poll()
      if ("#" != vals[i]) {
        node.left = TreeNode(vals[i].toInt())
        q.offer(node.left)
      }
      ++i
      if ("#" != vals[i]) {
        node.right = TreeNode(vals[i].toInt())
        q.offer(node.right)
      }
      ++i
    }
    return root
  }
} // Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
