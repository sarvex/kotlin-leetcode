/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
internal class Solution {
  fun swapPairs(head: ListNode?): ListNode? {
    if (head == null || head.next == null) {
      return head
    }
    val t: ListNode? = swapPairs(head.next.next)
    val p: ListNode = head.next
    p.next = head
    head.next = t
    return p
  }
}
