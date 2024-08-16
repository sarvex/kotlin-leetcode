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
  fun nodesBetweenCriticalPoints(head: ListNode): IntArray {
    var head: ListNode = head
    val ans = intArrayOf(1 shl 30, 0)
    var first = -1
    var last = -1
    var i = 0
    while (head.next.next != null) {
      val a: Int = head.`val`
      val b: Int = head.next.`val`
      val c: Int = head.next.next.`val`
      if (b < min(a, c) || b > max(a, c)) {
        if (last == -1) {
          first = i
          last = i
        } else {
          ans[0] = min(ans[0], i - last)
          last = i
          ans[1] = max(ans[1], last - first)
        }
      }
      head = head.next
      ++i
    }
    return if (first == last) intArrayOf(-1, -1) else ans
  }
}
