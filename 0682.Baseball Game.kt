import java.util.*

internal class Solution {
  fun calPoints(operations: Array<String>): Int {
    val stk: Deque<Int> = ArrayDeque()
    for (op in operations) {
      if ("+" == op) {
        val a = stk.pop()
        val b = stk.peek()
        stk.push(a)
        stk.push(a + b)
      } else if ("D" == op) {
        stk.push(stk.peek() shl 1)
      } else if ("C" == op) {
        stk.pop()
      } else {
        stk.push(op.toInt())
      }
    }
    return stk.stream().mapToInt(Integer::intValue).sum()
  }
}
