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
  fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
    val nodes: Map<Int, TreeNode> = HashMap()
    val children: Set<Int> = HashSet()
    for (d in descriptions) {
      val parent = d[0]
      val child = d[1]
      val isLeft = d[2]
      if (!nodes.containsKey(parent)) {
        nodes.put(parent, TreeNode(parent))
      }
      if (!nodes.containsKey(child)) {
        nodes.put(child, TreeNode(child))
      }
      if (isLeft == 1) {
        nodes[parent].left = nodes[child]
      } else {
        nodes[parent].right = nodes[child]
      }
      children.add(child)
    }
    for (e in nodes.entrySet()) {
      if (!children.contains(e.getKey())) {
        return e.getValue()
      }
    }
    return null
  }
}
