import java.util.*

internal class Solution {
  fun minAddToMakeValid(s: String): Int {
    val stk: Deque<Char> = ArrayDeque()
    for (c in s.toCharArray()) {
      if (c == ')' && !stk.isEmpty() && stk.peek() === '(') {
        stk.pop()
      } else {
        stk.push(c)
      }
    }
    return stk.size()
  }
}
