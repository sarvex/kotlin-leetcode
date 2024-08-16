/*
// Definition for a Node.
class Node {
   public int val;
   public List<Node> children;


   public Node() {
       children = new ArrayList<Node>();
   }

   public Node(int _val) {
       val = _val;
       children = new ArrayList<Node>();
   }

   public Node(int _val,ArrayList<Node> _children) {
       val = _val;
       children = _children;
   }
};
*/
internal class Solution {
  fun findRoot(tree: List<Node>): Node {
    var x = 0
    for (node in tree) {
      x = x xor node.`val`
      for (child in node.children) {
        x = x xor child.`val`
      }
    }
    var i = 0
    while (true) {
      if (tree[i].`val` === x) {
        return tree[i]
      }
      ++i
    }
  }
}
