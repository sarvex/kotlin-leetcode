/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
  fun hasCycle(head: ListNode?): Boolean {
    var head: ListNode? = head
    val s: Set<ListNode> = HashSet()
    while (head != null) {
      if (!s.add(head)) {
        return true
      }
      head = head.next
    }
    return false
  }
}
