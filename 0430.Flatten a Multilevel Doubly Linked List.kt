/*
// Definition for a Node.
class Node {
   public int val;
   public Node prev;
   public Node next;
   public Node child;
};
*/
internal class Solution {
  fun flatten(head: Node?): Node? {
    if (head == null) {
      return null
    }
    val dummy = Node()
    dummy.next = head
    preorder(dummy, head)
    dummy.next.prev = null
    return dummy.next
  }

  private fun preorder(pre: Node, cur: Node?): Node {
    if (cur == null) {
      return pre
    }
    cur.prev = pre
    pre.next = cur

    val t: Node = cur.next
    val tail = preorder(cur, cur.child)
    cur.child = null
    return preorder(tail, t)
  }
}
