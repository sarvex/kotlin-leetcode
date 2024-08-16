internal class Solution {
  fun takeCharacters(s: String, k: Int): Int {
    val cnt = IntArray(3)
    val n = s.length
    for (i in 0 until n) {
      ++cnt[s[i].code - 'a'.code]
    }
    for (x in cnt) {
      if (x < k) {
        return -1
      }
    }
    var mx = 0
    var j = 0
    for (i in 0 until n) {
      val c: Int = s[i].code - 'a'.code
      --cnt[c]
      while (cnt[c] < k) {
        ++cnt[s[j++].code - 'a'.code]
      }
      mx = max(mx, i - j + 1)
    }
    return n - mx
  }
}
