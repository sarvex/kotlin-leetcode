internal class Solution {
  fun equalCountSubstrings(s: String, count: Int): Int {
    var ans = 0
    val cnt = IntArray(26)
    val n = s.length
    var i = 1
    while (i < 27 && i * count <= n) {
      val k = i * count
      Arrays.fill(cnt, 0)
      var t = 0
      for (j in 0 until n) {
        val a: Int = s[j].code - 'a'.code
        ++cnt[a]
        t += if (cnt[a] == count) 1 else 0
        t -= if (cnt[a] == count + 1) 1 else 0
        if (j - k >= 0) {
          val b: Int = s[j - k].code - 'a'.code
          --cnt[b]
          t += if (cnt[b] == count) 1 else 0
          t -= if (cnt[b] == count - 1) 1 else 0
        }
        ans += if (i == t) 1 else 0
      }
      ++i
    }
    return ans
  }
}
