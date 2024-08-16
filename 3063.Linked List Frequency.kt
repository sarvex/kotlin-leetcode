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
  fun frequenciesOfElements(head: ListNode?): ListNode {
    var head: ListNode? = head
    val cnt: Map<Int, Int> = HashMap()
    while (head != null) {
      cnt.merge(head.`val`, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      head = head.next
    }
    val dummy: ListNode = ListNode()
    for (`val` in cnt.values()) {
      dummy.next = ListNode(`val`, dummy.next)
    }
    return dummy.next
  }
}
