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
internal class Solution(head: ListNode) {
  private val head: ListNode = head
  private val random: Random = Random()

  fun getRandom(): Int {
    var ans = 0
    var n = 0
    var node: ListNode = head
    while (node != null) {
      ++n
      val x: Int = 1 + random.nextInt(n)
      if (n == x) {
        ans = node.`val`
      }
      node = node.next
    }
    return ans
  }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
