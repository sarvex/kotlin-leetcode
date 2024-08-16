import java.util.*

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
  fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
    var head: ListNode? = head
    val ans = Array(m) { IntArray(n) }
    for (row in ans) {
      Arrays.fill(row, -1)
    }
    var i = 0
    var j = 0
    var k = 0
    val dirs = intArrayOf(0, 1, 0, -1, 0)
    while (true) {
      ans[i][j] = head.`val`
      head = head.next
      if (head == null) {
        break
      }
      while (true) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
          i = x
          j = y
          break
        }
        k = (k + 1) % 4
      }
    }
    return ans
  }
}
