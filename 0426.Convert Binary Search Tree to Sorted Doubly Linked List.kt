/*
// Definition for a Node.
class Node {
   public int val;
   public Node left;
   public Node right;

   public Node() {}

   public Node(int _val) {
       val = _val;
   }

   public Node(int _val,Node _left,Node _right) {
       val = _val;
       left = _left;
       right = _right;
   }
};
*/
internal class Solution {
  private var prev: Node? = null
  private var head: Node? = null

  fun treeToDoublyList(root: Node?): Node? {
    if (root == null) {
      return null
    }
    prev = null
    head = null
    dfs(root)
    prev.right = head
    head.left = prev
    return head
  }

  private fun dfs(root: Node?) {
    if (root == null) {
      return
    }
    dfs(root.left)
    if (prev != null) {
      prev.right = root
      root.left = prev
    } else {
      head = root
    }
    prev = root
    dfs(root.right)
  }
}
