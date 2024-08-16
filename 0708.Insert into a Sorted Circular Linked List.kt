/*
// Definition for a Node.
class Node {
   public int val;
   public Node next;

   public Node() {}

   public Node(int _val) {
       val = _val;
   }

   public Node(int _val, Node _next) {
       val = _val;
       next = _next;
   }
};
*/
internal class Solution {
  fun insert(head: Node?, insertVal: Int): Node {
    val node = Node(insertVal)
    if (head == null) {
      node.next = node
      return node
    }
    var prev: Node = head
    var curr: Node = head.next!!
    while (curr !== head) {
      if ((prev.`val` <= insertVal && insertVal <= curr.`val`)
        || (prev.`val` > curr.`val` && (insertVal >= prev.`val` || insertVal <= curr.`val`))
      ) {
        break
      }
      prev = curr
      curr = curr.next!!
    }
    prev.next = node
    node.next = curr
    return head
  }
}
