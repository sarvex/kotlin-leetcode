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
  fun removeNodes(head: ListNode?): ListNode {
    var head: ListNode? = head
    val nums: List<Int> = ArrayList()
    while (head != null) {
      nums.add(head.`val`)
      head = head.next
    }
    val stk: Deque<Int> = ArrayDeque()
    for (v in nums) {
      while (!stk.isEmpty() && stk.peekLast() < v) {
        stk.pollLast()
      }
      stk.offerLast(v)
    }
    val dummy: ListNode = ListNode()
    head = dummy
    while (!stk.isEmpty()) {
      head.next = ListNode(stk.pollFirst())
      head = head.next
    }
    return dummy.next
  }
}
