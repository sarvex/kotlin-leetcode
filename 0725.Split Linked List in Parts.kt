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
  fun splitListToParts(head: ListNode?, k: Int): Array<ListNode> {
    var n = 0
    run {
      var cur: ListNode? = head
      while (cur != null) {
        ++n
        cur = cur.next
      }
    }
    val cnt = n / k
    val mod = n % k
    val ans: Array<ListNode> = arrayOfNulls<ListNode>(k)
    var cur: ListNode? = head
    var i = 0
    while (i < k && cur != null) {
      ans[i] = cur
      val m = cnt + (if (i < mod) 1 else 0)
      for (j in 1 until m) {
        cur = cur.next
      }
      val nxt: ListNode = cur.next
      cur.next = null
      cur = nxt
      ++i
    }
    return ans
  }
}
