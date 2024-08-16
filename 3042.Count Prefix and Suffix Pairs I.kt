internal class Solution {
  fun countPrefixSuffixPairs(words: Array<String>): Int {
    var ans = 0
    val n = words.size
    for (i in 0 until n) {
      val s = words[i]
      for (j in i + 1 until n) {
        val t = words[j]
        if (t.startsWith(s) && t.endsWith(s)) {
          ++ans
        }
      }
    }
    return ans
  }
}
