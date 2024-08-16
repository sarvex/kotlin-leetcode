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
  fun cloneTree(root: Node?): Node? {
    if (root == null) {
      return null
    }
    val children: ArrayList<Node> = ArrayList()
    for (child in root.children) {
      children.add(cloneTree(child))
    }
    return Node(root.`val`, children)
  }
}
