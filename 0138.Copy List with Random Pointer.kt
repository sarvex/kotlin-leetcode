/*
// Definition for a Node.
class Node {
   int val;
   Node next;
   Node random;

   public Node(int val) {
       this.val = val;
       this.next = null;
       this.random = null;
   }
}
*/
internal class Solution {
  fun copyRandomList(head: Node?): Node? {
    val d: Map<Node, Node> = HashMap()
    val dummy = Node(0)
    var tail: Node? = dummy
    run {
      var cur = head
      while (cur != null) {
        tail!!.next = Node(cur!!.`val`)
        tail = tail!!.next
        d.put(cur, tail)
        cur = cur!!.next
      }
    }
    tail = dummy.next
    var cur = head
    while (cur != null) {
      tail.random = d[cur.random]
      tail = tail!!.next
      cur = cur!!.next
    }
    return dummy.next
  }
}
