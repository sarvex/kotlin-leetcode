internal class Solution {
  fun reverseParentheses(s: String): String {
    val stk = StringBuilder()
    for (c in s.toCharArray()) {
      if (c == ')') {
        val t = StringBuilder()
        while (stk[stk.length - 1] != '(') {
          t.append(stk[stk.length - 1])
          stk.deleteCharAt(stk.length - 1)
        }
        stk.deleteCharAt(stk.length - 1)
        stk.append(t)
      } else {
        stk.append(c)
      }
    }
    return stk.toString()
  }
}
