import java.util.*

internal class Solution {
  fun canMakePalindromeQueries(s: String, queries: Array<IntArray>): BooleanArray {
    var s = s
    val n = s.length
    val m = n / 2
    val t: String = StringBuilder(s.substring(m)).reverse().toString()
    s = s.substring(0, m)
    val pre1 = Array(m + 1) { IntArray(0) }
    val pre2 = Array(m + 1) { IntArray(0) }
    val diff = IntArray(m + 1)
    pre1[0] = IntArray(26)
    pre2[0] = IntArray(26)
    for (i in 1..m) {
      pre1[i] = pre1[i - 1].clone()
      pre2[i] = pre2[i - 1].clone()
      ++pre1[i][s[i - 1].code - 'a'.code]
      ++pre2[i][t[i - 1].code - 'a'.code]
      diff[i] = diff[i - 1] + (if (s[i - 1] == t[i - 1]) 0 else 1)
    }
    val ans = BooleanArray(queries.size)
    for (i in queries.indices) {
      val q = queries[i]
      val a = q[0]
      val b = q[1]
      val c = n - 1 - q[3]
      val d = n - 1 - q[2]
      ans[i] = if (a <= c)
        check(pre1, pre2, diff, a, b, c, d)
      else
        check(pre2, pre1, diff, c, d, a, b)
    }
    return ans
  }

  private fun check(
    pre1: Array<IntArray>,
    pre2: Array<IntArray>,
    diff: IntArray,
    a: Int,
    b: Int,
    c: Int,
    d: Int
  ): Boolean {
    if (diff[a] > 0 || diff[diff.size - 1] - diff[max(b, d) + 1] > 0) {
      return false
    }
    if (d <= b) {
      return Arrays.equals(count(pre1, a, b), count(pre2, a, b))
    }
    if (b < c) {
      return diff[c] - diff[b + 1] == 0 && Arrays.equals(count(pre1, a, b), count(pre2, a, b))
          && Arrays.equals(count(pre1, c, d), count(pre2, c, d))
    }
    val cnt1 = sub(count(pre1, a, b), count(pre2, a, c - 1))
    val cnt2 = sub(count(pre2, c, d), count(pre1, b + 1, d))
    return cnt1 != null && cnt2 != null && Arrays.equals(cnt1, cnt2)
  }

  private fun count(pre: Array<IntArray>, i: Int, j: Int): IntArray {
    val cnt = IntArray(26)
    for (k in 0..25) {
      cnt[k] = pre[j + 1][k] - pre[i][k]
    }
    return cnt
  }

  private fun sub(cnt1: IntArray, cnt2: IntArray): IntArray? {
    val cnt = IntArray(26)
    for (i in 0..25) {
      cnt[i] = cnt1[i] - cnt2[i]
      if (cnt[i] < 0) {
        return null
      }
    }
    return cnt
  }
}
