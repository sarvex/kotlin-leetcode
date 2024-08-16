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
  fun modifiedList(nums: IntArray, head: ListNode?): ListNode {
    val s: Set<Int> = HashSet()
    for (x in nums) {
      s.add(x)
    }
    val dummy: ListNode = ListNode(0, head)
    var pre: ListNode = dummy
    while (pre.next != null) {
      if (s.contains(pre.next.`val`)) {
        pre.next = pre.next.next
      } else {
        pre = pre.next
      }
    }
    return dummy.next
  }
}
