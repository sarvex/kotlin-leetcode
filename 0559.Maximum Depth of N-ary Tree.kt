/*
// Definition for a Node.
class Node {
   public int val;
   public List<Node> children;

   public Node() {}

   public Node(int _val) {
       val = _val;
   }

   public Node(int _val, List<Node> _children) {
       val = _val;
       children = _children;
   }
};
*/
internal class Solution {
  fun maxDepth(root: Node?): Int {
    if (root == null) {
      return 0
    }
    var ans = 1
    for (child in root.children) {
      ans = max(ans, 1 + maxDepth(child))
    }
    return ans
  }
}
