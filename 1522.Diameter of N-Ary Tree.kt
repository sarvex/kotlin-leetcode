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
  private var ans = 0

  fun diameter(root: Node?): Int {
    ans = 0
    dfs(root)
    return ans
  }

  private fun dfs(root: Node?): Int {
    if (root == null) {
      return 0
    }
    var m1 = 0
    var m2 = 0
    for (child in root.children) {
      val t = dfs(child)
      if (t > m1) {
        m2 = m1
        m1 = t
      } else if (t > m2) {
        m2 = t
      }
    }
    ans = max(ans, m1 + m2)
    return 1 + m1
  }
}
