import java.util.*

internal class Solution {
  fun clumsy(n: Int): Int {
    val stk: Deque<Int> = ArrayDeque()
    stk.push(n)
    var k = 0
    for (x in n - 1 downTo 1) {
      if (k == 0) {
        stk.push(stk.pop() * x)
      } else if (k == 1) {
        stk.push(stk.pop() / x)
      } else if (k == 2) {
        stk.push(x)
      } else {
        stk.push(-x)
      }
      k = (k + 1) % 4
    }
    return stk.stream().mapToInt(Integer::intValue).sum()
  }
}
