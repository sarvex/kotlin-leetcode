internal class Solution {
  fun clearDigits(s: String): String {
    val stk = StringBuilder()
    for (c in s.toCharArray()) {
      if (Character.isDigit(c)) {
        stk.deleteCharAt(stk.length - 1)
      } else {
        stk.append(c)
      }
    }
    return stk.toString()
  }
}
