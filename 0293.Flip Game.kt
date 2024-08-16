internal class Solution {
  fun generatePossibleNextMoves(currentState: String): List<String> {
    val ans: List<String> = ArrayList()
    val s: CharArray = currentState.toCharArray()
    for (i in 0 until s.size - 1) {
      if (s[i] == '+' && s[i + 1] == '+') {
        s[i] = '-'
        s[i + 1] = '-'
        ans.add(String(s))
        s[i] = '+'
        s[i + 1] = '+'
      }
    }
    return ans
  }
}
