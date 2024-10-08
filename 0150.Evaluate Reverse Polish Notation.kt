import java.util.*

internal class Solution {
  fun evalRPN(tokens: Array<String>): Int {
    val stk: Deque<Int> = ArrayDeque()
    for (t in tokens) {
      if (t.length > 1 || Character.isDigit(t[0])) {
        stk.push(t.toInt())
      } else {
        val y = stk.pop()
        val x = stk.pop()
        when (t) {
          "+" -> stk.push(x + y)
          "-" -> stk.push(x - y)
          "*" -> stk.push(x * y)
          else -> stk.push(x / y)
        }
      }
    }
    return stk.pop()
  }
}
