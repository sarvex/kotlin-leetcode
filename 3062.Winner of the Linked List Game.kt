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
  fun gameResult(head: ListNode?): String {
    var head: ListNode? = head
    var odd = 0
    var even = 0
    while (head != null) {
      val a: Int = head.`val`
      val b: Int = head.next.`val`
      odd += if (a < b) 1 else 0
      even += if (a > b) 1 else 0
      head = head.next.next
    }
    if (odd > even) {
      return "Odd"
    }
    if (odd < even) {
      return "Even"
    }
    return "Tie"
  }
}
