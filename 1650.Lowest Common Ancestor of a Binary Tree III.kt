/*
// Definition for a Node.
class Node {
   public int val;
   public Node left;
   public Node right;
   public Node parent;
};
*/
internal class Solution {
  fun lowestCommonAncestor(p: Node?, q: Node): Node {
    val vis: Set<Node> = HashSet()
    run {
      var node = p
      while (node != null) {
        vis.add(node)
        node = node.parent
      }
    }
    var node = q
    while (true) {
      if (!vis.add(node)) {
        return node
      }
      node = node.parent
    }
  }
}
