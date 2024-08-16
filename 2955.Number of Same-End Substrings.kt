internal class Solution {
  fun sameEndSubstringCount(s: String, queries: Array<IntArray>): IntArray {
    val n = s.length
    val cnt = Array(26) { IntArray(n + 1) }
    for (j in 1..n) {
      for (i in 0..25) {
        cnt[i][j] = cnt[i][j - 1]
      }
      cnt[s[j - 1].code - 'a'.code][j]++
    }
    val m = queries.size
    val ans = IntArray(m)
    for (k in 0 until m) {
      val l = queries[k][0]
      val r = queries[k][1]
      ans[k] = r - l + 1
      for (i in 0..25) {
        val x = cnt[i][r + 1] - cnt[i][l]
        ans[k] += x * (x - 1) / 2
      }
    }
    return ans
  }
}
