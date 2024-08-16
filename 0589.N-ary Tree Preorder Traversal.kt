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
  private val ans: List<Int> = ArrayList()

  fun preorder(root: Node?): List<Int> {
    dfs(root)
    return ans
  }

  private fun dfs(root: Node?) {
    if (root == null) {
      return
    }
    ans.add(root.`val`)
    for (child in root.children) {
      dfs(child)
    }
  }
}
