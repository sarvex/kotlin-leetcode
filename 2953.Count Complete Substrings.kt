internal class Solution {
  fun countCompleteSubstrings(word: String, k: Int): Int {
    val n = word.length
    var ans = 0
    var i = 0
    while (i < n) {
      var j = i + 1
      while (j < n && abs(word[j].code - word[j - 1].code) <= 2) {
        ++j
      }
      ans += f(word.substring(i, j), k)
      i = j
    }
    return ans
  }

  private fun f(s: String, k: Int): Int {
    val m = s.length
    var ans = 0
    var i = 1
    while (i <= 26 && i * k <= m) {
      val l = i * k
      val cnt = IntArray(26)
      for (j in 0 until l) {
        ++cnt[s[j].code - 'a'.code]
      }
      val freq: Map<Int, Int> = HashMap()
      for (x in cnt) {
        if (x > 0) {
          freq.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
        }
      }
      if (freq.getOrDefault(k, 0) === i) {
        ++ans
      }
      for (j in l until m) {
        val a: Int = s[j].code - 'a'.code
        val b: Int = s[j - l].code - 'a'.code
        freq.merge(cnt[a], -1) { a: Int, b: Int -> Integer.sum(a, b) }
        ++cnt[a]
        freq.merge(cnt[a], 1) { a: Int, b: Int -> Integer.sum(a, b) }

        freq.merge(cnt[b], -1) { a: Int, b: Int -> Integer.sum(a, b) }
        --cnt[b]
        freq.merge(cnt[b], 1) { a: Int, b: Int -> Integer.sum(a, b) }
        if (freq.getOrDefault(k, 0) === i) {
          ++ans
        }
      }
      ++i
    }
    return ans
  }
}
