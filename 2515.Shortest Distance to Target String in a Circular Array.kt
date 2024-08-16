internal class Solution {
  fun closetTarget(words: Array<String>, target: String, startIndex: Int): Int {
    val n = words.size
    var ans = n
    for (i in 0 until n) {
      val w = words[i]
      if (w == target) {
        val t: Int = abs(i - startIndex)
        ans = min(ans, min(t, n - t))
      }
    }
    return if (ans == n) -1 else ans
  }
}
