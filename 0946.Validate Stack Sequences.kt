import java.util.*

internal class Solution {
  fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    val stk: Deque<Int> = ArrayDeque()
    var i = 0
    for (x in pushed) {
      stk.push(x)
      while (!stk.isEmpty() && stk.peek() === popped[i]) {
        stk.pop()
        ++i
      }
    }
    return i == popped.size
  }
}
