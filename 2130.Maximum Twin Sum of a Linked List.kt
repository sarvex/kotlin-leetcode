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
  fun pairSum(head: ListNode?): Int {
    var head: ListNode? = head
    val s: List<Int> = ArrayList()
    while (head != null) {
      s.add(head.`val`)
      head = head.next
    }
    var ans = 0
    val n: Int = s.size()
    for (i in 0 until (n shr 1)) {
      ans = Math.max(ans, s[i] + s[n - 1 - i])
    }
    return ans
  }
}
