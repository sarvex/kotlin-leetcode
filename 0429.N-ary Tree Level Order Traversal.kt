import java.util.*

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
  fun levelOrder(root: Node?): List<List<Int>> {
    var root = root
    val ans: List<List<Int>> = ArrayList()
    if (root == null) {
      return ans
    }
    val q: Deque<Node> = ArrayDeque()
    q.offer(root)
    while (!q.isEmpty()) {
      val t: List<Int> = ArrayList()
      for (n in q.size() downTo 1) {
        root = q.poll()
        t.add(root.`val`)
        q.addAll(root.children)
      }
      ans.add(t)
    }
    return ans
  }
}
