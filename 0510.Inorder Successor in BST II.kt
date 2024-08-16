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
  fun inorderSuccessor(node: Node): Node {
    var node = node
    if (node.right != null) {
      node = node.right
      while (node.left != null) {
        node = node.left
      }
      return node
    }
    while (node.parent != null && node.parent.right === node) {
      node = node.parent
    }
    return node.parent
  }
}
